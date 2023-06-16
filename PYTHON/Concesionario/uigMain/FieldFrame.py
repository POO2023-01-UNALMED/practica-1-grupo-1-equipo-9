from tkinter import *

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
            criterio_label.grid(row=i+1, column=0)

            valor_entry = Entry(self)
            valor_entry.insert(END, self.valores[i])
            valor_entry.configure(state='readonly' if not self.habilitado[i] else 'normal')
            valor_entry.grid(row=i+1, column=1)

            self.entries.append(valor_entry)

    def getValue(self, criterio):
        index = self.criterios.index(criterio)
        return self.entries[index].get()

criterios = ["Cedula", "Nombre", "Descripción", "Ubicación"]
valores_iniciales = ["3455", "", "", ""]
habilitados = [True, False, False, False]

root = Tk()
fp = FieldFrame("Criterio", criterios, "Valor", valores_iniciales, habilitados)
fp.pack()

# Ejecución del bucle principal de la interfaz gráfica
root.mainloop()

# Obtener el valor de un campo específico utilizando el método getValue
valor_cedula = fp.getValue("Cedula")
print("Valor de Cedula:", valor_cedula)

