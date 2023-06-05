import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
class InventarioAuto:
    autos = []

    def agregarAuto(self, auto):
        self.autos.append(auto)

    def eliminarAuto(self, auto):
        self.autos.remove(auto)

    @staticmethod
    def getAutos():
        return InventarioAuto.autos

    @staticmethod
    def set_autos(autos):
        InventarioAuto.autos = autos

    @staticmethod
    def autosDisponibles():
        cont = 1
        resultado = "Autos Disponibles:\n"
        for auto in InventarioAuto.getAutosDisponibles():
            resultado += f"{cont}. {auto.modelo} {auto.marca} {auto.precio} {auto.color}\n"
            cont += 1
        return resultado

    @staticmethod
    def getAutosDisponibles():
        disponibles = []
        for auto in InventarioAuto.autos:
            if auto.disponible:
                disponibles.append(auto)
        return disponibles

    @staticmethod
    def AutosVendidos(autosinic):
        vendidos = []
        for auto in autosinic:
            if auto.disponible:
                pass
            else:
                vendidos.append(auto)
        return vendidos

    @staticmethod
    def getAutoporModelo(modelo):
        finder = None
        for auto in InventarioAuto.getAutosDisponibles():
            if modelo == auto.modelo:
                finder = auto
            else:
                return finder
        return finder

    @staticmethod
    def getAutosporPrecio(cliente):
        autosPrecio = []
        for auto in InventarioAuto.getAutosDisponibles():
            if cliente.presupuesto >= auto.precio:
                autosPrecio.append(auto)
        autosPrecio.sort(key=lambda x: x.precio)
        return autosPrecio

    @staticmethod
    def getAutosporModelo(modelo):
        modelosInteres = []
        for auto in InventarioAuto.getAutosDisponibles():
            if modelo == auto.modelo:
                modelosInteres.append(auto)
        if len(modelosInteres) == 0:
            print("No existen carros de este modelo disponibles en este momento.")
        return modelosInteres

    @staticmethod
    def readByte():
        num = int(input())
        return num