import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
from Activos import articulo
from trabajador import Trabajador
from gestorAplicacion.Activos.transaccionventa import TransaccionVenta
from gestorAplicacion.Activos.transaccionVentaTaller import TransaccionVentaTaller
from gestorAplicacion.Activos.TransaccionTaller import TransaccionTaller
from gestorAplicacion.Activos.TransaccionModificacion import TransaccionModificacion
from Activos.auto import Auto
from mecanico import Mecanico

class Vendedor(Trabajador):
    vendedores = []
    COMISION = 0.02

    def __init__(self, nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco, puesto):
        super().__init__(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco)
        self.puesto = puesto
        Vendedor.vendedores.append(self)

    @classmethod
    def getVendedores(cls):
        return cls.vendedores

    @staticmethod
    def getVendedorPorCedula(cedula):
        for vendedor in Vendedor.vendedores:
            if vendedor.getCedula() == cedula:
                return vendedor
        return None

    @staticmethod
    def addVendedor(vendedor):
        Vendedor.vendedores.append(vendedor)

    @staticmethod
    def removeVendedor(vendedor):
        Vendedor.vendedores.remove(vendedor)

    def getPuesto(self):
        return self.puesto

    def setPuesto(self, puesto):
        self.puesto = puesto

    def calcularSalario(self):
        return int(self.getSalario() + (self.ventas * Vendedor.COMISION))

    def info(self):
        texto = "Nombre del Vendedor: " + self.getNombre() + "\n"
        return texto

    def confirmarVenta(self):
        self.ventas += 1

    @staticmethod
    def selectorVend(o):
        vende = None
        vendedores = []
        if isinstance(o, Auto):
            vende = "Vitrina"
        elif isinstance(o, articulo):
            vende = "Repuestos"
        for vendedor in Vendedor.getVendedores():
            if vende == vendedor.getPuesto():
                vendedores.append(vendedor)
        return vendedores

    def getNombre(self):
        return self.nombre

    def getCedula(self):
        return self.cedula

    def getTelefono(self):
        return self.telefono

    def getCorreo(self):
        return self.correo

    def getDireccion(self):
        return self.direccion

    def setNombre(self, nombre):
        self.nombre = nombre

    def setCedula(self, cedula):
        self.cedula = cedula

    def setTelefono(self, telefono):
        self.telefono = telefono

    def setCorreo(self, correo):
        self.correo = correo

    def setDireccion(self, direccion):
        self.direccion = direccion
    @staticmethod
    def estResults(listaFinanzas):
        ventasautos = sum(transaccauto.getIngreso() for transaccauto in TransaccionVenta.getTransaccionesven())
        ventastaller = sum(transacctaller.getIngreso() for transacctaller in TransaccionTaller.getTransaccionestal())
        arttaller = sum(t.getIngreso() for t in TransaccionVentaTaller.getTransaccionesven())
        transaccmod = sum(m.getIngreso() for m in TransaccionModificacion.getTransaccionesmod())

        ventas = ventasautos + ventastaller + arttaller + transaccmod
        listaFinanzas[0] = ventas

        pagoEmpleados = sum(vendedor.getSalario() for vendedor in Vendedor.getVendedores())
        pagoEmpleados += sum(mecanico.getSalario() for mecanico in Mecanico.getMecanicos())
        listaFinanzas[1] = pagoEmpleados

        gastos = ventasautos * 0.02 + 10000000 + 7000000
        listaFinanzas[2] = gastos

        if ventas - pagoEmpleados - gastos < 0:
            listaFinanzas[3] = int((ventas - pagoEmpleados - gastos) * 0.33 * -1)
        else:
            listaFinanzas[3] = int((ventas - pagoEmpleados - gastos) * 0.33)

        return listaFinanzas

