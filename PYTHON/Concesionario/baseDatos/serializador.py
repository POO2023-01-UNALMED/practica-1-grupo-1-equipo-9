import pickle
import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
import gestorAplicacion.Personal
import gestorAplicacion.Activos
class Serializador():
    
    def serializar_arrays(array, name):
        ruta = os.path.abspath(f".baseDatos/tmp/{name}.pickle")

        try:
            with open(ruta, "wb") as archivo:
                pickle.dump(array, archivo)
        except FileNotFoundError:
            print("FileNotFound")
        except IOError:
            print("IOError")

    def serializar_arrays():
        serializar_arrays(gestorAplicacion.Personal.InventarioAuto.getAutos(), "Autos")
        serializar_arrays(gestorAplicacion.Personal.Cliente.getClientes(), "Clientes")
        serializar_arrays(gestorAplicacion.Personal.Mecanico.getMecanicos(), "Mecanicos")
        serializar_arrays(gestorAplicacion.Personal.getVendedores(), "Vendedores")
        serializar_arrays(gestorAplicacion.Activos.InventarioArticulo.getArticulos(), "Articulos")
        serializar_arrays(gestorAplicacion.Activos.InventarioArticulo.getRepuesto(), "Repuestos")
        serializar_arrays(gestorAplicacion.Activos.Transaccion.getTransacciones(), "Transacciones")
        serializar_arrays(gestorAplicacion.Activos.TransaccionVenta.getTransaccionesven(), "TransaccionesVentas")
        serializar_arrays(gestorAplicacion.Activos.TransaccionVentaTaller.getTransaccionesven(), "TransaccionesVentaTaller")
        serializar_arrays(gestorAplicacion.Activos.TransaccionTaller.getTransaccionestal(), "TransaccionesTaller")
        serializar_arrays(gestorAplicacion.Activos.TransaccionModificacion.getTransaccionesmod(), "TransaccionesModificacion")
        serializar_arrays(gestorAplicacion.Activos.TransaccionVenta.getAutosV(), "AutosV")
        serializar_arrays(gestorAplicacion.Activos.TransaccionVenta.getMarcas(), "Marcas")
        serializar_arrays(gestorAplicacion.Activos.TransaccionVenta.getVend(), "Vend")