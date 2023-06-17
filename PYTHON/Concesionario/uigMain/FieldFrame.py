from tkinter import *
import tkinter as tk
from tkinter import messagebox
import sys
import os
import tkinter as tk
from PIL import ImageTk, Image
from tkinter import messagebox
from tkinter import ttk

ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
ruta_Datos=os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'baseDatos'))
ruta_Imagenes=os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
sys.path.append(ruta_Imagenes)
from gestorAplicacion.Activos.InventarioAuto import InventarioAuto
from gestorAplicacion.Personal.cliente import Cliente
from baseDatos.serializador import Serializador
from baseDatos.deserializador import Deserializador


class FieldFrame(Frame):
    def __init__(self, tituloCriterios, criterios, tituloValores, valores=None, habilitado=None):
        super().__init__()

        self.criterios = criterios
        self.valores = valores if valores else ["" for _ in criterios]
        self.habilitado = habilitado if habilitado else [True for _ in criterios]

        # Configuración del marco de ventana
        self.master.title("FieldFrame")
        self.grid()

        # Creación de componentes
        titulo_criterios_label = Label(self, text=tituloCriterios)
        titulo_criterios_label.grid(row=0, column=0)

        titulo_valores_label = Label(self, text=tituloValores)
        titulo_valores_label.grid(row=0, column=1)

        self.entries = []
        for i, criterio in enumerate(self.criterios):
            criterio_label = Label(self, text=criterio)
            criterio_label.grid(row=i+1, column=0, padx=5, pady=5)

            valor_entry = Entry(self)
            valor_entry.insert(END, self.valores[i])
            valor_entry.configure(state='readonly' if not self.habilitado[i] else 'normal')
            valor_entry.grid(row=i+1, column=1, padx=5, pady=5)

            self.entries.append(valor_entry)

    def getValue(self, criterio):
        index = self.criterios.index(criterio)
        return self.entries[index].get()


def comprobar_cliente(event):
    global valor_cedula
    global valores_iniciales
    global cliente

    valor_cedula = fp.getValue("Cedula")

    print(valor_cedula)

    cliente = Cliente.get_clientePorCedula(valor_cedula)
    print(cliente)
    if cliente!=None:
        nombre_cliente = cliente.get_nombre()
        telefono_cliente = cliente.get_telefono()
        correo_cliente = cliente.get_cliente()
        valores_iniciales.insert(1, nombre_cliente)
        valores_iniciales.insert(2, telefono_cliente)
        valores_iniciales.insert(3, correo_cliente)
    elif cliente==None:
        raise Exception(messagebox.showinfo("Cliente no encontrado", "Esta cedula no está registrada en nuestro concesionario."))
    
    



