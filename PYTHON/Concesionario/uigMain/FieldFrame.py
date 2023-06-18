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
    def __init__(self,contenedor, tituloCriterios, criterios, tituloValores, valores=None, habilitado=None):
        super().__init__(contenedor)

        self.criterios = criterios
        self.valores = valores if valores else ["" for _ in criterios]
        self.habilitado = habilitado if habilitado else [True for _ in criterios]

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

    
    



