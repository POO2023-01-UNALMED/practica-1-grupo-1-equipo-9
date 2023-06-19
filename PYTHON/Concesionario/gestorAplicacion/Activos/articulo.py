import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
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
            Articulo.articulos.append(self)
            
        elif tipo == "repuesto":
            Articulo.repuestos.append(self)
            
    @classmethod
    def get_articulos(cls):
        return cls.articulos
    @classmethod
    def get_repuesto(cls):
        return cls.repuestos
    
    @classmethod
    def set_articulos(cls,Articulos):
        cls.articulos = Articulos

    @classmethod
    def set_repuestos(cls,repuestos):
        cls.repuestos = repuestos

    def set_tipoArticulo(self, tipoArticulo):
        self.tipoArticulo = tipoArticulo

    def get_tipoArticulo(self):
        return self.tipoArticulo

    def set_tipoVehiculo(self, tipoVehiculo):
        self.tipoVehiculo = tipoVehiculo

    def get_tipoVehiculo(self):
        return self.tipoVehiculo

    def set_precio(self, precio):
        self.precio = precio

    def get_precio(self):
        return self.precio

    def set_marca(self, marca):
        self.marca = marca

    def get_marca(self):
        return self.marca

    def articulos_disponibles(self):
        informacion = f"{self.tipoArticulo} {self.tipoVehiculo} {self.marca} {self.precio}\n"
        return informacion

    def set_cantidad(self, cantidad):
        self.cantidad = cantidad

    def get_cantidad(self):
        return self.cantidad

    def set_especialidad(self, especialidad):
        self.especialidad = especialidad

    def get_especialidad(self):
        return self.especialidad

    def info(self):
        texto = "Producto: " + self.get_tipoArticulo() + "\n"
        return texto

    def set_tipo(self, tipo):
        self.tipo = tipo

    def get_tipo(self):
        return self.tipo

    def set_calidad(self, calidad):
        self.calidad = calidad

    def get_calidad(self):
        return self.calidad

    def set_marcaVehiculo(self, marcaVehiculo):
        self.marcaVehiculo = marcaVehiculo

    def get_marcaVehiculo(self):
        return self.marcaVehiculo

    def set_referencia(self, referencia):
        self.referencia = referencia

    def get_referencia(self):
        return self.referencia

    @staticmethod
    def get_articuloPorReferencia(referencia):
        for articulo in Articulo.articulos:
            if articulo.get_referencia() == referencia:
                return articulo
        return None

    @staticmethod
    def get_repuestoPorReferencia(referencia):
        for articulo in Articulo.repuestos:
            if articulo.get_referencia() == referencia:
                return articulo
        return None
