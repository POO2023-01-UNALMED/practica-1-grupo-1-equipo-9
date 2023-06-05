import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
from transaccion import Transaccion

class TransaccionModificacion(Transaccion):
    transaccionesmod = []

    def __init__(self, tipo, ingreso, cliente, auto, articulo, transfer, mecanico=None,vendedor=None):
        super().__init__(tipo, ingreso, cliente, transfer)
        self.auto = auto
        self.mecanico = mecanico
        self.vendedor = vendedor
        self.articulo = articulo
        TransaccionModificacion.transaccionesmod.append(self)


    def info(self):
        txt = f"Transacción #{self.transfer:08d}: venta realizada por {self.vendedor.nombre} para el cliente {self.cliente.nombre} que adquirió el producto: {self.articulo.tipoArticulo} de la marca: {self.articulo.marca}, con precio total ${self.articulo.precio}"
        return txt

    def info2(self):
        txt = f"Transacción #{self.transfer:08d}: taller realizado por {self.mecanico.nombre} para el cliente {self.cliente.nombre} que adquirió el producto: {self.articulo.tipoArticulo} de la marca: {self.articulo.marca}, con precio total ${self.articulo.precio}"
        return txt

    @staticmethod
    def getClientePorCedula(cedula):
        finder = None
        client = None

        for trans in TransaccionModificacion.transaccionesmod:
            if trans.getClienteCed() == cedula:
                finder = trans
                client = finder.getCliente()
                break

        return client

    @staticmethod
    def getTransaccionporCedula(cedula):
        finder = None

        for trans in TransaccionModificacion.transaccionesmod:
            if trans.getClienteCed() == cedula:
                finder = trans.getAuto()
                break

        return finder

    def set_auto(self, auto):
        self.auto = auto

    def getAuto(self):
        return self.auto

    def setMecanico(self, mecanico):
        self.mecanico = mecanico

    def getMecanico(self):
        return self.mecanico

    def setArticulo(self, articulo):
        self.articulo = articulo

    def getArticulo(self):
        return self.articulo

    @staticmethod
    def agregarTransaccion(transaccion):
        TransaccionModificacion.transaccionesmod.append(transaccion)

    @staticmethod
    def eliminarTransaccion(transaccion):
        TransaccionModificacion.transaccionesmod.remove(transaccion)

    @staticmethod
    def getTransaccionesmod():
        return TransaccionModificacion.transaccionesmod

    def getVendedor(self):
        return self.vendedor

    def setVendedor(self, vendedor):
        self.vendedor = vendedor