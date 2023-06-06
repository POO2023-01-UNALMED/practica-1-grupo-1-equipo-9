import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)


from persona import Persona

class Cliente(Persona):
    clientes = []

    def __init__(self, nombre, cedula, telefono, correo, modeloInteres, presupuesto, direccion="Medellin"):
        self.nombre = nombre
        self.cedula = cedula
        self.telefono = telefono
        self.correo = correo
        self.direccion = direccion
        self.modeloInteres = modeloInteres
        self.presupuesto = presupuesto
        Cliente.clientes.append(self)

    def get_modeloInteres(self):
        return self.modeloInteres

    def get_presupuesto(self):
        return self.presupuesto

    def set_modeloInteres(self, modeloInteres):
        self.modeloInteres = modeloInteres

    def set_presupuesto(self, presupuesto):
        self.presupuesto = presupuesto

    def set_auto(self, auto):
        self.auto = auto

    def getAuto(self):
        return self.auto

    @classmethod
    def getClientes(cls):
        return Cliente.clientes

    @staticmethod
    def getClientePorCedula(cedula):
        finder=None
        for cliente in Cliente.clientes:
            if cliente.get_cedula() == cedula:
                finder = cliente
                break
        return finder

    def set_clientes(client):
        Cliente.clientes = client

    def info(self):
        texto = "Nombre del cliente: " + self.get_nombre() + "\n"
        return texto
    
    def get_cedula(self):
        return self.cedula

    def get_correo(self):
        return self.correo

    def get_direccion(self):
        return self.direccion

    def get_nombre(self):
        return self.nombre

    def get_telefono(self):
        return self.telefono

    def set_cedula(self, cedula):
        self.cedula = cedula

    def set_correo(self, correo):
        self.correo = correo

    def set_direccion(self, direccion):
        self.direccion = direccion

    def set_nombre(self, nombre):
        self.nombre = nombre

    def set_telefono(self, telefono):
        self.telefono = telefono