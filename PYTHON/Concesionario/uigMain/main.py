import sys
import os
import tkinter as tk
from PIL import ImageTk, Image

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

if __name__ == "__main__":
    Deserializador.deserializar_arrays()
    
    
    ####
    def procesoVenta():
        presupuestoInsuficiente = False
        while True:
            comprador = None
            vendedor = None
            auto = None
            
            while comprador is None:
                print("Escriba la cédula del comprador:  ")
                cedula = int(input())
                comprador = Cliente.get_clientePorCedula(cedula)
                if comprador is None:
                    print("La cédula ingresada no se encuentra registrada. Por favor, vuelva a ingresarla.")


            if comprador.get_presupuesto() < 35000000:
                presupuestoInsuficiente = True
                print("Usted no tiene el presupuesto mínimo para comprar algún carro del inventario.")
                break
            
            # Selección del carro
            opcion = 0
            print(comprador.info() + "Suu presupuesto es: " + str(comprador.get_presupuesto()) + "\n")
            print("Estos son los autos de la marca de interés para el cliente disponibles en este momento: ")
            
            # AUTOS POR MODELO
            autosMod = []
            result1 = "{:<20}{:<20}{:<10}\n".format("Modelo", "Precio", "Color")
            j = 0
            for auto1 in InventarioAuto.get_autos_disponibles():
                if comprador.get_modeloInteres() == auto1.get_marca():
                    j += 1
                    autosMod.append(auto1)
                    carInfo1 = "{:<20}{:<20}{:<10}\n".format(auto1.getModelo(), auto1.getPrecio(), auto1.getColor())
                    result1 += "{:<3d}{}".format(j, carInfo1)
            
            if len(autosMod) > 1:
                print("Los carros de la marca " + comprador.get_modeloInteres() + " disponibles son:\n")
                print(result1)
                print("Seleccione el numero del carro" + "[1-" + str(len(autosMod)) + "] ")
            elif len(autosMod) == 1:
                print("El unico carro de modelo " + comprador.get_modeloInteres() + " disponible es:\n")
                print(result1)
                print("Lo desea seleccionar? (y/n): ")
                resp = input()
                if resp == "y":
                    auto = autosMod[0]
                else:
                    auto = None
            elif len(autosMod) == 0:
                print("No hay carros disponibles del modelo seleccionado")
                auto = None

    volver_al_menu_principal = True
    opcion = None

    
    
    while volver_al_menu_principal:

        window = tk.Tk()
        window.geometry("600x300")
        window.title("Inicio")

        def opcion1():
            window.destroy()
            exit()

        def opcion2():
            info_curriculum.config(text="Dios bendiga mami este arrebato", justify="center", wraplength=280)

        def entrar():
            window.destroy()
            window2.mainloop()

        
        img_counter_p4 = 0
        def cambiar_imagen_p4(evento):
            global img_counter_p4
            global imagen_tk
            global label_imagen
            if img_counter_p4 == 4:
                img_counter_p4 = 0
            else:
                img_counter_p4 += 1
            imagen_tk = ImageTk.PhotoImage(imagenes_concesionario[img_counter_p4])
            label_imagen.config(image=imagen_tk)

        i=-1
        array_rutas = ["jonatan", "santiago", "felipe", "juanjose"]

        def Curriculums(evento):
            global i
            global contenedor_imagen1
            global contenedor_imagen2
            global contenedor_imagen3
            global contenedor_imagen4
            global array_rutas
            global ruta1
            global ruta2
            global ruta3
            global ruta4
            global image1
            global image2
            global image3
            global image4
            i += 1
            descripciones = [
                "Jonatan: Risas contagiosas y calcetines desparejados. Siempre listo para hacer locuras. ¡Cuidado con su teoría de unicornios fluorescentes!",
                "Santiago: Perdido en su propia casa, confunde frutas. Sentido del humor de un erizo resacoso. Siempre arranca sonrisas con chistes torcidos.",
                "Felipe: Rey de los tropiezos. En el suelo más que de pie. Su falta de coordinación es legendaria. Blanco perfecto de bromas.",
                "Juan José: Imán para el caos. Crea problemas de la nada. Historias absurdas, como intentar construir una máquina del tiempo con una tostadora y un cactus."
            ]

            if i==4:
                i=0

            info_curriculum.config(text=descripciones[i], justify="center", wraplength=280)

            ruta1 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[i],'1.jpg')))
            ruta2 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[i],'2.png')))
            ruta3 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[i],'3.jpg')))
            ruta4 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[i],'4.png')))


            # Obtener el tamaño de los contenedores
            ancho_contenedor = contenedor_imagen1.winfo_width()
            alto_contenedor = contenedor_imagen1.winfo_height()

            # Redimensionar las imágenes al tamaño de los contenedores
            image1_redimensionada = ruta1.resize((ancho_contenedor, alto_contenedor), Image.LANCZOS)
            image2_redimensionada = ruta2.resize((ancho_contenedor, alto_contenedor), Image.LANCZOS)
            image3_redimensionada = ruta3.resize((ancho_contenedor, alto_contenedor), Image.LANCZOS)
            image4_redimensionada = ruta4.resize((ancho_contenedor, alto_contenedor), Image.LANCZOS)

            # Convertir las imágenes a objetos ImageTk para su visualización en tkinter
            image_tk1 = ImageTk.PhotoImage(image1_redimensionada)
            image_tk2 = ImageTk.PhotoImage(image2_redimensionada)
            image_tk3 = ImageTk.PhotoImage(image3_redimensionada)
            image_tk4 = ImageTk.PhotoImage(image4_redimensionada)

            # Asignar las imágenes redimensionadas a los contenedores
            contenedor_imagen1.config(image=image_tk1)
            contenedor_imagen2.config(image=image_tk2)
            contenedor_imagen3.config(image=image_tk3)
            contenedor_imagen4.config(image=image_tk4)

            # Ajustar el tamaño de las imágenes al tamaño de los contenedores
            contenedor_imagen1.image = image_tk1  # Guardar referencia para evitar que la imagen sea eliminada
            contenedor_imagen2.image = image_tk2
            contenedor_imagen3.image = image_tk3
            contenedor_imagen4.image = image_tk4

            # Ubicar los contenedores en la interfaz
            contenedor_imagen1.place(x=0, y=0, width=ancho_contenedor, height=alto_contenedor)
            contenedor_imagen2.place(x=ancho_contenedor, y=0, width=ancho_contenedor, height=alto_contenedor)
            contenedor_imagen3.place(x=0, y=alto_contenedor, width=ancho_contenedor, height=alto_contenedor)
            contenedor_imagen4.place(x=ancho_contenedor, y=alto_contenedor, width=ancho_contenedor, height=alto_contenedor)

        imagen1 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes','1.jpg')))
        imagen2 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes','2.jpg')))
        imagen3 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes','3.png')))
        imagen4 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes','4.jpg')))
        imagen5 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes','5.jpg')))

        inicio = tk.Menu(window, fg="red")
        window.config(menu=inicio)
        inicio1 = tk.Menu(inicio)
        inicio.add_cascade(label="Inicio", menu=inicio1)
        inicio1.add_command(label="Salir", command=opcion1)
        inicio1.add_command(label="Descripcion", command=opcion2)

        p1 = tk.Frame(window, bg="#FFFFFF")
        p1.place(relx=0, rely=0, relwidth=0.5, relheight=1)

        p3 = tk.Frame(p1, bg="#454343")
        p3.place(relx=0.02, rely=0.02, relwidth=0.96, relheight=0.3)

        bienvenida = tk.Label(p3, text="Bienvenido cabron", bg="red", width="288")
        bienvenida.pack(expand=True)

        p4 = tk.Frame(p1, bg="#454343")
        p4.place(relx=0.02, rely=0.36, relwidth=0.96, relheight=0.6)

        label_imagen = tk.Label(p4)
        
        label_imagen.place(relx=0.5, rely=0.4, anchor=tk.CENTER, relwidth=0.9, relheight=0.7)
        label_imagen.bind("<Button-1>", lambda event: cambiar_imagen_p4(event))
        # Obtener el tamaño de los contenedores

        ancho_contenedor = label_imagen.winfo_width()
        alto_contenedor = label_imagen.winfo_height()

        # Redimensionar las imágenes al tamaño de los contenedores
        imagen1_redimensionada = imagen1.resize((ancho_contenedor, alto_contenedor), Image.LANCZOS)
        imagen2_redimensionada = imagen2.resize((ancho_contenedor, alto_contenedor), Image.LANCZOS)
        imagen3_redimensionada = imagen3.resize((ancho_contenedor, alto_contenedor), Image.LANCZOS)
        imagen4_redimensionada = imagen4.resize((ancho_contenedor, alto_contenedor), Image.LANCZOS)
        imagen5_redimensionada = imagen5.resize((ancho_contenedor, alto_contenedor), Image.LANCZOS)

        # Convertir las imágenes a objetos ImageTk para su visualización en tkinter
        imagen_tk1 = ImageTk.PhotoImage(imagen1_redimensionada)
        imagen_tk2 = ImageTk.PhotoImage(imagen2_redimensionada)
        imagen_tk3 = ImageTk.PhotoImage(imagen3_redimensionada)
        imagen_tk4 = ImageTk.PhotoImage(imagen4_redimensionada)
        imagen_tk5 = ImageTk.PhotoImage(imagen5_redimensionada)

        imagenes_concesionario = [imagen_tk1, imagen_tk2, imagen_tk3, imagen_tk4, imagen_tk5]
        if img_counter_p4 >= len(imagenes_concesionario):
            img_counter_p4 = 0

        imagen_tk = ImageTk.PhotoImage(imagenes_concesionario[img_counter_p4])
        label_imagen.config(image=imagen_tk)
        

        Entrar = tk.Button(p4, text="Entrar al sistema", command=entrar)
        Entrar.place(relx=0.5, rely=0.95, anchor=tk.S, relwidth=0.4, relheight=0.15)
        
        p2 = tk.Frame(window, bg="#FFFFFF")
        p2.place(relx=0.5, rely=0, relwidth=0.5, relheight=1)

        p5 = tk.Frame(p2, bg="#454343")
        p5.place(relx=0.02, rely=0.02, relwidth=0.96, relheight=0.3)
        
        info_curriculum = tk.Label(p5, text='curriculumss', bg='yellow')
        info_curriculum.place(relx=0.02, rely=0.02, relwidth=0.96, relheight=0.96)
        info_curriculum.bind("<Button-1>", lambda event: Curriculums(event))


        p6 = tk.Frame(p2, bg="#454343")
        p6.place(relx=0.02, rely=0.36, relwidth=0.96, relheight=0.6)

        contenedor_imagen1 = tk.Label(p6, text='1')
        contenedor_imagen2 = tk.Label(p6, text='2')
        contenedor_imagen3 = tk.Label(p6, text='3')
        contenedor_imagen4 = tk.Label(p6, text='4')

        contenedor_imagen1.grid(row=0, column=0, padx=2, pady=2, sticky="nsew")
        contenedor_imagen2.grid(row=0, column=1, padx=2, pady=2, sticky="nsew")
        contenedor_imagen3.grid(row=1, column=0, padx=2, pady=2, sticky="nsew")
        contenedor_imagen4.grid(row=1, column=1, padx=2, pady=2, sticky="nsew")

        p6.grid_rowconfigure(0, weight=1)
        p6.grid_rowconfigure(1, weight=1)
        p6.grid_columnconfigure(0, weight=1)
        p6.grid_columnconfigure(1, weight=1)


        window.mainloop()

        window2 = tk.Tk()
        window2.geometry("600x300")
        window2.title("Concesionario")

        print("\n\nMenú principal Concesionario")
        print("1. Venta de Autos")
        print("2. Venta de Repuestos")
        print("3. Taller")
        print("4. Consultar estadisticas / finanzas")
        print("5. Personalizar su auto")
        print("6. Crear nuevo usuario (Comprador)")
        print("7. Administración")
        print("8. Salir")
        
        opcion = int(input("Ingrese el número de la opción que va a utilizar: "))
        
        if opcion == 1:
            procesoVenta()
            respuesta = input("¿Desea volver al menú principal? (si/no): ")
            if respuesta == "no":
                Serializador.serializar_arrays()
                volver_al_menu_principal = False
        elif opcion == 2:
            ##ventaRepuestos()
            respuesta = input("¿Desea volver al menú principal? (si/no): ")
            if respuesta == "no":
                volver_al_menu_principal = False
        elif opcion==8:
            print("Chao pescao")
            Serializador.serializar_arrays()
            volver_al_menu_principal = False


