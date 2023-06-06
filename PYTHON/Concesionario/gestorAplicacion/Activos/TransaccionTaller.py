import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
from transaccion import Transaccion
class TransaccionTaller(Transaccion):
    transaccionestal = []

    def __init__(self, tipo, ingreso, cliente, auto, articulo, mecanico, transfer):
        super().__init__(tipo, ingreso, cliente, transfer)
        self.auto = auto
        self.mecanico = mecanico
        self.articulo = articulo
        TransaccionTaller.transaccionestal.append(self)

    def info(self):
        txt = f"Transacción #{self.transfer:08d}: {self.tipo} realizado por {self.mecanico.nombre} para el cliente {self.cliente.nombre} por un total de ${self.ingreso}"
        return txt

    @staticmethod
    def get_clientePorCedula(cedula):
        finder = None
        cli = None

        for trans in TransaccionTaller.transaccionestal:
            if trans.get_clienteCed() == cedula:
                finder = trans
                cli = finder.get_cliente()
                break

        return cli

    @staticmethod
    def get_transaccionporCedula(cedula):
        finder = None

        for trans in TransaccionTaller.transaccionestal:
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
        TransaccionTaller.transaccionestal.append(transaccion)

    @staticmethod
    def eliminar_transaccion(transaccion):
        TransaccionTaller.transaccionestal.remove(transaccion)

    @staticmethod
    def get_transaccionestal():
        return TransaccionTaller.transaccionestal
    @staticmethod
    def set_transaccionestal(pp):
        TransaccionTaller.transaccionestal=pp