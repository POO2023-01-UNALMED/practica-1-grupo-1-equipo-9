import sys
sys.path.append('C:\\Users\\felip\\OneDrive\\Documentos\\GitHub\\practica-1-grupo-1-equipo-9\\PYTHON\\Concesionario\\gestorAplicacion\\Personal')
sys.path.append('C:\\Users\\felip\\OneDrive\\Documentos\\GitHub\\practica-1-grupo-1-equipo-9\\PYTHON\\Concesionario\\gestorAplicacion\\Activos')
class Inventario_Articulo:
    articulos = []
    repuestos = []

    @staticmethod
    def agregarArticulo(articulo):
        Inventario_Articulo.articulos.append(articulo)

    def eliminarArticulo(self, articulo):
        Inventario_Articulo.articulos.remove(articulo)

    @staticmethod
    def getArticulos():
        return Inventario_Articulo.articulos

    @staticmethod
    def agregarRepuesto(repuesto):
        Inventario_Articulo.repuestos.append(repuesto)

    def eliminarRepuesto(self, repuesto):
        Inventario_Articulo.repuestos.remove(repuesto)

    @staticmethod
    def getRepuesto():
        return Inventario_Articulo.repuestos

    @staticmethod
    def setArticulos(Articulos):
        Inventario_Articulo.articulos = Articulos

    @staticmethod
    def articulosDispo(mecanico):
        prods = []
        for articulo in Inventario_Articulo.getArticulos():
            if mecanico.getEspecialidad() == articulo.getEspecialidad() and articulo.getCantidad() >= 1:
                prods.append(articulo)
        return prods

    @staticmethod
    def articuloDispo(mecanico):
        prods = []
        for articulo in Inventario_Articulo.getArticulos():
            if (mecanico.getEspecialidad().lower() == "modificacionpintura" and
                    articulo.getEspecialidad().lower() == "pintura" and articulo.getCantidad() >= 1):
                prods.append(articulo)
            elif (mecanico.getEspecialidad().lower() == "modificacionllantas" and
                    articulo.getEspecialidad().lower() == "llantas" and articulo.getCantidad() >= 1):
                prods.append(articulo)
            elif (mecanico.getEspecialidad().lower() == "modificacionsonido" and
                    articulo.getEspecialidad().lower() == "sonido" and articulo.getCantidad() >= 1):
                prods.append(articulo)
            elif (mecanico.getEspecialidad().lower() == "modificacionfrenos" and
                    articulo.getEspecialidad().lower() == "frenos" and articulo.getCantidad() >= 1):
                prods.append(articulo)
            elif (mecanico.getEspecialidad().lower() == "modificacionescape" and
                    articulo.getEspecialidad().lower() == "escape" and articulo.getCantidad() >= 1):
                prods.append(articulo)
            elif mecanico.getEspecialidad() == articulo.getEspecialidad() and articulo.getCantidad() >= 1:
                prods.append(articulo)
        return prods
def selectorEspecial():
    salir = None
    especialidad = None
    artic = []
    
    while salir is None:
        input = int(input())
        
        if input == 1:
            especialidad = "Motor"
            for articulo in Inventario_Articulo.getRepuesto():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 2:
            especialidad = "Escape"
            for articulo in Inventario_Articulo.getRepuesto():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 3:
            especialidad = "Sonido"
            for articulo in Inventario_Articulo.getRepuesto():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 4:
            especialidad = "Suspension"
            for articulo in Inventario_Articulo.getRepuesto():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        else:
            print("\n¿Salir? (si/no)")
            salir = input()
    
    return artic

def selectorModificacion():
    salir = None
    especialidad = None
    artic = []
    
    while salir is None:
        input = int(input())
        
        if input == 1:
            especialidad = "Pintura"
            for articulo in Inventario_Articulo.getArticulos():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 2:
            especialidad = "Llantas"
            for articulo in Inventario_Articulo.getArticulos():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 3:
            especialidad = "Sonido"
            for articulo in Inventario_Articulo.getArticulos():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 4:
            especialidad = "Frenos"
            for articulo in Inventario_Articulo.getArticulos():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 5:
            especialidad = "Escape"
            for articulo in Inventario_Articulo.getArticulos():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        else:
            print("\n¿Salir? (si/no)")
            salir = input()
    
    return artic
def selectorCalidad(artic):
    salir = None
    articul = []
    while salir is None:
        input = int(input())
        if input == 1:
            calidad = "premium"
            for ar in artic:
                if calidad == ar.getCalidad():
                    articul.append(ar)
            salir = "si"
        elif input == 2:
            calidad = "Basico"
            for ar in artic:
                if calidad == ar.getCalidad():
                    articul.append(ar)
            salir = "si"
        else:
            print("\n¿Salir? (si/no)")
            salir = input()
    return articul

def selectorMarca(artic):
    salir = None
    articul = []
    while salir is None:
        input = int(input())
        if input == 1:
            marca = "Toyota"
            for ar in artic:
                if marca == ar.getMarcaVehiculo():
                    articul.append(ar)
            salir = "si"
        elif input == 2:
            marca = "Mazda"
            for ar in artic:
                if marca == ar.getMarcaVehiculo():
                    articul.append(ar)
            salir = "si"
        elif input == 3:
            marca = "Chevrolet"
            for ar in artic:
                if marca == ar.getMarcaVehiculo():
                    articul.append(ar)
            salir = "si"
        else:
            print("\n¿Salir? (si/no)")
            salir = input()
    return articul

def selectorTipoLlantas(llantas):
    salir = None
    articul = []
    while salir is None:
        input = int(input())
        if input == 1:
            tipoLlanta = "Llanta todo terreno"
            for ar in llantas:
                if tipoLlanta == ar.getTipoArticulo():
                    articul.append(ar)
            salir = "si"
        elif input == 2:
            tipoLlanta = "Llanta terreno de barro"
            for ar in llantas:
                if tipoLlanta == ar.getTipoArticulo():
                    articul.append(ar)
            salir = "si"
        elif input == 3:
            tipoLlanta = "Llanta terreno de asfalto"
            for ar in llantas:
                if tipoLlanta == ar.getTipoArticulo():
                    articul.append(ar)
            salir = "si"
    return articul
