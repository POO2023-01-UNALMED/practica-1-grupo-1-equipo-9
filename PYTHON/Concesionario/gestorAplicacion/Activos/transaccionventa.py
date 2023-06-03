import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
from Personal import cliente, vendedor
from transaccion import Transaccion

class TransaccionVenta(Transaccion):
    transaccionesven = []
    autosV = []
    vend = []
    marcas = []

    def __init__(self, tipo, ingreso, cliente, auto, vendedor, transfer):
        super().__init__(tipo, ingreso, cliente, transfer)
        self.auto = auto
        self.vendedor = vendedor
        TransaccionVenta.transaccionesven.append(self)
        TransaccionVenta.autosV.append(self.auto)
    
    def info(self):
        txt = f"Transacción #{self.transfer:08d}: venta realizada por {self.vendedor.get_nombre()} para el cliente {self.cliente.get_nombre()} por un total de ${self.auto.get_precio()} por el auto {self.auto.get_modelo()}"
        return txt
    
    @staticmethod
    def get_cliente_por_cedula(cedula):
        finder = None
        cli = None

        for trans in TransaccionVenta.transaccionesven:
            if trans.getClienteCed() == cedula:
                finder = trans
                cli = finder.getCliente()
                break

        return cli
    
    @staticmethod
    def get_transaccion_por_cedula(cedula):
        finder = None
        for trans in TransaccionVenta.transaccionesven:
            if trans.get_cliente_ced() == cedula:
                finder = trans.get_auto()
                break
        return finder

    def set_auto(self, auto):
        self.auto = auto

    def get_auto(self):
        return self.auto
    
    def set_vendedor(self, vendedor):
        self.vendedor = vendedor
    
    def get_vendedor(self):
        return self.vendedor
    
    @staticmethod
    def agregar_transaccion(transaccion):
        TransaccionVenta.transaccionesven.append(transaccion)
    
    @staticmethod
    def eliminar_transaccion(transaccion):
        TransaccionVenta.transaccionesven.remove(transaccion)
    
    @staticmethod
    def get_transaccionesven():
        return TransaccionVenta.transaccionesven
    
    @staticmethod
    def vendedores_ventas(ventas):
        for transacc in ventas:
            if transacc.get_vendedor() not in TransaccionVenta.vend:
                TransaccionVenta.vend.append(transacc.get_vendedor())
        return TransaccionVenta.vend
    
    @staticmethod
    def marcas_ventas(autos_iniciales):
        for a in autos_iniciales:
            if a.get_marca() not in TransaccionVenta.marcas:
                TransaccionVenta.marcas.append(a.get_marca())
        return TransaccionVenta.marcas
    
    @staticmethod
    def get_autosV():
        return TransaccionVenta.autosV
    
    @staticmethod
    def get_ingreso_por_auto(auto):
        for transacc in TransaccionVenta.get_transaccionesven():
            if transacc.get_auto() == auto:
                return transacc.get_ingreso()
        return 0
    
    @staticmethod
    def get_vend():
        return TransaccionVenta.vend
    
    @staticmethod
    def set_vend(vendedores):
        TransaccionVenta.vend = vendedores
    
    @staticmethod
    def get_marcas():
        return TransaccionVenta.marcas
    
    @staticmethod
    def set_marcas(lista_marcas):
        TransaccionVenta.marcas = lista_marcas
