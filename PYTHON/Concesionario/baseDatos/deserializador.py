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

class Deserializador():
    def deserializar_array(array, name):
        ruta = os.path.abspath(f"Concesionario/baseDatos/tmp/{name}.pkl")

        try:
            archivo= open(ruta, "rb")
            array=pickle.load(archivo)

        except FileNotFoundError:
            print("FileNotFound")
        except IOError:
            print("IOError")

    def deserializar_arrays():
        Deserializador.deserializar_array(InventarioAuto.getAutos(), "Autos")
        Deserializador.deserializar_array(Cliente.getClientes(), "Clientes")
        Deserializador.deserializar_array(Mecanico.getMecanicos(), "Mecanicos")
        Deserializador.deserializar_array(Vendedor.getVendedores(), "Vendedores")
        Deserializador.deserializar_array(Inventario_Articulo.getArticulos(), "Articulos")
        Deserializador.deserializar_array(Inventario_Articulo.getRepuesto(), "Repuestos")
        Deserializador.deserializar_array(Transaccion.getTransacciones(), "Transacciones")
        Deserializador.deserializar_array(TransaccionVenta.get_transaccionesven, "TransaccionesVentas")
        Deserializador.deserializar_array(TransaccionVentaTaller.getTransaccionesven, "TransaccionesVentaTaller")
        Deserializador.deserializar_array(TransaccionTaller.getTransaccionestal(), "TransaccionesTaller")
        Deserializador.deserializar_array(TransaccionModificacion.getTransaccionesmod(), "TransaccionesModificacion")
        Deserializador.deserializar_array(TransaccionVenta.get_autosV, "AutosV")
        Deserializador.deserializar_array(TransaccionVenta.get_marcas, "Marcas")
        Deserializador.deserializar_array(TransaccionVenta.get_vend, "Vend")