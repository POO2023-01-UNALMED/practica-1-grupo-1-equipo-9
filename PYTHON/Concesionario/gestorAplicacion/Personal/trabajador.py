from abc import abstractmethod
from Personal import Vendedor


class Trabajador:
    def __init__(self, nombre, cedula, telefono, correo, direccion, salario, banco, cuenta_banco):
        self.nombre = nombre
        self.cedula = cedula
        self.telefono = telefono
        self.correo = correo
        self.direccion = direccion
        self.salario = salario
        self.banco = banco
        self.cuenta_banco = cuenta_banco
    
    def get_nombre(self):
        return self.nombre
    
    def get_cedula(self):
        return self.cedula
    
    def get_telefono(self):
        return self.telefono
    
    def get_correo(self):
        return self.correo
    
    def get_direccion(self):
        return self.direccion
    
    def get_salario(self):
        return self.salario
    
    def get_banco(self):
        return self.banco
    
    def get_cuenta_banco(self):
        return self.cuenta_banco
    
    def set_nombre(self, nombre):
        self.nombre = nombre
    
    def set_cedula(self, cedula):
        self.cedula = cedula
    
    def set_telefono(self, telefono):
        self.telefono = telefono
    
    def set_correo(self, correo):
        self.correo = correo
    
    def set_direccion(self, direccion):
        self.direccion = direccion
    
    def set_salario(self, salario):
        self.salario = salario
    
    def set_banco(self, banco):
        self.banco = banco
    
    def set_cuenta_banco(self, cuenta_banco):
        self.cuenta_banco = cuenta_banco
    
    @staticmethod
    def pago(mec):
        mec.set_salario(mec.get_mano_obra() + mec.get_salario())
    
    @staticmethod
    def pago_vendedor_auto(vend, auto):
        vend.set_salario(vend.get_salario() + (auto.get_precio() * Vendedor.COMISION))
    
    @staticmethod
    def pago_vendedor_articulo(vend, articulo):
        vend.set_salario(vend.get_salario() + (articulo.get_precio() * Vendedor.COMISION))
    
    @abstractmethod
    def calcular_salario(self):
        pass
