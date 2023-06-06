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
    def get_clientePorCedula(cedula):
        finder = None
        client = None

        for trans in TransaccionModificacion.transaccionesmod:
            if trans.get_clienteCed() == cedula:
                finder = trans
                client = finder.get_cliente()
                break

        return client

    @staticmethod
    def get_transaccionporCedula(cedula):
        finder = None

        for trans in TransaccionModificacion.transaccionesmod:
            if trans.get_clienteCed() == cedula:
                finder = trans.get_auto()
                break

        return finder

    def set_auto(self, auto):
        self.auto = auto

    def get_auto(self):
        return self.auto

    def set_mecanico(self, mecanico):
        self.mecanico = mecanico

    def get_mecanico(self):
        return self.mecanico

    def set_articulo(self, articulo):
        self.articulo = articulo

    def get_articulo(self):
        return self.articulo

    @staticmethod
    def agregar_transaccion(transaccion):
        TransaccionModificacion.transaccionesmod.append(transaccion)

    @staticmethod
    def eliminar_transaccion(transaccion):
        TransaccionModificacion.transaccionesmod.remove(transaccion)

    @staticmethod
    def get_transaccionesmod():
        return TransaccionModificacion.transaccionesmod
    @staticmethod
    def set_transaccionesmod(qq):
        TransaccionModificacion.transaccionesmod=qq

    def get_vendedor(self):
        return self.vendedor

    def set_vendedor(self, vendedor):
        self.vendedor = vendedor