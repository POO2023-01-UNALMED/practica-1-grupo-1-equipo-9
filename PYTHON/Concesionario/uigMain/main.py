import sys
import os
import tkinter as tk
from PIL import ImageTk, Image
from tkinter import END, messagebox
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
from gestorAplicacion.Personal.mecanico import Mecanico
from gestorAplicacion.Activos.inventario_articulo import Inventario_Articulo
from gestorAplicacion.Activos.auto import Auto
from gestorAplicacion.Activos.articulo import Articulo
from gestorAplicacion.Activos.InventarioAuto import InventarioAuto
from gestorAplicacion.Personal.cliente import Cliente
from baseDatos.serializador import Serializador
from baseDatos.deserializador import Deserializador
from FieldFrame import FieldFrame
from gestorAplicacion.Personal.vendedor import Vendedor

if __name__ == "__main__":
    Deserializador.deserializar_arrays()
    llanta=  Articulo("Basico","taller","Llanta","Serie", "automovil y camioneta", "Serie", 0, 10000,3001)
    sonido= Articulo("Basico","taller","Sonido","Serie", "automovil y camioneta", "Serie", 0, 10000,3002)
    escape= Articulo("Basico","taller","Escape","Serie", "automovil y camioneta", "Serie", 0, 10000,3003)
    suspension=  Articulo("Basico","taller","Suspension","Serie", "automovil y camioneta", "Serie", 0, 10000,3004)

    a1= Auto("Hilux", "Toyota", 230000000, 2700, "verde fofo", True, True,llanta,suspension,sonido,escape);
    cc1 =  Cliente("Mikaela Yankee", 1029384756, 3209876543, "mikaelachupona@mail.com", "Toyota", 150000000);
    cc1.set_auto(a1)

    def limpiar(contenedor):
            for widget in contenedor.winfo_children():
                widget.destroy()
            
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

        '''def cancel(event):
            root.destroy()
            

        def confirmar_cliente(event, proceso):
            global cliente
            root.destroy()
            mostrar_proceso(proceso)'''


        '''def comprobar_cliente(event):
            global valor_cedula
            global valores_iniciales
            global cliente

            valor_cedula = fp.getValue("Cedula")


            if fp.entries[0].get()!="":

                cliente = Cliente.get_clientePorCedula(int(valor_cedula))

                if cliente != None:
                    nombre_cliente = cliente.get_nombre()
                    telefono_cliente = cliente.get_telefono()
                    correo_cliente = cliente.get_correo()
                    label_1 = fp.entries[1]  # Índice 0 para el primer campo de entrada
                    label_2 = fp.entries[2]  # Índice 1 para el segundo campo de entrada
                    label_3 = fp.entries[3]  # Índice 2 para el tercer campo de entrada

                    label_1.configure(state="normal")
                    label_2.configure(state="normal")
                    label_3.configure(state="normal")

                    label_1.delete(0, END)  # Borra el contenido actual del campo de entrada
                    label_2.delete(0, END)
                    label_3.delete(0, END)

                    label_1.insert(END, nombre_cliente)
                    label_2.insert(END, telefono_cliente)
                    label_3.insert(END, correo_cliente)
                    
                    label_1.configure(state="disabled")
                    label_2.configure(state="disabled")
                    label_3.configure(state="disabled")

                    comprobar.configure(text="¿Confirmar?")
                    comprobar.bind("<Button-1>", lambda event: confirmar_cliente(event))
                    cancelar = tk.Button(root, text="Cancelar")
                    cancelar.bind("<Button-1>", lambda event: cancel(event))
                    cancelar.pack(padx=5, pady=5)
                elif cliente==None:
                    raise Exception(messagebox.showinfo("Cliente no encontrado", "Esta cedula no está registrada en nuestro concesionario."))
            else:
                raise Exception(messagebox.showinfo("Entrada vacía", "Por favor, escriba una cédula en el campo de texto."))
        
        #Plantilla de ingresar cédula cliente
        criterios = ["Cedula", "Nombre", "Teléfono", "Correo"]
        valores_iniciales = ["", "", "", ""]
        habilitados = [True, False, False, False]

        root = tk.Tk()
        fp = FieldFrame("Criterio", criterios, "Valor", valores_iniciales, habilitados)
        fp.pack(side="top")
        comprobar = tk.Button(root, text="Comprobar")
        comprobar.bind("<Button-1>", lambda event: comprobar_cliente(event))
        comprobar.pack(padx=5, pady=5)
        #####

    # Ejecución del bucle principal de la interfaz gráfica
        root.mainloop()'''
    # WINDOW PRINCIPAL
        window = tk.Tk()
        window.geometry("600x300")
        window.title("Inicio")

        def opcion1():
            window.destroy()
            exit()

        def opcion2():
            info_curriculum.config(text="Dios bendiga mami este arrebato", justify="center", wraplength=280)

        def entrar(event):
            global window2
            global ventana_funcionalidad
            window.destroy()
            # Crear ventana principal
            window2 = tk.Tk()
            window2.geometry("600x300")
            window2.title("Concesionario")

            ventana_funcionalidad=tk.Frame(window2)
            ventana_funcionalidad.pack(expand=True)

            menu_master = tk.Menu(window2)
            window2.config(menu=menu_master)

            # Menú Archivo
            sub_archivo = tk.Menu(menu_master)
            sub_archivo.add_command(label="Aplicación", command=mostrar_informacion)
            sub_archivo.add_command(label="Salir", command=salir)
            menu_master.add_cascade(label="Archivo", menu=sub_archivo)

            # Menú Procesos y Consultas
            sub_procesos = tk.Menu(menu_master)
            sub_procesos.add_command(label="Venta de Autos", command=lambda: proceso_venta("Venta de Autos"))
            sub_procesos.add_command(label="Venta de Repuestos", command=lambda: mostrar_proceso("Venta de Repuestos"))
            sub_procesos.add_command(label="Taller", command=lambda: procesoTaller("Taller"))
            sub_procesos.add_command(label="Personalizar su auto", command=lambda: proceso_personalizar_auto("Personalizar su auto"))
            sub_procesos.add_command(label="Consultar estadisticas / finanzas", command=lambda: stats("Consultar estadisticas / finanzas"))
            sub_procesos.add_command(label="Crear nuevo usuario (Comprador)", command=lambda: mostrar_proceso("Crear nuevo usuario (Comprador)"))
            sub_procesos.add_command(label="Administración", command=lambda: mostrar_proceso("Administración"))
            menu_master.add_cascade(label="Procesos y consultas", menu=sub_procesos)

            # Menú Ayuda
            ayuda = tk.Menu(menu_master)
            ayuda.add_command(label="Acerca de:", command=mostrar_autores)
            menu_master.add_cascade(label="Ayuda", menu=ayuda)

            
            # Crear la zona de interacción para la muestra del nombre de procesos y consultas
            '''zona_interaccion = tk.LabelFrame(window2, relief="solid", highlightbackground="blue", bg="red")
            zona_interaccion.pack(side="top", pady=10)

            # Agregar contenido a la zona de interacción para la muestra del nombre de procesos y consultas
            etiqueta = tk.Label(zona_interaccion, text="Nombre del proceso o consulta")
            etiqueta.pack(side="top")'''

            '''# Crear la zona de interacción para deescripción del detalle de procesos o consultas
            zona_interaccion2 = tk.LabelFrame(window2, relief="solid", highlightbackground="blue")
            zona_interaccion2.pack(side="top")

            # Agregar contenido a la zona de interacción para descripción del detalle de procesos o consultas
            etiqueta2 = tk.Label(zona_interaccion2, text="Descripción del detalle de procesos o consultas")
            etiqueta2.pack(side="top", pady=7)'''
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
            array_imgs=["1.png", "2.png", "3.png", "4.png"] 
            i += 1
            descripciones = [
                "Jonatan: Risas contagiosas y calcetines desparejados. Siempre listo para hacer locuras. ¡Cuidado con su teoría de unicornios fluorescentes!",
                "Santiago: Perdido en su propia casa, confunde frutas. Sentido del humor de un erizo resacoso. Siempre arranca sonrisas con chistes torcidos.",
                "Felipe, Tecnico en Linea de Avion, 24 años, apasionado por la Tecnologia, El campo y la Aviacion, Estudiante de 4 semestre de Ingenieria de Sistemas en la Universidad Nacional",
                "Juan José: Imán para el caos. Crea problemas de la nada. Historias absurdas, como intentar construir una máquina del tiempo con una tostadora y un cactus."
            ]

            if i==4:
                i=0

            info_curriculum.config(text=descripciones[i], justify="center", wraplength=280)

            ruta1 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[i], array_imgs[0])))
            ruta2 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[i], array_imgs[1])))
            ruta3 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[i], array_imgs[2])))
            ruta4 = Image.open(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'imagenes', array_rutas[i], array_imgs[3])))


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

        def mostrar_proceso(nombre_proceso):
            global etiqueta
            etiqueta.config(text=nombre_proceso)

        def mostrar_informacion():
            messagebox.showinfo("Aplicación Consesionario", "Esta aplicación realiza diversas funcionalidades referentes a todos los procesos del consesionario.")

        def salir():
            global window2
            window2.destroy()

        def mostrar_autores():
            messagebox.showinfo("Acerca de", "Autores: Santiago, Jonatan, Felipe, Juan Jose")
        
        def proceso_venta(nombre_proceso):
            global etiqueta
            global window2
            global ventana_funcionalidad
            global carros_encontrados

            def confirmar_compra(event):
                global carro_confirmado
                global vendedores_encontrados
                global seleccionar_auto

                vendedor_elegido = int(seleccionar_auto.get())-1

                vendedor_confirmado = vendedores_encontrados[vendedor_elegido]

                info = f"El vendedor es: {vendedor_confirmado.info()} \n"



            def confirmar_carro(event):
                global carro_elegido
                global seleccionar_auto
                global campo_texto
                global boton_aceptar
                global carro_confirmado
                global vendedores_encontrados

                carro_elegido = int(seleccionar_auto.get())-1

                carro_confirmado = carros_encontrados[carro_elegido]

                info = f"El carro elegido es {carro_confirmado.info()} \n"
                info2 = f"Por favor, seleccione el vendedor que lo ha atendido \n"
                i = 1
                vendedores_encontrados = []
                texto1 = ""
                indices = []
                for c in Vendedor.selector_vend(carro_confirmado):
                    vendedores_encontrados.append(i)
                    linea = "{:<20} {:<20} {:<20}\n".format(i, c.get_nombre(), c.get_puesto())
                    i += 1
                    texto1 += linea
                for f in range(1, i):
                    indices.append(f)
                seleccionar_auto['values']=indices
                texto2 = "{:<20} {:<20} {:<20}\n".format("", "Nombre", "Tipo de venta")
                texto = info + info2 + texto2 + texto1
                campo_texto.config(text=texto)
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_compra(event))



            def opciones_busqueda_carro(event):
                pass

            limpiar(ventana_funcionalidad)
            descripcion="Esta funcionalidad permite a los clientes buscar y elegir un auto para su compra."
            zona_interaccion = tk.LabelFrame(ventana_funcionalidad, relief="solid", highlightbackground="blue", bg="red")
            zona_interaccion.pack(side="top", pady=10)
            
            # Agregar contenido a la zona de interacción para la muestra del nombre de procesos y consultas
            etiqueta = tk.Label(zona_interaccion, text="Nombre del proceso o consulta")
            etiqueta.pack(side="top")

            # Crear la zona de interacción para deescripción del detalle de procesos o consultas
            zona_interaccion2 = tk.LabelFrame(ventana_funcionalidad, relief="solid", highlightbackground="blue")
            zona_interaccion2.pack(side="top")

            # Agregar contenido a la zona de interacción para descripción del detalle de procesos o consultas
            etiqueta2 = tk.Label(zona_interaccion2, text="Descripción del detalle de procesos o consultas")
            etiqueta2.pack(side="top", pady=7)

            etiqueta2.config(text=descripcion, justify="center", wraplength=280)

            etiqueta.config(text=nombre_proceso, justify="center",wraplength=280)
            
            container= tk.Frame(ventana_funcionalidad)
            container.pack(side='bottom', anchor='s', padx=120, pady=0, expand=False)

            def confirmar_cliente(event):
                global cliente
                global seleccionar_auto
                global campo_texto
                global carros_encontrados
                global boton_aceptar
                
                fp.forget()
                comprobar.destroy()

                frame_carros_marca = tk.Frame(ventana_funcionalidad)
                frame_carros_marca.pack(side="top", anchor="center")

                texto_nombre_cliente = f"Nombre del cliente: {cliente.get_nombre()} \n"
                texto_presupuesto_cliente = f"Su presupuesto es: {cliente.get_presupuesto()} \n"
                texto_marca_cliente = f"Los carros de la marca {cliente.get_modeloInteres()} de interés del cliente son: \n"
                texto_titulo_marca_autos = "{:<20} {:<20} {:<20} {:<20}\n".format("", "Modelo", "Precio", "Color")
                contador = 1
                texto_lista = ""
                carros_encontrados = []
                for i in InventarioAuto.get_autosporModelo(cliente.get_modeloInteres()):
                    carros_encontrados.append(i)
                    linea = "{:<20} {:<20} {:<20} {:<20}\n".format(contador, i.get_modelo(), i.get_precio(), i.get_color())
                    contador += 1
                    texto_lista += linea
                texto = texto_nombre_cliente + texto_presupuesto_cliente + texto_marca_cliente + texto_titulo_marca_autos + texto_lista
                campo_texto = tk.Label(frame_carros_marca, text=texto)
                seleccionar_auto = ttk.Combobox(frame_carros_marca)
                valores = []
                for i in range(1, contador):
                    valores.append(i)
                seleccionar_auto['values']=valores
                seleccionar_auto.current(0)
                boton_aceptar = tk.Button(frame_carros_marca, text="Confirmar selección")
                boton_opciones = tk.Button(frame_carros_marca, text="Más opciones de busqueda")
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_carro(event))
                boton_opciones.bind("<Button-1>", lambda event: opciones_busqueda_carro(event))
                campo_texto.pack(pady=10)
                seleccionar_auto.pack()
                boton_aceptar.pack(pady=10)
                boton_opciones.pack(pady=10)
                



            def cancel(event):
                limpiar(ventana_funcionalidad)

            def comprobar_cliente(event):
                global valor_cedula
                global valores_iniciales
                global cliente

                valor_cedula = fp.getValue("Cedula")


                if fp.entries[0].get()!="":

                    cliente = Cliente.get_clientePorCedula(int(valor_cedula))

                    if cliente != None:
                        nombre_cliente = cliente.get_nombre()
                        presupuesto_cliente = cliente.get_presupuesto()
                        correo_cliente = cliente.get_correo()
                
                        
                        label_1 = fp.entries[1]  # Índice 0 para el primer campo de entrada
                        label_2 = fp.entries[2]  # Índice 1 para el segundo campo de entrada
                        label_3 = fp.entries[3]  # Índice 2 para el tercer campo de entrada

                        label_1.configure(state="normal")
                        label_2.configure(state="normal")
                        label_3.configure(state="normal")

                        label_1.delete(0, END)  # Borra el contenido actual del campo de entrada
                        label_2.delete(0, END)
                        label_3.delete(0, END)

                        label_1.insert(END, nombre_cliente)
                        label_2.insert(END, presupuesto_cliente)
                        label_3.insert(END, correo_cliente)
                        
                        label_1.configure(state="disabled")
                        label_2.configure(state="disabled")
                        label_3.configure(state="disabled")

                        comprobar.configure(text="¿Confirmar?")
                        comprobar.bind("<Button-1>", lambda event: confirmar_cliente(event))
                        cancelar = tk.Button(container, text="Salir")
                        cancelar.bind("<Button-1>", lambda event: cancel(event))
                        cancelar.pack(padx=5, pady=10)
                    elif cliente==None:
                        raise Exception(messagebox.showinfo("Cliente no encontrado", "Esta cedula no está registrada en nuestro concesionario."))
    
    
                else:
                    raise Exception(messagebox.showinfo("Entrada vacía", "Por favor, escriba una cédula en el campo de texto."))
                

            criterios = ["Cedula", "Nombre", "Presupuesto", "Correo"]
            valores_iniciales = ["", "", "", ""]
            habilitados = [True, False, False, False]


            fp = FieldFrame(ventana_funcionalidad,"Criterio", criterios, "Valor", valores_iniciales, habilitados)
            fp.pack(side="top")
            comprobar = tk.Button(container, text="Comprobar")
            comprobar.bind("<Button-1>", lambda event: comprobar_cliente(event))
            comprobar.pack(padx=5, pady=5)
        
        def procesoTaller(nombre_proceso):
            global etiqueta
            global window2
            global ventana_funcionalidad
            def confirmar_proceso(event):
                global proceso_elegido
                global seleccionar_proceso
                global campo_texto
                

                proceso_elegido = int(seleccionar_proceso.get())-1

                proceso_confirmado = procesos[proceso_elegido]

                info = f"El proceso elegido es {proceso_confirmado} \n"
                info2 = f"Por favor, seleccione el Mecanico que lo va a atender \n"
                j = 1
                mecanicos_encontrados = []
                texto1 = ""
                for c in Mecanico.mecanico_disponible(cliente.get_auto(),int(seleccionar_proceso.get())):
                    mecanicos_encontrados.append(j)
                    linea = "{:<20} {:<20} {:<20}\n".format(j, c.get_nombre(), c.get_especialidad())
                    j += 1
                    texto1 += linea

                texto2 = "{:<20} {:<20} {:<20}\n".format("", "Nombre", "Especialidad")
                texto = info + info2 + texto2 + texto1
                campo_texto.config(text=texto)
                seleccionar_proceso.destroy()


            def opciones_busqueda_carro(event):
                pass

            limpiar(ventana_funcionalidad)
            descripcion="Este proceso esta diseñado para atender vehiculos comprados en nuestro consecionario, aca podras reparar, hacer revisiones y separar citas para ser atendido por un mecanico"
            zona_interaccion = tk.LabelFrame(ventana_funcionalidad, relief="solid", highlightbackground="blue", bg="red")
            zona_interaccion.pack(side="top", pady=10)
            
            # Agregar contenido a la zona de interacción para la muestra del nombre de procesos y consultas
            etiqueta = tk.Label(zona_interaccion, text="Nombre del proceso o consulta")
            etiqueta.pack(side="top")

            # Crear la zona de interacción para deescripción del detalle de procesos o consultas
            zona_interaccion2 = tk.LabelFrame(ventana_funcionalidad, relief="solid", highlightbackground="blue")
            zona_interaccion2.pack(side="top")

            # Agregar contenido a la zona de interacción para descripción del detalle de procesos o consultas
            etiqueta2 = tk.Label(zona_interaccion2, text="Descripción del detalle de procesos o consultas")
            etiqueta2.pack(side="top", pady=7)

            etiqueta2.config(text=descripcion, justify="center", wraplength=280)

            etiqueta.config(text=nombre_proceso, justify="center",wraplength=280)
            
            container= tk.Frame(ventana_funcionalidad)
            container.pack(side='top', anchor='w', padx=120, pady=0, expand=False)

            def confirmar_cliente(event):
                global cliente
                global combobox_lista_marca
                global campo_texto
                global procesos
                global seleccionar_proceso
                global i
                
                fp.forget()
                comprobar.destroy()

                frame_procesos = tk.Frame(ventana_funcionalidad)
                frame_procesos.pack(side="top", anchor="center")

                procesos=["Latoneria y pintura","Servicio de llantas","Cambio de Aceite","Cambio de Frenos"]

                texto_nombre_cliente = f"Nombre del cliente: {cliente.get_nombre()} \n"
                texto_auto_cliente = f"Su Auto es: {cliente.get_auto().get_modelo()} \n"
                texto_proceso_cliente = f"Que proceso desea hacerle al vehiculo\n"
                texto_titulo_procesos = "\n{:<40} {:<40}  \n".format( "Seleccion", "Proceso")
                contador = 1
                texto_lista = ""
                for i in procesos:
                    linea = "{:<40} {:<40}  \n".format(contador, i)
                    contador += 1
                    texto_lista += linea
                texto = texto_nombre_cliente + texto_auto_cliente + texto_proceso_cliente + texto_titulo_procesos + texto_lista
                campo_texto = tk.Label(frame_procesos, text=texto)
                seleccionar_proceso = ttk.Combobox(frame_procesos)
                valores = []
                for i in range(1, contador):
                    valores.append(i)
                seleccionar_proceso['values']=valores
                seleccionar_proceso.current(0)
                boton_aceptar = tk.Button(frame_procesos, text="Confirmar selección")
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_proceso(event))
                campo_texto.pack(pady=10)
                seleccionar_proceso.pack()
                boton_aceptar.pack(pady=10)
                
                
            def cancel(event):
                ventana_funcionalidad.destroy()

            def comprobar_cliente(event):
                global valor_cedula
                global valores_iniciales
                global cliente

                valor_cedula = fp.getValue("Cedula")


                if fp.entries[0].get()!="":

                    cliente = Cliente.get_clientePorCedula(int(valor_cedula))

                    if cliente != None:
                        nombre_cliente = cliente.get_nombre()
                        telefono_cliente = cliente.get_telefono()
                        try:
                            auto_cliente = cliente.get_auto().get_marca()
                        except AttributeError:
                            (messagebox.showinfo("Cliente sin Vehiculo", "Este cliente no posee en vehiculo comprado"))
                            limpiar(ventana_funcionalidad)
                            return
                
                        
                        label_1 = fp.entries[1]  # Índice 0 para el primer campo de entrada
                        label_2 = fp.entries[2]  # Índice 1 para el segundo campo de entrada
                        label_3 = fp.entries[3]  # Índice 2 para el tercer campo de entrada

                        label_1.configure(state="normal")
                        label_2.configure(state="normal")
                        label_3.configure(state="normal")

                        label_1.delete(0, END)  # Borra el contenido actual del campo de entrada
                        label_2.delete(0, END)
                        label_3.delete(0, END)

                        label_1.insert(END, nombre_cliente)
                        label_2.insert(END, telefono_cliente)
                        label_3.insert(END, auto_cliente)
                        
                        label_1.configure(state="disabled")
                        label_2.configure(state="disabled")
                        label_3.configure(state="disabled")
                        
                        comprobar.configure(text="¿Confirmar?")
                        comprobar.bind("<Button-1>", lambda event: confirmar_cliente(event))
                        cancelar = tk.Button(container, text="Cancelar")
                        cancelar.bind("<Button-1>", lambda event: cancel(event))
                        cancelar.pack(padx=5, pady=5)
                    elif cliente==None:
                        raise Exception(messagebox.showinfo("Cliente no encontrado", "Esta cedula no está registrada en nuestro concesionario."))
    
    
                else:
                    raise Exception(messagebox.showinfo("Entrada vacía", "Por favor, escriba una cédula en el campo de texto."))
                

            criterios = ["Cedula", "Nombre", "Auto/Marca", "Correo"]
            valores_iniciales = ["", "", "", ""]
            habilitados = [True, False, False, False]


            fp = FieldFrame(ventana_funcionalidad,"Criterio", criterios, "Valor", valores_iniciales, habilitados)
            fp.pack(side="top")

            comprobar = tk.Button(container, text="Comprobar")
            comprobar.bind("<Button-1>", lambda event: comprobar_cliente(event))
            comprobar.pack(padx=5, pady=5)

        def proceso_personalizar_auto(nombre_proceso):
            global etiqueta
            global window2
            global ventana_funcionalidad

            limpiar(ventana_funcionalidad)
            descripcion = "Este proceso está diseñado para atender vehículos comprados en nuestro concesionario. Aquí podrás comprar artículos para personalizar tu automóvil y, si así lo deseas, podrás utilizar nuestro taller y separar citas para que un mecánico modifique tu auto."
            zona_interaccion = tk.LabelFrame(ventana_funcionalidad, relief="solid", highlightbackground="blue", bg="red")
            zona_interaccion.pack(side="top", pady=10)

            # Agregar contenido a la zona de interacción para la muestra del nombre de procesos y consultas
            etiqueta = tk.Label(zona_interaccion, text="Personalización automovilística")

            # Crear la zona de interacción para descripción del detalle de procesos o consultas
            zona_interaccion2 = tk.LabelFrame(ventana_funcionalidad, relief="solid", highlightbackground="blue")
            zona_interaccion2.pack(side="top")

            # Agregar contenido a la zona de interacción para descripción del detalle de procesos o consultas
            etiqueta2 = tk.Label(zona_interaccion2, text="Descripción del detalle de procesos o consultas")
            etiqueta2.pack(side="top", pady=7)

            etiqueta2.config(text=descripcion, justify="center", wraplength=280)

            etiqueta.config(text=nombre_proceso, justify="center", wraplength=280)

            container = tk.Frame(ventana_funcionalidad)
            container.pack(side='top', anchor='w', padx=120, pady=0, expand=False)

            def confirmar_cliente(event):
                global cliente
                print("PASO")
                fp.forget()
                comprobar.destroy()
                pregunta_taller.pack_forget()
                opcion_taller_mecanicos.pack_forget()
                opcion_asignar_vendedor.pack_forget()

            def cancel(event):
                ventana_funcionalidad.destroy()

            def comprobar_cliente(event):
                global valor_cedula
                global valores_iniciales
                global cliente

                valor_cedula = fp.getValue("Cedula")

                if fp.entries[0].get() != "":
                    cliente = Cliente.get_clientePorCedula(int(valor_cedula))

                    if cliente is not None:
                        nombre_cliente = cliente.get_nombre()
                        telefono_cliente = cliente.get_telefono()
                        try:
                            auto_cliente = cliente.get_auto().get_marca()
                        except AttributeError:
                            (messagebox.showinfo("Cliente sin Vehículo", "Este cliente no posee un vehículo comprado"))
                            limpiar(ventana_funcionalidad)
                            return

                        label_1 = fp.entries[1]  # Índice 0 para el primer campo de entrada
                        label_2 = fp.entries[2]  # Índice 1 para el segundo campo de entrada
                        label_3 = fp.entries[3]  # Índice 2 para el tercer campo de entrada

                        label_1.configure(state="normal")
                        label_2.configure(state="normal")
                        label_3.configure(state="normal")

                        label_1.delete(0, tk.END)  # Borra el contenido actual del campo de entrada
                        label_2.delete(0, tk.END)
                        label_3.delete(0, tk.END)

                        label_1.insert(tk.END, nombre_cliente)
                        label_2.insert(tk.END, telefono_cliente)
                        label_3.insert(tk.END, auto_cliente)

                        label_1.configure(state="disabled")
                        label_2.configure(state="disabled")
                        label_3.configure(state="disabled")

                        comprobar.configure(text="¿Confirmar?")
                        comprobar.bind("<Button-1>", lambda event: confirmar_cliente(event))
                        cancelar = tk.Button(container, text="Cancelar")
                        cancelar.bind("<Button-1>", lambda event: cancel(event))
                        cancelar.pack(padx=5, pady=5)

                        # Crear la pregunta y opciones
                        pregunta_taller = tk.Label(container, text="¿Desea utilizar el taller con mecánicos o solo desea asignar un vendedor?")
                        pregunta_taller.pack(padx=5, pady=5)

                        opcion_taller_mecanicos = tk.Button(container, text="Utilizar taller con mecánicos")
                        opcion_taller_mecanicos.bind("<Button-1>", lambda event: utilizar_taller_mecanicos(event))

                        opcion_asignar_vendedor = tk.Button(container, text="Asignar vendedor")
                        opcion_asignar_vendedor.bind("<Button-1>", lambda event: asignar_vendedor(event))

                        opcion_taller_mecanicos.pack(padx=5, pady=5)
                        opcion_asignar_vendedor.pack(padx=5, pady=5)
                    elif cliente is None:
                        messagebox.showinfo("Cliente no encontrado", "Esta cédula no está registrada en nuestro concesionario.")

                else:
                    messagebox.showinfo("Entrada vacía", "Por favor, escriba una cédula en el campo de texto.")

            def utilizar_taller_mecanicos(event):
                # Create the components for the interface
                servicio_label = tk.Label(window, text="Seleccione el servicio:")
                servicio_combobox = ttk.Combobox(window)
                servicio_combobox['values'] = ("Modificación de pintura", "Modificación de llantas", "Modificación del sonido",
                                            "Modificación de frenos", "Modificación del escape")

                mecanicos_label = tk.Label(window, text="Mecánicos disponibles:")
                mecanicos_listbox = tk.Listbox(window)

                productos_label = tk.Label(window, text="Productos disponibles:")
                productos_listbox = tk.Listbox(window)

                seleccionar_servicio_button = tk.Button(window, text="Seleccionar Servicio", command=seleccionar_servicio)
                seleccionar_mecanico_button = tk.Button(window, text="Seleccionar Mecánico", command=seleccionar_mecanico)
                seleccionar_producto_button = tk.Button(window, text="Seleccionar Producto", command=seleccionar_producto)

                # Position the components in the window
                servicio_label.pack()
                servicio_combobox.pack()
                seleccionar_servicio_button.pack()

                mecanicos_label.pack()
                mecanicos_listbox.pack()
                seleccionar_mecanico_button.pack()

                productos_label.pack()
                productos_listbox.pack()
                seleccionar_producto_button.pack()

                # Add your logic here for the functionality of selecting services, mechanics, and products


            def asignar_vendedor(event):
                # Lógica para asignar un vendedor
                print("Asignar vendedor")

            criterios = ["Cedula", "Nombre", "Auto/Marca", "Correo"]
            valores_iniciales = ["", "", "", ""]
            habilitados = [True, False, False, False]

            fp = FieldFrame(ventana_funcionalidad, "Criterio", criterios, "Valor", valores_iniciales, habilitados)
            fp.pack(side="top")

            comprobar = tk.Button(container, text="Comprobar")
            comprobar.bind("<Button-1>", lambda event: comprobar_cliente(event))
            comprobar.pack(padx=5, pady=5)


        def stats(nombre_proceso):
            global ventana_funcionalidad
            limpiar(ventana_funcionalidad)

            def botonadmin(cedula):

                if cedula!=3355479:
                    print("d")
                else:
                    # crear labels iniciales y posicionarlos
                    lbstats1 = tk.Label(window2, text="¿Qué estadísticas / información financiera quieres consultar?", justify="left")
                    lbstats2 = tk.Label(window2, text="1. Estado de Resultados", justify="left")
                    lbstats3 = tk.Label(window2, text="2. Estado de Resultados Detallado", justify="left")
                    lbstats4 = tk.Label(window2, text="3. Ventas - Vendedor", justify="left")
                    lbstats5 = tk.Label(window2, text="4. Ventas - Autos", justify="left")

                    lbstats1.pack(side='top', anchor='w', padx=100, pady=10, expand=False)
                    lbstats2.pack(side='top', anchor='w', padx=120, pady=0, expand=False)
                    lbstats3.pack(side='top', anchor='w', padx=120, pady=0, expand=False)
                    lbstats4.pack(side='top', anchor='w', padx=120, pady=0, expand=False)
                    lbstats5.pack(side='top', anchor='w', padx=120, pady=0, expand=False)

                    # crear el último label con el entry de 1-4
                    containerinicio = tk.Frame(window2)
                    containerinicio.pack(side='top', anchor='w', padx=120, pady=0, expand=False)
                    lbstats6 = tk.Label(containerinicio, text="Selecciona: [1-4]", justify="left")
                    entrytats1 = tk.Entry(containerinicio)
                    lbstats6.pack(side='left', padx=0, pady=0)
                    entrytats1.pack(side='left', padx=15, pady=0)

            
            ### se crea el espacio para las estadísticas
            descripcion="ESTADISTICAS"
            zona_interaccion = tk.LabelFrame(ventana_funcionalidad, relief="solid", highlightbackground="blue", bg="red")
            zona_interaccion.pack(side="top", pady=10)

            # Agregar contenido a la zona de interacción para la muestra del nombre de procesos y consultas
            etiquetatitulo = tk.Label(zona_interaccion, text="Bienvenido al portal de estadisticas de nuestro concesionario")
            etiquetatitulo.pack(side="top")

            # Crear la zona de interacción para deescripción del detalle de procesos o consultas
            zona_interaccion2 = tk.LabelFrame(ventana_funcionalidad, relief="solid", highlightbackground="blue")
            zona_interaccion2.pack(side="top")

            # Agregar contenido a la zona de interacción para descripción del detalle de procesos o consultas
            etiqueta2 = tk.Label(zona_interaccion2, text="ESTADISTICAS")
            etiqueta2.pack(side="top", pady=7)

            ##etiqueta2.config(text="ESTADISTICAS", justify="center", wraplength=280)
            ##etiqueta.config(text=nombre_proceso, justify="center",wraplength=280)

            container= tk.Frame(zona_interaccion2)
            container.pack(side='top', anchor='w', padx=120, pady=0, expand=False)

            # label bienvenida
            ##lbadmin1=tk.Label(ventana_funcionalidad, text="Bienvenido al portal de estadisticas de nuestro concesionario")
            ##lbadmin1.pack(side='top', anchor='w', padx=80, pady=10, expand=False)
            
            # label, entry y button de cedula admin
            lbadmin = tk.Label(container, text="Introduzca su cedula", justify="left")
            entryadmin = tk.Entry(container)
            botonadmin = tk.Button(container, text= "hola", command=botonadmin(entryadmin.get()))
            lbadmin.pack(side='left', padx=0, pady=0)
            entryadmin.pack(side='left', padx=15, pady=0)
            botonadmin.pack(side='left', padx=5, pady=0)


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





