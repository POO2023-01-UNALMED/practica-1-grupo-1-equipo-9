import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
from transaccion import Transaccion
class TransaccionVentaTaller(Transaccion):
    transaccionesvental = []

    def __init__(self, tipo, ingreso, cliente, articulo, vendedor, transfer):
        super().__init__(tipo, ingreso, cliente, transfer)
        self.articulo = articulo
        self.vendedor = vendedor
        TransaccionVentaTaller.transaccionesvental.append(self)

    def info(self):
        txt = f"Transacción #{self.transfer:08d}: venta realizada por {self.vendedor.get_nombre()} para el cliente {self.cliente.get_nombre()} por un total de ${self.articulo.get_precio()} por el artículo {self.articulo.get_marca()}"
        return txt

    @staticmethod
    def get_clientePorCedula(cedula):
        finder = None
        cli = None

        for trans in TransaccionVentaTaller.transaccionesvental:
            if trans.get_clienteCed() == cedula:
                finder = trans
                cli = finder.get_cliente()
                break

        return cli

    @staticmethod
    def get_transaccionporCedula(cedula):
        finder = None

        for trans in TransaccionVentaTaller.transaccionesvental:
            if trans.get_clienteCed() == cedula:
                finder = trans.get_articulo()
                break

        return finder

    def set_articulo(self, articulo):
        self.articulo = articulo

    def get_articulo(self):
        return self.articulo

    def set_vendedor(self, vendedor):
        self.vendedor = vendedor

    def get_vendedor(self):
        return self.vendedor

    @staticmethod
    def agregar_transaccion(transaccion):
        TransaccionVentaTaller.transaccionesvental.append(transaccion)

    @staticmethod
    def eliminar_transaccion(transaccion):
        TransaccionVentaTaller.transaccionesvental.remove(transaccion)

    @classmethod
    def get_transaccionesvental(cls):
        return cls.transaccionesvental
    @classmethod
    def set_transaccionesvental(cls,transss):
        cls.transaccionesvental=transss