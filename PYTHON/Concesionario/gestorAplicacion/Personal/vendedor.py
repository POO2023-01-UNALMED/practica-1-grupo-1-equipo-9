import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
from gestorAplicacion.Activos.articulo import Articulo
from trabajador import Trabajador
from gestorAplicacion.Activos.transaccionventa import TransaccionVenta
from gestorAplicacion.Activos.transaccionVentaTaller import TransaccionVentaTaller
from gestorAplicacion.Activos.TransaccionTaller import TransaccionTaller
from gestorAplicacion.Activos.TransaccionModificacion import TransaccionModificacion
from gestorAplicacion.Activos.auto import Auto
from gestorAplicacion.Personal.mecanico import Mecanico

class Vendedor(Trabajador):
    vendedores = []
    COMISION = 0.02

    def __init__(self, nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco, puesto):
        super().__init__(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco)
        self.puesto = puesto
        self.ventas = 0
        Vendedor.vendedores.append(self)

    @classmethod
    def get_vendedores(cls):
        return cls.vendedores
    @classmethod
    def set_vendedores(cls,vendedo):
        cls.vendedores=vendedo
        

    @staticmethod
    def get_vendedorPorCedula(cedula):
        for vendedor in Vendedor.vendedores:
            if vendedor.get_cedula() == cedula:
                return vendedor
        return None

    @staticmethod
    def add_vendedor(vendedor):
        Vendedor.vendedores.append(vendedor)

    @staticmethod
    def remove_vendedor(vendedor):
        Vendedor.vendedores.remove(vendedor)

    def get_puesto(self):
        return self.puesto
    
    def set_puesto(self, puesto):
        self.puesto = puesto

    def calcular_salario(self):
        return int(self.getSalario() + (self.ventas * Vendedor.COMISION))

    def info(self):
        texto = "Nombre del Vendedor: " + self.get_nombre() + "\n"
        return texto

    def confirmar_venta(self):
        self.ventas += 1

    @staticmethod
    def selector_vend(o):
        vende = None
        vendedores = []
        if isinstance(o, Auto):
            vende = "Vitrina"
        elif isinstance(o, Articulo):
            vende = "Repuestos"
        for vendedor in Vendedor.get_vendedores():
            if vende == vendedor.get_puesto():
                vendedores.append(vendedor)
        return vendedores

    def get_nombre(self):
        return self.nombre

    def get_cedula(self):
        return self.cedula

    def get_telefono(self):
        return self.telefono

    def get_correo(self):
        return self.correo

    def get_direccion(self):
        return self.direccion

    def set_nombre(self, nombre):
        self.nombre = nombre

    def set_cedula(self, cedula):
        self.cedula = cedula

    def set_telefono(self, telefono):
        self.telefono = telefono

    def set_correo(self, correo):
        self.correo = correo

    def set_direccion(self, direccion):
        self.direccion = direccion
    @staticmethod
    def estResults(listaFinanzas):
        ventasautos = sum(transaccauto.get_ingreso() for transaccauto in TransaccionVenta.get_transaccionesven())
        ventastaller = sum(transacctaller.get_ingreso() for transacctaller in TransaccionTaller.get_transaccionestal())
        arttaller = sum(t.get_ingreso() for t in TransaccionVentaTaller.get_transaccionesvental())
        transaccmod = sum(m.get_ingreso() for m in TransaccionModificacion.get_transaccionesmod())

        ventas = ventasautos + ventastaller + arttaller + transaccmod
        listaFinanzas[0] = ventas

        pagoEmpleados = sum(vendedor.get_salario() for vendedor in Vendedor.get_vendedores())
        pagoEmpleados += sum(mecanico.get_salario() for mecanico in Mecanico.get_mecanicos())
        listaFinanzas[1] = pagoEmpleados

        gastos = ventasautos * 0.02 + 10000000 + 7000000
        listaFinanzas[2] = gastos

        if ventas - pagoEmpleados - gastos < 0:
            listaFinanzas[3] = int((ventas - pagoEmpleados - gastos) * 0.33 * -1)
        else:
            listaFinanzas[3] = int((ventas - pagoEmpleados - gastos) * 0.33)

        return listaFinanzas

