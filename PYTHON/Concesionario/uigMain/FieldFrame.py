import tkinter as tk
from tkinter import messagebox

class FieldFrame(tk.Frame):
    def __init__(self, tituloCriterios, criterios, tituloValores, valores, habilitado):
        super().__init__()
        self.grid(sticky=tk.NSEW)
        self.criterios = criterios
        self.valores = valores
        self.habilitado = habilitado

        # Etiqueta para el título de los criterios
        tk.Label(self, text=tituloCriterios, font=("Arial", 10, "bold")).grid(row=0, column=0, sticky=tk.W)

        # Etiqueta para el título de los valores
        tk.Label(self, text=tituloValores, font=("Arial", 10, "bold")).grid(row=0, column=1, sticky=tk.W)

        # Campos de entrada de texto para los criterios y valores
        for i, criterio in enumerate(criterios):
            tk.Label(self, text=criterio).grid(row=i+1, column=0, sticky=tk.W)
            entry = tk.Entry(self, state='normal' if habilitado[i] else 'disabled')
            entry.grid(row=i+1, column=1, sticky=tk.W)
            if valores[i]:
                entry.insert(0, valores[i])

    def getValue(self, criterio):
        index = self.criterios.index(criterio)
        entry = self.grid_slaves(row=index+1, column=1)[0]
        return entry.get()

class Application(tk.Frame):
    def __init__(self, master=None):
        super().__init__(master)
        self.master = master
        self.grid(sticky=tk.NSEW)
        self.create_widgets()

    def create_widgets(self):
        

        # Zona de interacción usuario
        self.dialogo_texto = tk.Text(self, state='disabled')
        self.dialogo_texto.grid(row=1, column=0, columnspan=2, sticky=tk.NSEW)

        # Aplicar FieldFrame a window2
        field_frame = FieldFrame("Criterios", ["Criterio 1", "Criterio 2"], "Valores", ["Valor 1", "Valor 2"], [True, False])
        field_frame.grid(row=2, column=0, columnspan=2, sticky=tk.NSEW)


