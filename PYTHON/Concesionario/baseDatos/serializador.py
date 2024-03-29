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

class Serializador():
    
    def serializar_array(array, name):
        ruta = os.path.abspath(f"Concesionario/baseDatos/tmp/{name}.pkl")

        try:
            with open(ruta, "wb") as archivo:
                pickle.dump(array, archivo)
        except FileNotFoundError:
            print("FileNotFound")
        except IOError:
            print("IOError")

    def serializar_arrays():
        Serializador.serializar_array(Auto.get_autos(), "Autos")
        Serializador.serializar_array(Cliente.get_clientes(), "Clientes")
        Serializador.serializar_array(Mecanico.get_mecanicos(), "Mecanicos")
        Serializador.serializar_array(Vendedor.get_vendedores(), "Vendedores")
        Serializador.serializar_array(Articulo.get_articulos(), "Articulos")
        Serializador.serializar_array(Articulo.get_repuesto(), "Repuestos")
        Serializador.serializar_array(Transaccion.get_transacciones(), "Transacciones")
        Serializador.serializar_array(TransaccionVenta.get_transaccionesven(), "TransaccionesVentas")
        Serializador.serializar_array(TransaccionVentaTaller.get_transaccionesvental(), "TransaccionesVentaTaller")
        Serializador.serializar_array(TransaccionTaller.get_transaccionestal(), "TransaccionesTaller")
        Serializador.serializar_array(TransaccionModificacion.get_transaccionesmod(), "TransaccionesModificacion")
        Serializador.serializar_array(TransaccionVenta.get_autosV(), "AutosV")
        Serializador.serializar_array(TransaccionVenta.get_marcas(), "Marcas")
        Serializador.serializar_array(TransaccionVenta.get_vend(), "Vend")
