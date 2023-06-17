import sys
import os
import tkinter as tk
from PIL import ImageTk, Image
from tkinter import messagebox
from tkinter import ttk
import FieldFrame

ruta_FieldFrame = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'uigMain'))
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
ruta_Datos=os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'baseDatos'))
ruta_Imagenes=os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)
sys.path.append(ruta_Imagenes)
sys.path.append(ruta_FieldFrame)
from gestorAplicacion.Activos.InventarioAuto import InventarioAuto
from gestorAplicacion.Personal.cliente import Cliente
from baseDatos.serializador import Serializador
from baseDatos.deserializador import Deserializador
from FieldFrame import FieldFrame

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

        def comprobar_cliente(event):
            global valor_cedula
            global valores_iniciales
            global cliente

            valor_cedula = fp.getValue("Cedula")

            print(valor_cedula)

            cliente = Cliente.get_clientePorCedula(int(valor_cedula))
            print(cliente)
            if cliente!= None:
                nombre_cliente = cliente.get_nombre()
                telefono_cliente = cliente.get_telefono()
                correo_cliente = cliente.get_correo()
                valores_iniciales.insert(1, nombre_cliente)
                valores_iniciales.insert(2, telefono_cliente)
                valores_iniciales.insert(3, correo_cliente)
            elif cliente==None:
                raise Exception(messagebox.showinfo("Cliente no encontrado", "Esta cedula no está registrada en nuestro concesionario."))
        

        criterios = ["Cedula", "Nombre", "Teléfono", "Correo"]
        valores_iniciales = ["", "", "", ""]
        habilitados = [True, False, False, False]

        root = tk.Tk()
        fp = FieldFrame("Criterio", criterios, "Valor", valores_iniciales, habilitados)
        fp.pack(side="top")
        comprobar = tk.Button(root, text="Comprobar")
        comprobar.bind("<Button-1>", lambda event: comprobar_cliente(event))
        comprobar.pack(side="bottom", padx=5, pady=5)

    # Ejecución del bucle principal de la interfaz gráfica
        root.mainloop()

        window = tk.Tk()
        window.geometry("600x300")
        window.title("Inicio")

        def opcion1():
            window.destroy()
            exit()

        def opcion2():
            info_curriculum.config(text="Dios bendiga mami este arrebato", justify="center", wraplength=280)

        def entrar(event):
            window.destroy()
            app = Application(master=window2)
            window2.mainloop()

        
        img_counter_p4 = 0
        def cambiar_imagen_p4(evento):
            global img_counter_p4
            global imagen_tk
            global label_imagen
            global ancho_contenedor
            global alto_contenedor
            if img_counter_p4 == 4:
                img_counter_p4 = 0
            else:
                img_counter_p4 += 1
            
            ancho_contenedor = label_imagen.winfo_width()
            alto_contenedor = label_imagen.winfo_height()
            imagen_tk = imagenes_concesionario[img_counter_p4]
            label_imagen.config(image=imagen_tk)


        i=-1
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
            array_rutas = ["jonatan", "santiago", "felipe", "juanjose"]
            array_imgs=["1.jpg", "2.png", "3.jpg", "4.png"] 
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

            ruta1 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[0], array_imgs[i])))
            ruta2 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[1], array_imgs[i])))
            ruta3 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[2], array_imgs[i])))
            ruta4 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[3], array_imgs[i])))


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
            contenedor_imagen1.grid(row=0, column=0, padx=2, pady=2, sticky="nsew")
            contenedor_imagen2.grid(row=0, column=1, padx=2, pady=2, sticky="nsew")
            contenedor_imagen3.grid(row=1, column=0, padx=2, pady=2, sticky="nsew")
            contenedor_imagen4.grid(row=1, column=1, padx=2, pady=2, sticky="nsew")

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
        label_imagen.place(relx=0.5, rely=0.5, anchor=tk.CENTER, relwidth=1, relheight=1,)
        label_imagen.bind("<Enter>", lambda event: cambiar_imagen_p4(event))
        label_imagen.bind("<Button-1>", entrar)

        window.update()

        imagen1 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes','1.png')))
        imagen2 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes','2.png')))
        imagen3 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes','3.png')))
        imagen4 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes','4.png')))
        imagen5 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes','5.png')))

        # Obtener el tamaño de los contenedores

        ancho_label = label_imagen.winfo_width()
        alto_label = label_imagen.winfo_height()

        # Redimensionar las imágenes al tamaño de los contenedores
        imagenred_1 = imagen1.resize((ancho_label, alto_label), Image.LANCZOS)
        imagenred_2 = imagen2.resize((ancho_label, alto_label), Image.LANCZOS)
        imagenred_3 = imagen3.resize((ancho_label, alto_label), Image.LANCZOS)
        imagenred_4 = imagen4.resize((ancho_label, alto_label), Image.LANCZOS)
        imagenred_5 = imagen5.resize((ancho_label, alto_label), Image.LANCZOS)

        imagen_tk1 = ImageTk.PhotoImage(imagenred_1)
        imagen_tk2 = ImageTk.PhotoImage(imagenred_2)
        imagen_tk3 = ImageTk.PhotoImage(imagenred_3)
        imagen_tk4 = ImageTk.PhotoImage(imagenred_4)
        imagen_tk5 = ImageTk.PhotoImage(imagenred_5)

        imagenes_concesionario = [imagen_tk1, imagen_tk2, imagen_tk3, imagen_tk4, imagen_tk5]
        imagen_tk = imagenes_concesionario[0]
        label_imagen.config(image=imagen_tk)
        label_imagen.image = imagen_tk
        

        #Entrar = tk.Button(p4, text="Entrar al sistema", command=entrar)
        #Entrar.place(relx=0.5, rely=0.95, anchor=tk.S, relwidth=0.4, relheight=0.15)
        
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

        window.update()
        window.mainloop()

        def mostrar_proceso(nombre_proceso):
            etiqueta.config(text=nombre_proceso)

        def mostrar_informacion():
            messagebox.showinfo("Aplicación Consesionario", "Esta aplicación realiza diversas funcionalidades referentes a todos los procesos del consesionario.")

        def salir():
            window2.destroy()

        def mostrar_autores():
            messagebox.showinfo("Acerca de", "Autores: Santiago, Jonatan, Felipe, Juan Jose")



        # Crear ventana principal
        window2 = tk.Tk()
        window2.geometry("600x300")
        window2.title("Concesionario")

        menu_master = tk.Menu(window2)
        window2.config(menu=menu_master)

        # Menú Archivo
        sub_archivo = tk.Menu(menu_master)
        sub_archivo.add_command(label="Aplicación", command=mostrar_informacion)
        sub_archivo.add_command(label="Salir", command=salir)
        menu_master.add_cascade(label="Archivo", menu=sub_archivo)

        # Menú Procesos y Consultas
        sub_procesos = tk.Menu(menu_master)
        sub_procesos.add_command(label="Venta de Autos", command=lambda: mostrar_proceso("Venta de Autos"))
        sub_procesos.add_command(label="Venta de Repuestos", command=lambda: mostrar_proceso("Venta de Repuestos"))
        sub_procesos.add_command(label="Taller", command=lambda: mostrar_proceso("Taller"))
        sub_procesos.add_command(label="Consultar estadisticas / finanzas", command=lambda: mostrar_proceso("Consultar estadisticas / finanzas"))
        sub_procesos.add_command(label="Personalizar su auto", command=lambda: mostrar_proceso("Personalizar su auto"))
        sub_procesos.add_command(label="Crear nuevo usuario (Comprador)", command=lambda: mostrar_proceso("Crear nuevo usuario (Comprador)"))
        sub_procesos.add_command(label="Administración", command=lambda: mostrar_proceso("Administración"))
        menu_master.add_cascade(label="Procesos y consultas", menu=sub_procesos)

        # Menú Ayuda
        ayuda = tk.Menu(menu_master)
        ayuda.add_command(label="Acerca de:", command=mostrar_autores)
        menu_master.add_cascade(label="Ayuda", menu=ayuda)

        
        # Crear la zona de interacción para la muestra del nombre de procesos y consultas
        zona_interaccion = tk.LabelFrame(window2, relief="solid", highlightbackground="blue", bg="red")
        zona_interaccion.pack(side="top", pady=10)

        # Agregar contenido a la zona de interacción para la muestra del nombre de procesos y consultas
        etiqueta = tk.Label(zona_interaccion, text="Nombre del proceso o consulta")
        etiqueta.pack(side="top")

        # Crear la zona de interacción para deescripción del detalle de procesos o consultas
        zona_interaccion2 = tk.LabelFrame(window2, relief="solid", highlightbackground="blue")
        zona_interaccion2.pack(side="top")

        # Agregar contenido a la zona de interacción para descripción del detalle de procesos o consultas
        etiqueta2 = tk.Label(zona_interaccion2, text="Descripción del detalle de procesos o consultas")
        etiqueta2.pack(side="top", pady=7)

        
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


