import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
from Personal.cliente import Cliente


class Auto:
    autos=[]
    #revisar
    class MarcaAuto():
        TOYOTA = 1
        CHEVROLET = 2
        MAZDA = 3
    

    def __init__(self, modelo, marca, precio, cilindraje, color, fullEquipo, disponible, llantas, suspension, sonido, escape,dueno=None):
        self.llantas = llantas
        self.suspension = suspension
        self.sonido = sonido
        self.escape = escape
        self.modelo = modelo
        self.marca = marca
        self.precio = precio
        self.cilindraje = cilindraje
        self.color = color
        self.fullEquipo = fullEquipo
        self.disponible = disponible
        self.dueno = dueno
        Auto.autos.append(self)
        
    @classmethod
    def get_autos(cls):
        return cls.autos

    @classmethod
    def set_autos(cls,aut):
        cls.autos = aut
    
    def get_modelo(self):
        return self.modelo

    def get_marca(self):
        return self.marca

    def get_precio(self):
        return self.precio

    def get_cilindraje(self):
        return self.cilindraje

    def get_color(self):
        return self.color

    def is_full_equipo(self):
        return self.fullEquipo

    def get_dueno(self):
        return self.dueno

    def set_dueno(self, dueno):
        self.dueno = dueno

    def set_modelo(self, modelo):
        self.modelo = modelo

    def set_marca(self, marca):
        self.marca = marca

    def set_precio(self, precio):
        self.precio = precio

    def set_cilindraje(self, cilindraje):
        self.cilindraje = cilindraje

    def set_color(self, color):
        self.color = color

    def set_full_equipo(self, fullEquipo):
        self.fullEquipo = fullEquipo

    def is_disponible(self):
        return self.disponible

    def set_disponible(self, disponible):
        self.disponible = disponible

    def info(self):
        fullEquipoStr = "Fullequipo" if self.fullEquipo else "No Fullequipo"
        return f"Datos del Carro: Modelo {self.modelo}, Marca {self.marca}, Precio {self.precio}, Color {self.color}, {fullEquipoStr}"

    def get_llantas(self):
        return self.llantas

    def set_llantas(self, llantas):
        self.llantas = llantas

    def get_suspension(self):
        return self.suspension

    def set_suspension(self, suspension):
        self.suspension = suspension

    def get_sonido(self):
        return self.sonido

    def set_sonido(self, sonido):
        self.sonido = sonido

    def get_escape(self):
        return self.escape

    def set_escape(self, escape):
        self.escape = escape
    @staticmethod
    def get_autos_disponibles():
        disponibles = []
        for auto in Auto.autos:
            if auto.disponible:
                disponibles.append(auto)
        return disponibles

class Sortbyroll:
    def compare(self, a, b):
        return int(b.get_precio() - a.get_precio())
