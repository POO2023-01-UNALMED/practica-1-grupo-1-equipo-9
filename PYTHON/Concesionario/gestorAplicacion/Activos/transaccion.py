from abc import ABC, abstractmethod
import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)

class Transaccion(ABC):
    transacciones = []
    numtrans = "00000001"

    def __init__(self, tipo, ingreso, cliente, transfer):
        self.tipo = tipo
        self.ingreso = ingreso
        self.cliente = cliente
        self.transfer = transfer
        Transaccion.transacciones.append(self)
        self.numtrans = str(int(Transaccion.numtrans) + 1).zfill(8)

    @staticmethod
    def get_transaccionPorTransfer(transfer):
        for t in Transaccion.transacciones:
            if t.get_transfer() == transfer:
                return t
        return None

    @classmethod
    def get_transacciones(cls):
        return cls.transacciones
    @classmethod
    def set_transacciones(cls,transacc):
        cls.transacciones=transacc

    def set_tipo(self, tipo):
        self.tipo = tipo

    def set_mecanico(self, mecanico):
        self.mecanico = mecanico

    def set_ingreso(self, ingreso):
        self.ingreso = ingreso

    def set_cliente(self, cliente):
        self.cliente = cliente

    def ge_tipo(self):
        return self.tipo

    def set_transfer(self, transfer):
        self.transfer = transfer

    def get_transfer(self):
        return self.transfer

    def get_mecanico(self):
        return self.mecanico

    def get_ingreso(self):
        return self.ingreso

    def get_cliente(self):
        return self.cliente

    def get_clienteCed(self):
        return self.cliente.get_cedula()

    @staticmethod
    def get_numtrans():
        return Transaccion.numtrans

    @staticmethod
    def set_numtrans(numtrans):
        Transaccion.numtrans = numtrans


    @abstractmethod
    def info(self):
        pass
