import pickle
import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
from gestorAplicacion.Personal.cliente import Cliente
from gestorAplicacion.Personal.mecanico import Mecanico
from gestorAplicacion.Personal.vendedor import Vendedor
from gestorAplicacion.Activos.inventario_articulo import Inventario_Articulo
from gestorAplicacion.Activos.InventarioAuto import InventarioAuto
from gestorAplicacion.Activos.transaccion import Transaccion
from gestorAplicacion.Activos.transaccionventa import TransaccionVenta
from gestorAplicacion.Activos.transaccionVentaTaller import TransaccionVentaTaller
from gestorAplicacion.Activos.TransaccionTaller import TransaccionTaller
from gestorAplicacion.Activos.TransaccionModificacion import TransaccionModificacion
from gestorAplicacion.Activos.articulo import Articulo
from gestorAplicacion.Activos.auto import Auto

class Deserializador():
    def deserializar_array(name):
        lista = []
        ruta = os.path.abspath(f"Concesionario/baseDatos/tmp/{name}.pkl")
        try:
            picklefile = open(ruta, "rb")
        except:
            picklefile = open(ruta, "x")
            picklefile = open(ruta, "rb")
        if os.path.getsize(ruta) > 0:
            lista = pickle.load(picklefile)
        picklefile.close()
        return lista

    @classmethod
    def deserializar_arrays(cls):
        Auto.set_autos(cls.deserializar_array("Autos"))
        Cliente.set_clientes(cls.deserializar_array("Clientes"))
        Mecanico.set_mecanicos(cls.deserializar_array("Mecanicos"))
        Vendedor.set_vendedores(cls.deserializar_array("Vendedores"))
        Articulo.set_articulos(cls.deserializar_array("Articulos"))
        Articulo.set_repuestos(cls.deserializar_array("Repuestos"))
        Transaccion.set_transacciones(cls.deserializar_array("Transacciones"))
        TransaccionVenta.set_transaccionesven(cls.deserializar_array("TransaccionesVentas"))
        TransaccionVentaTaller.set_transaccionesvental(cls.deserializar_array("TransaccionesVentaTaller"))
        TransaccionTaller.set_transaccionestal(cls.deserializar_array("TransaccionesTaller"))
        TransaccionModificacion.set_transaccionesmod(cls.deserializar_array("TransaccionesModificacion"))
        TransaccionVenta.set_autosV(cls.deserializar_array("AutosV"))
        TransaccionVenta.set_marcas(cls.deserializar_array("Marcas"))
        TransaccionVenta.set_vend(cls.deserializar_array("Vend"))

