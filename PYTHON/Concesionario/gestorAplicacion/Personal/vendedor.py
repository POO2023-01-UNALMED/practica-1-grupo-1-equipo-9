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
from Activos.auto import Auto
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

