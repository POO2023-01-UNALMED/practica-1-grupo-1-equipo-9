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

class Serializador():
    
    def serializar_array(array, name):
        ruta = os.path.abspath(f"Concesionario/baseDatos/tmp/{name}.pkl")

        try:
            archivo= open(ruta, "wb")
            pickle.dump(array, archivo)
            archivo.close()
        except FileNotFoundError:
            print("FileNotFound")
        except IOError:
            print("IOError")
    @classmethod
    def serializar_arrays(cls):
        cls.serializar_array(InventarioAuto.get_autos(), "Autos")
        cls.serializar_array(Cliente.get_clientes(), "Clientes")
        cls.serializar_array(Mecanico.get_mecanicos(), "Mecanicos")
        cls.serializar_array(Vendedor.get_vendedores(), "Vendedores")
        cls.serializar_array(Inventario_Articulo.getArticulos(), "Articulos")
        cls.serializar_array(Inventario_Articulo.getRepuesto(), "Repuestos")
        cls.serializar_array(Transaccion.getTransacciones(), "Transacciones")
        cls.serializar_array(TransaccionVenta.get_transaccionesven, "TransaccionesVentas")
        cls.serializar_array(TransaccionVentaTaller.getTransaccionesvental, "TransaccionesVentaTaller")
        cls.serializar_array(TransaccionTaller.getTransaccionestal(), "TransaccionesTaller")
        cls.serializar_array(TransaccionModificacion.getTransaccionesmod(), "TransaccionesModificacion")
        cls.serializar_array(TransaccionVenta.get_autosV, "AutosV")
        cls.serializar_array(TransaccionVenta.get_marcas, "Marcas")
        cls.serializar_array(TransaccionVenta.get_vend, "Vend")