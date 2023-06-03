import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
from inventario_articulo import Inventario_Articulo
class Articulo:
    articulos = []
    repuestos = []

    def __init__(self, calidad, tipo, especialidad, tipoArticulo, tipoVehiculo, marca, precio, cantidad, referencia, marcaVehiculo="Generico"):
        self.marcaVehiculo = marcaVehiculo 
        self.calidad = calidad
        self.tipo = tipo
        self.tipoArticulo = tipoArticulo
        self.especialidad = especialidad
        self.tipoVehiculo = tipoVehiculo
        self.precio = precio
        self.marca = marca
        self.cantidad = cantidad
        self.referencia = referencia

        if tipo == "taller":
            Inventario_Articulo.articulos.append(self)
            self.marcaVehiculo = "Generico"
        elif tipo == "repuesto":
            Inventario_Articulo.repuestos.append(self)
            self.marcaVehiculo = "Generico"

    def setTipoArticulo(self, tipoArticulo):
        self.tipoArticulo = tipoArticulo

    def getTipoArticulo(self):
        return self.tipoArticulo

    def setTipoVehiculo(self, tipoVehiculo):
        self.tipoVehiculo = tipoVehiculo

    def getTipoVehiculo(self):
        return self.tipoVehiculo

    def setPrecio(self, precio):
        self.precio = precio

    def getPrecio(self):
        return self.precio

    def setMarca(self, marca):
        self.marca = marca

    def getMarca(self):
        return self.marca

    def articulosDisponibles(self):
        informacion = f"{self.tipoArticulo} {self.tipoVehiculo} {self.marca} {self.precio}\n"
        return informacion

    def setCantidad(self, cantidad):
        self.cantidad = cantidad

    def getCantidad(self):
        return self.cantidad

    def setEspecialidad(self, especialidad):
        self.especialidad = especialidad

    def getEspecialidad(self):
        return self.especialidad

    def info(self):
        texto = "Producto: " + self.getTipoArticulo() + "\n"
        return texto

    def setTipo(self, tipo):
        self.tipo = tipo

    def getTipo(self):
        return self.tipo

    def setCalidad(self, calidad):
        self.calidad = calidad

    def getCalidad(self):
        return self.calidad

    def setMarcaVehiculo(self, marcaVehiculo):
        self.marcaVehiculo = marcaVehiculo

    def getMarcaVehiculo(self):
        return self.marcaVehiculo

    def setReferencia(self, referencia):
        self.referencia = referencia

    def getReferencia(self):
        return self.referencia

    @staticmethod
    def getArticuloPorReferencia(referencia):
        for articulo in Inventario_Articulo.articulos:
            if articulo.getReferencia() == referencia:
                return articulo
        return None

    @staticmethod
    def getRepuestoPorReferencia(referencia):
        for articulo in Inventario_Articulo.repuestos:
            if articulo.getReferencia() == referencia:
                return articulo
        return None
