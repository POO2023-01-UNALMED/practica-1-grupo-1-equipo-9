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
    def getTransaccionPorTransfer(transfer):
        for t in Transaccion.transacciones:
            if t.getTransfer() == transfer:
                return t
        return None

    @staticmethod
    def getTransacciones():
        return Transaccion.transacciones

    def setTipo(self, tipo):
        self.tipo = tipo

    def setMecanico(self, mecanico):
        self.mecanico = mecanico

    def setIngreso(self, ingreso):
        self.ingreso = ingreso

    def setCliente(self, cliente):
        self.cliente = cliente

    def getipo(self):
        return self.tipo

    def setTransfer(self, transfer):
        self.transfer = transfer

    def getTransfer(self):
        return self.transfer

    def getMecanico(self):
        return self.mecanico

    def getIngreso(self):
        return self.ingreso

    def getCliente(self):
        return self.cliente

    def getClienteCed(self):
        return self.cliente.getCedula()

    @staticmethod
    def getNumtrans():
        return Transaccion.numtrans

    @staticmethod
    def setNumtrans(numtrans):
        Transaccion.numtrans = numtrans


    @abstractmethod
    def info(self):
        pass
