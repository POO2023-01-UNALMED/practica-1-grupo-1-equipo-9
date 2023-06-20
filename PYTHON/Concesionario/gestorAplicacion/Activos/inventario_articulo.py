import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
from gestorAplicacion.Activos.articulo import Articulo
class Inventario_Articulo:
    articulos = []
    repuestos = []

    @classmethod
    def agregar_articulo(cls,articulo):
        cls.articulos.append(articulo)
    @classmethod
    def eliminar_articulo(cls, articulo):
        cls.articulos.remove(articulo)

    @classmethod
    def get_articulos(cls):
        return cls.articulos
    @classmethod
    def get_repuestos(cls):
        return cls.repuestos
    
    @classmethod
    def set_articulos(cls,Articulos):
        cls.articulos = Articulos

    @classmethod
    def set_repuestos(cls,repuest):
        cls.repuestos = repuest

    @classmethod
    def agregar_repuesto(cls,repuesto):
        cls.repuestos.append(repuesto)
    @classmethod
    def eliminar_repuesto(cls, repuesto):
        cls.repuestos.remove(repuesto)
        


    @staticmethod
    def articulos_dispo(mecanico):
        prods = []
        for articulo in Articulo.get_articulos():
            if mecanico.get_especialidad() == articulo.get_especialidad() and articulo.get_cantidad() >= 1:
                prods.append(articulo)
        return prods

    @staticmethod
    def articulo_dispo(mecanico):
        prods = []
        for articulo in Articulo.get_articulos():
            if (mecanico.get_especialidad().lower() == "modificacionpintura" and
                    articulo.get_especialidad().lower() == "pintura" and articulo.get_cantidad() >= 1):
                prods.append(articulo)
            elif (mecanico.get_especialidad().lower() == "modificacionllantas" and
                    articulo.get_especialidad().lower() == "llantas" and articulo.get_cantidad() >= 1):
                prods.append(articulo)
            elif (mecanico.get_especialidad().lower() == "modificacionsonido" and
                    articulo.get_especialidad().lower() == "sonido" and articulo.get_cantidad() >= 1):
                prods.append(articulo)
            elif (mecanico.get_especialidad().lower() == "modificacionfrenos" and
                    articulo.get_especialidad().lower() == "frenos" and articulo.get_cantidad() >= 1):
                prods.append(articulo)
            elif (mecanico.get_especialidad().lower() == "modificacionescape" and
                    articulo.get_especialidad().lower() == "escape" and articulo.get_cantidad() >= 1):
                prods.append(articulo)
            elif mecanico.get_especialidad() == articulo.get_especialidad() and articulo.get_cantidad() >= 1:
                prods.append(articulo)
        return prods
    def selector_especial(input):
        salir = None
        especialidad = None
        artic = []
        
        while salir is None:
            
            
            if input == 1:
                especialidad = "Motor"
                for articulo in Articulo.get_repuesto():
                    if especialidad == articulo.get_especialidad():
                        artic.append(articulo)
                salir = "si"
            elif input == 2:
                especialidad = "Escape"
                for articulo in Articulo.get_repuesto():
                    if especialidad == articulo.get_especialidad():
                        artic.append(articulo)
                salir = "si"
            elif input == 3:
                especialidad = "Sonido"
                for articulo in Articulo.get_repuesto():
                    if especialidad == articulo.get_especialidad():
                        artic.append(articulo)
                salir = "si"
            elif input == 4:
                especialidad = "Suspension"
                for articulo in Articulo.get_repuesto():
                    if especialidad == articulo.get_especialidad():
                        artic.append(articulo)
                salir = "si"
            else:
                print("\n¿Salir? (si/no)")
                salir = "si"
        
        return artic

    def selector_modificacion():
        salir = None
        especialidad = None
        artic = []
        
        while salir is None:
            input = int(input())
            
            if input == 1:
                especialidad = "Pintura"
                for articulo in Articulo.get_articulos():
                    if especialidad == articulo.get_especialidad():
                        artic.append(articulo)
                salir = "si"
            elif input == 2:
                especialidad = "Llantas"
                for articulo in Articulo.get_articulos():
                    if especialidad == articulo.get_especialidad():
                        artic.append(articulo)
                salir = "si"
            elif input == 3:
                especialidad = "Sonido"
                for articulo in Articulo.get_articulos():
                    if especialidad == articulo.get_especialidad():
                        artic.append(articulo)
                salir = "si"
            elif input == 4:
                especialidad = "Frenos"
                for articulo in Articulo.get_articulos():
                    if especialidad == articulo.get_especialidad():
                        artic.append(articulo)
                salir = "si"
            elif input == 5:
                especialidad = "Escape"
                for articulo in Articulo.get_articulos():
                    if especialidad == articulo.get_especialidad():
                        artic.append(articulo)
                salir = "si"
            else:
                print("\n¿Salir? (si/no)")
                salir = input()
        
        return artic
    def selector_calidad(artic,input):
        salir = None
        articul = []
        while salir is None:
            
            if input == 1:
                calidad = "premium"
                for ar in artic:
                    if calidad == ar.get_calidad():
                        articul.append(ar)
                salir = "si"
            elif input == 2:
                calidad = "Basico"
                for ar in artic:
                    if calidad == ar.get_calidad():
                        articul.append(ar)
                salir = "si"
            else:
                print("\n¿Salir? (si/no)")
                salir = "si"
        return articul

    def selector_marca(artic,input):
        salir = None
        articul = []
        while salir is None:
            
            if input == 1:
                marca = "Toyota"
                for ar in artic:
                    if marca == ar.get_marcaVehiculo() :
                        articul.append(ar)
                salir = "si"
            elif input == 2:
                marca = "Mazda"
                for ar in artic:
                    if marca == ar.get_marcaVehiculo() :
                        articul.append(ar)
                salir = "si"
            elif input == 3:
                marca = "Chevrolet"
                for ar in artic:
                    if marca == ar.get_marcaVehiculo():
                        articul.append(ar)
                salir = "si"
            else:
                print("\n¿Salir? (si/no)")
                salir = "si"
        return articul

    def selector_tipollantas(llantas):
        salir = None
        articul = []
        while salir is None:
            input = int(input())
            if input == 1:
                tipoLlanta = "Llanta todo terreno"
                for ar in llantas:
                    if tipoLlanta == ar.get_tipoArticulo():
                        articul.append(ar)
                salir = "si"
            elif input == 2:
                tipoLlanta = "Llanta terreno de barro"
                for ar in llantas:
                    if tipoLlanta == ar.get_tipoArticulo():
                        articul.append(ar)
                salir = "si"
            elif input == 3:
                tipoLlanta = "Llanta terreno de asfalto"
                for ar in llantas:
                    if tipoLlanta == ar.get_tipoArticulo():
                        articul.append(ar)
                salir = "si"
        return articul
