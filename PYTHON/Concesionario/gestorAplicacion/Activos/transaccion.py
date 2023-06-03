from abc import ABC, abstractmethod
import sys
sys.path.append('C:\\Users\\felip\\OneDrive\\Documentos\\GitHub\\practica-1-grupo-1-equipo-9\\PYTHON\\Concesionario\\gestorAplicacion\\Personal')
sys.path.append('C:\\Users\\felip\\OneDrive\\Documentos\\GitHub\\practica-1-grupo-1-equipo-9\\PYTHON\\Concesionario\\gestorAplicacion\\Activos')
from transaccionventa import TransaccionVenta
from transaccionVentaTaller import TransaccionVentaTaller
from TransaccionTaller import TransaccionTaller
from TransaccionModificacion import TransaccionModificacion
from Personal.mecanico import Mecanico
from Personal.vendedor import Vendedor


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

    def getTipo(self):
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

    @abstractmethod
    def info(self):
        pass
