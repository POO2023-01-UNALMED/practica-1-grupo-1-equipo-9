import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
from Activos.auto import Auto
class InventarioAuto:
    autos = []

    def agregarAuto(self, auto):
        self.autos.append(auto)

    def eliminarAuto(self, auto):
        self.autos.remove(auto)

    @classmethod
    def get_autos(cls):
        return cls.autos

    @classmethod
    def set_autos(cls,aut):
        cls.autos = aut

    @staticmethod
    def autos_disponibles():
        cont = 1
        resultado = "Autos Disponibles:\n"
        for auto in InventarioAuto.get_autos_disponibles():
            resultado += f"{cont}. {auto.modelo} {auto.marca} {auto.precio} {auto.color}\n"
            cont += 1
        return resultado

    @staticmethod
    def get_autos_disponibles():
        disponibles = []
        for auto in Auto.autos:
            if auto.disponible:
                disponibles.append(auto)
        return disponibles

    @staticmethod
    def autos_vendidos(autosinic):
        vendidos = []
        for auto in autosinic:
            if auto.disponible:
                pass
            else:
                vendidos.append(auto)
        return vendidos

    @staticmethod
    def get_autoporModelo(modelo):
        finder = None
        for auto in InventarioAuto.get_autos_disponibles():
            if modelo == auto.modelo:
                finder = auto
            else:
                return finder
        return finder

    @staticmethod
    def get_autosporPrecio(cliente):
        autosPrecio = []
        for auto in InventarioAuto.get_autos_disponibles():
            if cliente.presupuesto >= auto.precio:
                autosPrecio.append(auto)
        autosPrecio.sort(key=lambda x: x.precio)
        return autosPrecio

    @staticmethod
    def get_autosporModelo(modelo):
        modelosInteres = []
        for auto in InventarioAuto.get_autos_disponibles():
            if modelo == auto.marca:
                modelosInteres.append(auto)
        if len(modelosInteres) == 0:
            print("No existen carros de este modelo disponibles en este momento.")
        return modelosInteres

    @staticmethod
    def readByte():
        num = int(input())
        return num