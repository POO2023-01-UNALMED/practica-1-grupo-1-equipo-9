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
        # Menú superior
        menubar = tk.Menu(self.master)
        self.master.config(menu=menubar)

        archivo_menu = tk.Menu(menubar, tearoff=0)
        archivo_menu.add_command(label="Aplicación", command=self.mostrar_informacion)
        archivo_menu.add_command(label="Salir", command=self.master.quit)
        menubar.add_cascade(label="Archivo", menu=archivo_menu)

        procesos_menu = tk.Menu(menubar, tearoff=0)
        procesos_menu.add_command(label="Listar Procesos y Consultas", command=self.listar_procesos_consultas)
        menubar.add_cascade(label="Procesos y Consultas", menu=procesos_menu)

        ayuda_menu = tk.Menu(menubar, tearoff=0)
        ayuda_menu.add_command(label="Acerca de", command=self.mostrar_autores)
        menubar.add_cascade(label="Ayuda", menu=ayuda_menu)

        # Zona de interacción usuario
        self.dialogo_texto = tk.Text(self, state='disabled')
        self.dialogo_texto.grid(row=1, column=0, columnspan=2, sticky=tk.NSEW)

        # Aplicar FieldFrame a window2
        field_frame = FieldFrame("Criterios", ["Criterio 1", "Criterio 2"], "Valores", ["Valor 1", "Valor 2"], [True, False])
        field_frame.grid(row=2, column=0, columnspan=2, sticky=tk.NSEW)

    def mostrar_informacion(self):
        messagebox.showinfo("Información", "Esta es una aplicación para la gestion de un concesionario.")

    def listar_procesos_consultas(self):
        messagebox.showinfo("Procesos y Consultas", "Lista de procesos y consultas:\n1. Venta de Autos\n2. Venta de Repuestos")

    def mostrar_autores(self):
        messagebox.showinfo("Acerca de", "Autores: Santiago, Juan Jose, Felipe, Jonatan")

window2 = tk.Tk()
window2.geometry("600x300")
window2.title("Concesionario")

app = Application(master=window2)
window2.mainloop()

