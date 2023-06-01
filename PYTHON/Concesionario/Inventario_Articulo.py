class InventarioArticulo:
    articulos = []
    repuestos = []

    @staticmethod
    def agregarArticulo(articulo):
        InventarioArticulo.articulos.append(articulo)

    def eliminarArticulo(self, articulo):
        InventarioArticulo.articulos.remove(articulo)

    @staticmethod
    def getArticulos():
        return InventarioArticulo.articulos

    @staticmethod
    def agregarRepuesto(repuesto):
        InventarioArticulo.repuestos.append(repuesto)

    def eliminarRepuesto(self, repuesto):
        InventarioArticulo.repuestos.remove(repuesto)

    @staticmethod
    def getRepuesto():
        return InventarioArticulo.repuestos

    @staticmethod
    def setArticulos(Articulos):
        InventarioArticulo.articulos = Articulos

    @staticmethod
    def articulosDispo(mecanico):
        prods = []
        for articulo in InventarioArticulo.getArticulos():
            if mecanico.getEspecialidad() == articulo.getEspecialidad() and articulo.getCantidad() >= 1:
                prods.append(articulo)
        return prods

    @staticmethod
    def articuloDispo(mecanico):
        prods = []
        for articulo in InventarioArticulo.getArticulos():
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
            for articulo in InventarioArticulo.getRepuesto():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 2:
            especialidad = "Escape"
            for articulo in InventarioArticulo.getRepuesto():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 3:
            especialidad = "Sonido"
            for articulo in InventarioArticulo.getRepuesto():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 4:
            especialidad = "Suspension"
            for articulo in InventarioArticulo.getRepuesto():
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
            for articulo in InventarioArticulo.getArticulos():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 2:
            especialidad = "Llantas"
            for articulo in InventarioArticulo.getArticulos():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 3:
            especialidad = "Sonido"
            for articulo in InventarioArticulo.getArticulos():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 4:
            especialidad = "Frenos"
            for articulo in InventarioArticulo.getArticulos():
                if especialidad == articulo.getEspecialidad():
                    artic.append(articulo)
            salir = "si"
        elif input == 5:
            especialidad = "Escape"
            for articulo in InventarioArticulo.getArticulos():
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
