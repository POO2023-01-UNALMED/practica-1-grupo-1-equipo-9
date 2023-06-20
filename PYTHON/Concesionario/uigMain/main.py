import random
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
from gestorAplicacion.Activos.transaccionventa import TransaccionVenta
from gestorAplicacion.Activos.TransaccionTaller import TransaccionTaller
from gestorAplicacion.Personal.trabajador import Trabajador
from gestorAplicacion.Activos.transaccionVentaTaller import TransaccionVentaTaller
import datetime

if __name__ == "__main__":
    Deserializador.deserializar_arrays()
    
    
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
            window2.geometry("900x450")
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
            sub_procesos.add_command(label="Venta de Repuestos", command=lambda: venta_taller("Venta de Repuestos"))
            sub_procesos.add_command(label="Taller", command=lambda: procesoTaller("Taller"))
            sub_procesos.add_command(label="Personalizar su auto", command=lambda: proceso_personalizar_auto("Personalizar su auto"))
            sub_procesos.add_command(label="Consultar estadisticas / finanzas", command=lambda: stats("Consultar estadisticas / finanzas"))
            sub_procesos.add_command(label="Crear nuevo usuario (Comprador)", command=lambda: crear_nuevo_usuario("Crear nuevo usuario (Comprador)"))
            sub_procesos.add_command(label="Administración", command=lambda: administrador("Administración"))
            menu_master.add_cascade(label="Procesos y consultas", menu=sub_procesos)

            # Menú Ayuda
            ayuda = tk.Menu(menu_master)
            ayuda.add_command(label="Acerca de:", command=mostrar_autores)
            menu_master.add_cascade(label="Ayuda", menu=ayuda)

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
            Serializador.serializar_arrays()
            window2.destroy()

        def mostrar_autores():
            messagebox.showinfo("Acerca de", "Autores: Santiago, Jonatan, Felipe, Juan Jose")
        
        def proceso_venta(nombre_proceso):
            global etiqueta
            global window2
            global ventana_funcionalidad
            global carros_encontrados
            global cliente
            

            def confirmar_compra(event):
                global carro_confirmado
                global vendedores_encontrados
                global seleccionar_auto
                global cliente
                global campo_texto
                global boton_aceptar
                global vendedor_confirmado

                vendedor_elegido = int(seleccionar_auto.get())-1

                vendedor_confirmado = vendedores_encontrados[vendedor_elegido]

                carro_confirmado.set_dueno(cliente)
                carro_confirmado.set_disponible(False)
                cliente.set_auto(carro_confirmado)
                vendedor_confirmado.confirmar_venta()
                deducido = cliente.get_presupuesto()-carro_confirmado.get_precio()
                cliente.set_presupuesto(deducido)
                transfer = int(random.random() * 1000)

                info = f"El vendedor es: {vendedor_confirmado.info()} \n"
                info2 = TransaccionVenta("efectivo", carro_confirmado.get_precio(), cliente, carro_confirmado, vendedor_confirmado, transfer).info()
                texto = info + info2
                campo_texto.config(text=texto)
                boton_aceptar.destroy()
                seleccionar_auto.destroy()



            def confirmar_carro(event):
                global carro_elegido
                global seleccionar_auto
                global campo_texto
                global boton_aceptar
                global carro_confirmado
                global vendedores_encontrados
                global boton_opciones
                global cliente

                carro_elegido = int(seleccionar_auto.get())-1

                carro_confirmado = carros_encontrados[carro_elegido]

                info = f"El carro elegido es {carro_confirmado.info()} \n"
                info2 = f"Por favor, seleccione el vendedor que lo ha atendido \n"
                i = 1
                vendedores_encontrados = Vendedor.selector_vend(carro_confirmado)
                texto1 = ""
                indices = []
                for c in vendedores_encontrados:
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
                boton_opciones.destroy()

            def mostrar_marca(event, marca):
                global frame_carros_marca
                global seleccionar_auto
                global campo_texto
                global boton_aceptar
                global vendedores_encontrados
                global boton_opciones
                global cliente
                global carro_confirmado
                global carro_elegido
                global carros_encontrados
                limpiar(frame_carros_marca)
                info1 = f"Estos son los carros de la marca {marca}\n"
                carros_encontrados = []
                info2 = ""
                cont = 1
                indices = []
                for i in InventarioAuto.get_autosporModelo(marca):
                    indices.append(cont)
                    carros_encontrados.append(i)
                    linea = str(cont)+ ".   " + i.info()+"\n"
                    info2 += linea
                    cont += 1
                texto = info1 + info2
                campo_texto = tk.Label(frame_carros_marca, text=texto)
                campo_texto.pack()
                seleccionar_auto = ttk.Combobox(frame_carros_marca)
                seleccionar_auto['values']=indices
                seleccionar_auto.current(0)
                boton_aceptar = tk.Button(frame_carros_marca, text="Confirmar selección")
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_carro(event))
                seleccionar_auto.pack()
                boton_aceptar.pack(pady=10)
                

            def mostrar_marcas(event):
                global boton1
                global boton2
                global boton3
                boton1.config(text="Mazda")
                boton1.bind("<Button-1>", lambda event: mostrar_marca(event, "Mazda"))
                boton2.config(text="Toyota")
                boton2.bind("<Button-1>", lambda event: mostrar_marca(event, "Toyota"))
                boton3.config(text="Chevrolet")
                boton3.bind("<Button-1>", lambda event: mostrar_marca(event, "Chevrolet"))

            def mostrar_por_precios(event):
                global frame_carros_marca
                global seleccionar_auto
                global campo_texto
                global boton_aceptar
                global vendedores_encontrados
                global boton_opciones
                global cliente
                global carro_confirmado
                global carro_elegido
                global carros_encontrados
                limpiar(frame_carros_marca)
                info1 = f"Estos son los carros ordenados según su presupuesto\n"
                carros_encontrados = []
                info2 = ""
                cont = 1
                indices = []
                for i in InventarioAuto.get_autosporPrecio(cliente):
                    indices.append(cont)
                    carros_encontrados.append(i)
                    linea = str(cont)+ ".   " + i.info()+"\n"
                    info2 += linea
                    cont += 1
                texto = info1 + info2
                campo_texto = tk.Label(frame_carros_marca, text=texto)
                campo_texto.pack()
                seleccionar_auto = ttk.Combobox(frame_carros_marca)
                seleccionar_auto['values']=indices
                seleccionar_auto.current(0)
                boton_aceptar = tk.Button(frame_carros_marca, text="Confirmar selección")
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_carro(event))
                seleccionar_auto.pack()
                boton_aceptar.pack(pady=10)

            def mostrar_todos(event):
                global frame_carros_marca
                global seleccionar_auto
                global campo_texto
                global boton_aceptar
                global vendedores_encontrados
                global boton_opciones
                global cliente
                global carro_confirmado
                global carro_elegido
                global carros_encontrados
                limpiar(frame_carros_marca)
                info1 = f"Estos son todos los carros disponibles\n"
                carros_encontrados = []
                info2 = ""
                cont = 1
                indices = []
                for i in InventarioAuto.get_autos_disponibles():
                    indices.append(cont)
                    carros_encontrados.append(i)
                    linea = str(cont)+ ".   " + i.info()+"\n"
                    info2 += linea
                    cont += 1
                texto = info1 + info2
                campo_texto = tk.Label(frame_carros_marca, text=texto)
                campo_texto.pack()
                seleccionar_auto = ttk.Combobox(frame_carros_marca)
                seleccionar_auto['values']=indices
                seleccionar_auto.current(0)
                boton_aceptar = tk.Button(frame_carros_marca, text="Confirmar selección")
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_carro(event))
                seleccionar_auto.pack()
                boton_aceptar.pack(pady=10)

            def opciones_busqueda_carro(event):
                global frame_carros_marca
                global boton1
                global boton2
                global boton3
                limpiar(frame_carros_marca)
                boton1 = tk.Button(frame_carros_marca, text="Mostrar carros por marca")
                boton1.bind("<Button-1>", lambda event: mostrar_marcas(event))
                boton2 = tk.Button(frame_carros_marca, text="Mostrar carros por precio")
                boton2.bind("<Button-1>", lambda event: mostrar_por_precios(event))
                boton3 = tk.Button(frame_carros_marca, text="Todos los carros")
                boton3.bind("<Button-1>", lambda event: mostrar_todos(event))
                boton1.pack(pady=5)
                boton2.pack(pady=5)
                boton3.pack(pady=5)

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
                global boton_opciones
                global frame_carros_marca
                
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

        def venta_taller(nombre_proceso):
            global etiqueta
            global window2
            global ventana_funcionalidad
            def confirmar_proces(event):
                global proceso_elegido
                global seleccionar_proceso
                global campo_texto
                global boton_aceptar
                global vehiculos
                global proceso_confirmado
                global repuesto
                global procesos
                

                proceso_elegido = int(seleccionar_proceso.get())-1

                proceso_confirmado = procesos[proceso_elegido]

                repuesto=Inventario_Articulo.selector_especial(proceso_elegido+1)

                info = f"El proceso elegido es {proceso_confirmado} \n"
                info2 = f"Por favor, seleccione la marca del Vehiculo del repuesto \n"
                j = 1
                vehiculos = ["Toyota","Mazda","Chevrolet"]
                texto2 = ("Seleccione La marca del Vehiculo")
                texto1 = ""
                texto = info + info2 + texto2 + texto1
                indices = []
                for c in vehiculos:
                    linea = "{:<20} {:<20} \n".format(j, c)
                    j += 1
                    texto1 += linea
                for f in range(1, j):
                    indices.append(f)
                seleccionar_proceso['values']=indices
                texto2 = "{:<20} {:<20} \n".format("", "Marca")
                texto = info + info2 + texto2 + texto1
                campo_texto.config(text=texto)
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_marca(event))
                
            def confirmar_marca(event):
                global proceso_confirmado
                global mecanicos_encontrados
                global campo_texto
                global seleccionar_proceso
                global articulos_encontrados
                global mecanico_confirmado
                global repuesto
                global marca_confirmado
                global calidad_encontrados
                global marca

                marca_elegido = int(seleccionar_proceso.get())-1

                marca_confirmado = vehiculos[marca_elegido]
                

                marca=Inventario_Articulo.selector_marca(repuesto,marca_elegido+1)
                


                info = ("El Mecanico es: " +marca_confirmado+ "\n")
                texto=info
                campo_texto.config(text=texto)
                info2 = f"Por favor, seleccione la calidad del Articulo a instalar\n"
                j = 1
                calidad_encontrados = ["Basico","premium"]
                texto1 = ""
                indices = []
                for c in calidad_encontrados:
                    linea = "{:<15} {:<40} \n".format(j, c)
                    j += 1
                    texto1 += linea
                for f in range(1, j):
                    indices.append(f)
                seleccionar_proceso['values']=indices
                texto2 = "{:<15} {:<40} \n".format("", "Calidad")
                texto = info + info2 + texto2 + texto1
                campo_texto.config(text=texto)
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_articulo(event))
            
            def confirmar_articulo(event):
                global proceso_confirmado
                global articulos_encontrados
                global campo_texto
                global seleccionar_proceso
                global mecanico_confirmado
                global articulo_confirmado
                global marca_confirmado
                global calidad_encontrados
                global calidad_confirmado
                global marca
                global articulos

                calidad_elegido = int(seleccionar_proceso.get())-1

                calidad_confirmado = calidad_encontrados[calidad_elegido]
                print(calidad_confirmado)
                print(marca_confirmado)
                print(proceso_confirmado)
                

                articulos=Inventario_Articulo.selector_calidad(marca,calidad_elegido)

                info = ("El Articulo es calidad : " +calidad_confirmado+" para su vehiculo que es un (a):  "+ marca_confirmado + "\n")
                texto=info
                j = 1
                campo_texto.config(text=texto)
                info2 = f"Por favor, seleccione El Articulo: \n"
                
                texto1 = ""
                indices = []
                for c in articulos:
                    linea = "{:<15} {:<40} {:<40}{:<50}{:<20}\n".format(j, c.get_referencia(), c.get_tipo(),c.get_marca(),c.get_precio())
                    j += 1
                    texto1 += linea
                for f in range(1, j):
                    indices.append(f)
                seleccionar_proceso['values']=indices
                texto2 = "{:<15} {:<40} {:<40}{:<50}{:<20}\n".format("", "Referencia", "Tipo","Marca","Precio")
                texto = info + info2 + texto2 + texto1
                campo_texto.config(text=texto)
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_vendedor(event))
                

            def confirmar_vendedor(event):
                global proceso_confirmado
                global articulos_encontrados
                global campo_texto
                global seleccionar_proceso
                global mecanico_confirmado
                global articulo_confirmado
                global marca_confirmado
                global calidad_encontrados
                global calidad_confirmado
                global marca
                global articulo_elegido
                global articulos
                global vendedores_encontrados

                articulo_elegido = int(seleccionar_proceso.get())-1

                articulo_confirmado = articulos[articulo_elegido]

                info = f"El Articulo elegido es {articulo_confirmado.info()} \n"
                info2 = f"Por favor, seleccione el vendedor que lo ha atendido \n"
                i = 1
                vendedores_encontrados = Vendedor.selector_vend(articulo_confirmado)
                texto1 = ""
                indices = []
                for c in vendedores_encontrados:
                    linea = "{:<20} {:<20} {:<20}\n".format(i, c.get_nombre(), c.get_puesto())
                    i += 1
                    texto1 += linea
                for f in range(1, i):
                    indices.append(f)
                seleccionar_proceso['values']=indices
                texto2 = "{:<20} {:<20} {:<20}\n".format("", "Nombre", "Tipo de venta")
                texto = info + info2 + texto2 + texto1
                campo_texto.config(text=texto)
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_todo(event))
                


            def confirmar_todo(event):
                global proceso_elegido
                global seleccionar_proceso
                global campo_texto
                global boton_aceptar
                global mecanicos_encontrados
                global proceso_confirmado
                global articulos_encontrados
                global articulo_confirmado
                global mecanico_confirmado
                global proceso_confirmado
                global precio
                global frame_procesos
                global boton_confirmar
                global vendedortal_confirmado
                global vendedores_encontrados


                vendedortal_elegido = int(seleccionar_proceso.get())-1

                vendedortal_confirmado = vendedores_encontrados[vendedortal_elegido]
                
                vendedortal_confirmado.confirmar_venta()
                
                precio=int(articulo_confirmado.get_precio())
                info = ("Venta Realizada por: "+vendedortal_confirmado.get_nombre() +"de: "+articulo_confirmado.get_tipoArticulo() +"por un precio de: "+str(precio)+  "\n")
                texto = info 
                campo_texto.config(text=texto)
                seleccionar_proceso.destroy()
                boton_aceptar.bind("<Button-1>", lambda event: trans(event))
                

            def trans(event):
                global proceso_elegido
                global seleccionar_proceso
                global campo_texto
                global boton_aceptar
                global mecanicos_encontrados
                global proceso_confirmado
                global articulos_encontrados
                global articulo_confirmado
                global mecanico_confirmado
                global proceso_confirmado
                global precio
                global frame_procesos
                global boton_confirmar
                global vendedortal_confirmado

                transfer = int(random.random() * 1000)

                info = ("TRANSACCION REALIZADA CON EXITO"  "\n")
                info2=TransaccionVentaTaller("Venta",precio,cliente,articulo_confirmado,vendedortal_confirmado,transfer).info()
                texto = info + info2
                Trabajador.pago_vendedor_articulo(vendedortal_confirmado,articulo_confirmado)
                articulo_confirmado.cantidad=-1
                
                campo_texto.config(text=texto)
                boton_aceptar.bind("<Button-1>", lambda event: limpiar(ventana_funcionalidad))

            limpiar(ventana_funcionalidad)
            descripcion="En este proceso podras comprar repuestos para tu vehiculo sea Mazda/Chevrolet/Toyota"
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
                global boton_aceptar
                global frame_procesos
                
                fp.forget()
                comprobar.destroy()

                frame_procesos = tk.Frame(ventana_funcionalidad)
                frame_procesos.pack(side="top", anchor="center")

                procesos=["Repuestos Motor","Escapes","Sonido","Suspension"]

                texto_nombre_cliente = f"Nombre del cliente: {cliente.get_nombre()} \n"
            
                texto_proceso_cliente = f"Que proceso desea hacerle al vehiculo\n"
                texto_titulo_procesos = "\n{:<40} {:<40}  \n".format( "Seleccion", "Proceso")
                contador = 1
                texto_lista = ""
                for i in procesos:
                    linea = "{:<40} {:<40}  \n".format(contador, i)
                    contador += 1
                    texto_lista += linea
                texto = texto_nombre_cliente + texto_proceso_cliente + texto_titulo_procesos + texto_lista
                campo_texto = tk.Label(frame_procesos, text=texto)
                seleccionar_proceso = ttk.Combobox(frame_procesos)
                valores = []
                for i in range(1, contador):
                    valores.append(i)
                seleccionar_proceso['values']=valores
                seleccionar_proceso.current(0)
                boton_aceptar = tk.Button(frame_procesos, text="Confirmar selección")
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_proces(event))
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
                        correo_cliente = cliente.get_correo()
                        telefono_cliente=cliente.get_telefono()
                
                        
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
                        label_2.insert(END, correo_cliente)
                        label_3.insert(END,telefono_cliente)
                        
                        label_1.configure(state="disabled")
                        label_2.configure(state="disabled")
                        label_3.configure(state="disabled")
                        
                        comprobar.configure(text="¿Confirmar?")
                        comprobar.bind("<Button-1>", lambda event: confirmar_cliente(event))
                        cancelar = tk.Button(container, text="Cancelar")
                        cancelar.bind("<Button-1>", lambda event: cancel(event))
                        cancelar.pack(padx=5, pady=5,side="bottom")
                    elif cliente==None:
                        raise Exception(messagebox.showinfo("Cliente no encontrado", "Esta cedula no está registrada en nuestro concesionario."))
    
    
                else:
                    raise Exception(messagebox.showinfo("Entrada vacía", "Por favor, escriba una cédula en el campo de texto."))
                

            criterios = ["Cedula", "Nombre", "Correo", "Telefono"]
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
                global boton_aceptar
                global mecanicos_encontrados
                global proceso_confirmado
                

                proceso_elegido = int(seleccionar_proceso.get())-1

                proceso_confirmado = procesos[proceso_elegido]

                info = f"El proceso elegido es {proceso_confirmado} \n"
                info2 = f"Por favor, seleccione el Mecanico que lo va a atender \n"
                j = 1
                mecanicos_encontrados = Mecanico.mecanico_disponible(cliente.get_auto(),int(seleccionar_proceso.get()))
                texto1 = ""
                indices = []
                for c in mecanicos_encontrados:
                    linea = "{:<20} {:<20} {:<40}{:<20}\n".format(j, c.get_nombre(), c.get_especialidad(),c.get_autos())
                    j += 1
                    texto1 += linea
                for f in range(1, j):
                    indices.append(f)
                seleccionar_proceso['values']=indices
                texto2 = "{:<20} {:<20} {:<40}{:<20}\n".format("", "Nombre", "Especialidad","Auto que Atiende")
                texto = info + info2 + texto2 + texto1
                campo_texto.config(text=texto)
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_mecanico(event))
                
            def confirmar_mecanico(event):
                global proceso_confirmado
                global mecanicos_encontrados
                global campo_texto
                global seleccionar_proceso
                global articulos_encontrados
                global mecanico_confirmado

                mecanico_elegido = int(seleccionar_proceso.get())-1

                mecanico_confirmado = mecanicos_encontrados[mecanico_elegido]
                info = ("El Mecanico es: " +mecanico_confirmado.get_nombre()+" para su vehiculo que es un (a):  "+ fp.getValue("Auto/Marca") + "\n")
                texto=info
                campo_texto.config(text=texto)
                info2 = f"Por favor, seleccione el Articulo A Instalar en su Vehiculo \n"
                j = 1
                articulos_encontrados = Inventario_Articulo.articulo_dispo(mecanico_confirmado)
                texto1 = ""
                indices = []
                for c in articulos_encontrados:
                    linea = "{:<15} {:<40} {:<40}{:<50}{:<20}\n".format(j, c.get_referencia(), c.get_tipo(),c.get_marca(),c.get_precio())
                    j += 1
                    texto1 += linea
                for f in range(1, j):
                    indices.append(f)
                seleccionar_proceso['values']=indices
                texto2 = "{:<15} {:<40} {:<40}{:<50}{:<20}\n".format("", "Referencia", "Tipo","Marca","Precio")
                texto = info + info2 + texto2 + texto1
                campo_texto.config(text=texto)
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_articulo(event))
            
            def confirmar_articulo(event):
                global proceso_confirmado
                global articulos_encontrados
                global campo_texto
                global seleccionar_proceso
                global mecanico_confirmado
                global articulo_confirmado

                articulo_elegido = int(seleccionar_proceso.get())-1

                articulo_confirmado = articulos_encontrados[articulo_elegido]
                info = ("El Articulo es: " +articulo_confirmado.get_marca()+" para su vehiculo que es un (a):  "+ fp.getValue("Auto/Marca") + "\n")
                texto=info
                j = 1
                campo_texto.config(text=texto)
                info2 = f"Por favor, seleccione el Horario para realizar su servicio \n"
                horarios_encontrados = mecanico_confirmado.get_horario()
                texto1 = ""
                indices = []
                for c in horarios_encontrados:
                    linea = "{:<15} {:<40} \n".format(j, c)
                    j += 1
                    texto1 += linea
                for f in range(1, j):
                    indices.append(f)
                seleccionar_proceso['values']=indices
                texto2 = "{:<15} {:<40}\n".format("", "HORARIO")
                texto = info + info2 + texto2 + texto1
                
                campo_texto.config(text=texto)
                boton_aceptar.bind("<Button-1>", lambda event: confirmar_todo(event))
                


            def confirmar_todo(event):
                global proceso_elegido
                global seleccionar_proceso
                global campo_texto
                global boton_aceptar
                global mecanicos_encontrados
                global proceso_confirmado
                global articulos_encontrados
                global articulo_confirmado
                global mecanico_confirmado
                global proceso_confirmado
                global precio
                global frame_procesos
                global boton_confirmar

                mecanico_confirmado.horario.pop(int(seleccionar_proceso.get())-1)
                
                precio=int(mecanico_confirmado.get_manoObra()+articulo_confirmado.get_precio())
                info = ("El Proceso a realizar es: " +" "+proceso_confirmado+" para su vehiculo que es un (a):  "+ fp.getValue("Auto/Marca")+ "\n"+ "Con el Mecanico "+ mecanico_confirmado.get_nombre() + " por un precio de: "+str(precio)+  "\n")
                texto = info 
                campo_texto.config(text=texto)
                seleccionar_proceso.destroy()
                boton_aceptar.bind("<Button-1>", lambda event: trans(event))
                

            def trans(event):
                global proceso_elegido
                global seleccionar_proceso
                global campo_texto
                global mecanicos_encontrados
                global proceso_confirmado
                global articulos_encontrados
                global articulo_confirmado
                global mecanico_confirmado
                global proceso_confirmado
                global precio
                global cliente
                global boton_confirmar

                transfer = int(random.random() * 1000)

                info = ("TRANSACCION REALIZADA CON EXITO"  "\n")
                info2=TransaccionTaller("Taller",precio,cliente,cliente.get_auto(),articulo_confirmado,mecanico_confirmado,transfer).info()
                texto = info + info2
                Trabajador.pago(mecanico_confirmado)
                articulo_confirmado.cantidad=-1
                
                campo_texto.config(text=texto)
                boton_aceptar.bind("<Button-1>", lambda event: limpiar(ventana_funcionalidad))
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
                global boton_aceptar
                global frame_procesos
                
                fp.forget()
                comprobar.destroy()

                frame_procesos = tk.Frame(ventana_funcionalidad)
                frame_procesos.pack(side="top", anchor="center")

                procesos=["Latoneria y pintura","Servicio de llantas","Cambio de Aceite","Cambio de Frenos"]

                texto_nombre_cliente = f"Nombre del cliente: {cliente.get_nombre()} \n"
                texto_auto_cliente = f"Su Auto es: {cliente.get_auto().get_marca()}  {cliente.get_auto().get_modelo()} \n"
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
                        correo_cliente = cliente.get_correo()
                        try:
                            auto_cliente = cliente.get_auto().get_marca()+" " +cliente.get_auto().get_modelo()
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
                        label_2.insert(END, auto_cliente)
                        label_3.insert(END, correo_cliente)
                        
                        label_1.configure(state="disabled")
                        label_2.configure(state="disabled")
                        label_3.configure(state="disabled")
                        
                        comprobar.configure(text="¿Confirmar?")
                        comprobar.bind("<Button-1>", lambda event: confirmar_cliente(event))
                        cancelar = tk.Button(container, text="Cancelar")
                        cancelar.bind("<Button-1>", lambda event: cancel(event))
                        cancelar.pack(padx=5, pady=5,side="bottom")
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
            
            
            container = tk.Frame(ventana_funcionalidad)
            container.pack(side='top', anchor='w', padx=120, pady=0, expand=False)

            def utilizar_taller_mecanicos(event):

                global etiqueta
                global window2
                global ventana_funcionalidad
                def confirmar_proceso(event):
                    global proceso_elegido
                    global seleccionar_proceso
                    global campo_texto
                    global boton_aceptar
                    global mecanicos_encontrados
                    

                    proceso_elegido = int(seleccionar_proceso.get())-1

                    proceso_confirmado = procesos[proceso_elegido]

                    info = f"El proceso elegido es {proceso_confirmado} \n"
                    info2 = f"Por favor, seleccione el Mecanico que lo va a atender \n"
                    j = 1
                    mecanicos_encontrados = Mecanico.mecanico_disponible(cliente.get_auto(),int(seleccionar_proceso.get()))
                    texto1 = ""
                    indices = []
                    for c in mecanicos_encontrados:
                        linea = "{:<20} {:<20} {:<40}{:<20}\n".format(j, c.get_nombre(), c.get_especialidad(),c.get_autos())
                        j += 1
                        texto1 += linea
                    for f in range(1, j):
                        indices.append(f)
                    seleccionar_proceso['values']=indices
                    texto2 = "{:<20} {:<20} {:<40}{:<20}\n".format("", "Nombre", "Especialidad","Auto que Atiende")
                    texto = info + info2 + texto2 + texto1
                    campo_texto.config(text=texto)
                    boton_aceptar.bind("<Button-1>", lambda event: confirmar_mecanico(event))
                    
                def confirmar_mecanico(event):
                    global proceso_confirmado
                    global mecanicos_encontrados
                    global campo_texto
                    global seleccionar_proceso
                    global articulos_encontrados

                    mecanico_elegido = int(seleccionar_proceso.get())-1

                    mecanico_confirmado = mecanicos_encontrados[mecanico_elegido]
                    info = ("El Mecanico es: " +mecanico_confirmado.get_nombre()+" para su vehiculo que es un (a):  "+ fp.getValue("Auto/Marca") + "\n")
                    texto=info
                    campo_texto.config(text=texto)
                    info2 = f"Por favor, seleccione el Articulo A Instalar en su Vehiculo \n"
                    j = 1
                    articulos_encontrados = Inventario_Articulo.articulo_dispo(mecanico_confirmado)
                    texto1 = ""
                    indices = []
                    for c in articulos_encontrados:
                        linea = "{:<15} {:<40} {:<40}{:<50}{:<20}\n".format(j, c.get_referencia(), c.get_tipo(),c.get_marca(),c.get_precio())
                        j += 1
                        texto1 += linea
                    for f in range(1, j):
                        indices.append(f)
                    seleccionar_proceso['values']=indices
                    texto2 = "{:<15} {:<40} {:<40}{:<50}{:<20}\n".format("", "Referencia", "Tipo","Marca","Precio")
                    texto = info + info2 + texto2 + texto1
                    campo_texto.config(text=texto)
                    boton_aceptar.bind("<Button-1>", lambda event: confirmar_articulo(event))
                
                def confirmar_articulo(event):
                    global proceso_confirmado
                    global articulos_encontrados
                    global campo_texto
                    global seleccionar_proceso

                    articulo_elegido = int(seleccionar_proceso.get())-1

                    articulo_confirmado = articulos_encontrados[articulo_elegido]
                    info = ("El Articulo es: " +articulo_confirmado.get_tipo()+" para su vehiculo que es un (a):  "+ fp.getValue("Auto/Marca") + "\n")
                    texto=info
                    campo_texto.config(text=texto)


                def opciones_busqueda_carro(event):
                    pass
            
                def confirmar_cliente(event):
                    global cliente
                    global combobox_lista_marca
                    global campo_texto
                    global procesos
                    global seleccionar_proceso
                    global boton_aceptar
                    
                        
                    fp.forget()
                    comprobar.destroy()

                    frame_procesos = tk.Frame(ventana_funcionalidad)
                    frame_procesos.pack(side="top", anchor="center")

                    
                    procesos=["Modificacion de pintura","Modificacion de Llantas","Modificacion del sonido","Modificacion de frenos", "Modificacion del escape"]

                    texto_nombre_cliente = f"Nombre del cliente: {cliente.get_nombre()} \n"
                    texto_auto_cliente = f"Su Auto es: {cliente.get_auto().get_marca()}  {cliente.get_auto().get_modelo()} \n"
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
                            correo_cliente = cliente.get_correo()
                            try:
                                auto_cliente = cliente.get_auto().get_marca()+" " +cliente.get_auto().get_modelo()
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
                            label_2.insert(END, auto_cliente)
                            label_3.insert(END, correo_cliente)
                            
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

            def asignar_vendedor(event):
                # Lógica para asignar un vendedor
                print("Asignar vendedor")
            
            def seleccionar_funcion(event):
                boton_elegir.destroy()
                opcion_elegida = seleccionar_opcion.get()

                if opcion_elegida == "Utilizar taller mecánicos":
                    utilizar_taller_mecanicos(event)
                elif opcion_elegida == "Asignar vendedor":
                    asignar_vendedor(event)

            # Crear la opción para que el usuario elija entre utilizar el taller de mecánicos o asignar un vendedor
            seleccionar_opcion = ttk.Combobox(container)
            seleccionar_opcion['values'] = ["Utilizar taller mecánicos", "Asignar vendedor"]
            seleccionar_opcion.current(0)
            seleccionar_opcion.pack(pady=10)

            # Agregar un botón para confirmar la selección de opción
            boton_elegir = tk.Button(container, text="Elegir", command=lambda: seleccionar_funcion(None))
            boton_elegir.pack(pady=10)



        def stats(nombre_proceso):
            global container
            global ventana_funcionalidad
            global entrystats1
            limpiar(ventana_funcionalidad)


            def botonadmin1():
                global containerOpciones
                global entrystats1
                
                cedula = entryadmin.get()
                if cedula!="1":#"3355479":
                    container.destroy()
                    lbno = tk.Label(zona_interaccion2, text="No es la cédula del admin", justify="left")
                    lbno.pack(side='top', anchor='w', padx=100, pady=10, expand=False)
                else:
                    etiquetatitulo.config(text="Por medio de las diferentes opciones de interacción que ofrece este formulario, podrás revisar la información estadística y financiera más relevante del concesionario",
                                          pady=2, wraplength=300)
                    container.destroy()
                    # crear labels iniciales y posicionarlos
                    containerOpciones=tk.Frame(zona_interaccion2)
                    containerOpciones.pack(side='top', anchor='w', padx=10, pady=10, expand=False)

                    lbstats1 = tk.Label(containerOpciones, text="¿Qué estadísticas / información financiera quieres consultar?", justify="left")
                    lbstats2 = tk.Label(containerOpciones, text="1. Estado de Resultados", justify="left")
                    #lbstats3 = tk.Label(containerOpciones, text="2. Estado de Resultados Detallado", justify="left")
                    lbstats4 = tk.Label(containerOpciones, text="2. Ventas - Vendedor", justify="left")
                    lbstats5 = tk.Label(containerOpciones, text="3. Ventas - Autos", justify="left")

                    lbstats1.pack(side='top', anchor='w', padx=100, pady=10, expand=False)
                    lbstats2.pack(side='top', anchor='w', padx=120, pady=0, expand=False)
                    #lbstats3.pack(side='top', anchor='w', padx=120, pady=0, expand=False)
                    lbstats4.pack(side='top', anchor='w', padx=120, pady=0, expand=False)
                    lbstats5.pack(side='top', anchor='w', padx=120, pady=0, expand=False)

                    # crear el último label con el entry de 1-4
                    containerinicio = tk.Frame(containerOpciones)
                    containerinicio.pack(side='top', anchor='w', padx=120, pady=0, expand=False)

                    # meter label, entry y boton en el container
                    lbstats6 = tk.Label(containerinicio, text="Selecciona: [1-3]", justify="left")
                    entrystats1 = tk.Entry(containerinicio)
                    boton1_4 = tk.Button(containerinicio, text="enviar", command=opciones) #, command=botonadmin1)
                    lbstats6.pack(side='left', padx=0, pady=0)
                    entrystats1.pack(side='left', padx=15, pady=0)
                    boton1_4.pack(side='left', padx=5, pady=0)

            def opciones():
                opcion = entrystats1.get()
                containerOpciones.destroy()
                #opcion = entrystats1.get()

                if opcion == "1":
                    etiqueta2.config(text="ESTADO DE RESULTADOS DEL CONCESIONARIO")

                    datos=Vendedor.estResults([0,0,0,0])
                    container_resultados = tk.Frame(zona_interaccion2)
                    container_resultados.pack(side='top', anchor='w', padx=10, pady=10)

                    # Ventas Totales
                    lb_ventas_totales = tk.Label(container_resultados, 
                    text="Ventas Totales: " + str(datos[0]))
                    lb_ventas_totales.pack(side='top', anchor='w')

                    # Costo de Ventas
                    lb_costo_ventas = tk.Label(container_resultados, 
                    text="Costo de Ventas: " + str(datos[1]))
                    lb_costo_ventas.pack(side='top', anchor='w')

                    # Utilidad Operativa
                    lb_utilidad_operativa = tk.Label(container_resultados, 
                    text="UTILIDAD OPERATIVA: " + str(datos[0]-datos[1]))
                    lb_utilidad_operativa.pack(side='top', anchor='w')

                    # Gastos Operacionales y de Ventas
                    lb_gastos_operacionales = tk.Label(container_resultados, 
                    text="Gastos Operacionales y de Ventas: " + str(datos[2]))
                    lb_gastos_operacionales.pack(side='top', anchor='w')

                    # Utilidad antes de Impuestos
                    lb_utilidad_impuestos = tk.Label(container_resultados, 
                    text="UTILIDAD ANTES DE IMPUESTOS: " + str(datos[0]-datos[1]-datos[2]))
                    lb_utilidad_impuestos.pack(side='top', anchor='w')

                    # Impuesto de Renta
                    lb_impuesto_renta = tk.Label(container_resultados, 
                    text="Impuesto de Renta: " + str(datos[3]))
                    lb_impuesto_renta.pack(side='top', anchor='w')

                    # Utilidad Neta
                    lb_utilidad_neta = tk.Label(container_resultados, 
                    text="UTILIDAD NETA: " + str(datos[0]-datos[1]-datos[2]-datos[3]))
                    lb_utilidad_neta.pack(side='top', anchor='w')


                if opcion == "2":
                    
                    # Obtener la fecha y hora actual
                    fecha_actual = datetime.datetime.now()

                    # Obtener el mes de la fecha actual
                    mes_actual = fecha_actual.month
                    dia_actual = fecha_actual.day

                    nombre_mes = fecha_actual.strftime("%B")

                    def traducir_mes(mes_en_ingles):
                        meses = {
                            'January': 'enero', 'February': 'febrero', 'March': 'marzo', 'April': 'abril',
                            'May': 'mayo', 'June': 'junio', 'July': 'julio', 'August': 'agosto',
                            'September': 'septiembre', 'October': 'octubre', 'November': 'noviembre', 'December': 'diciembre'
                        }
                        return meses[mes_en_ingles]

                    etiqueta2.config(text="ESTADISTICAS DE VENTAS POR VENDEDOR")
                    ## plantilla base (3):
                    container_3=tk.Frame(zona_interaccion2)
                    container_3.pack(side='top', anchor='w', padx=10, pady=10) #, expand=False)

                    # creando los labels donde irá la info
                    info1_3=tk.Label(container_3, 
                                   text="Los " + str(len(Vendedor.get_vendedores())) + " vendedores, han logrado " 
                                   + str(len(TransaccionVenta.get_transaccionesven())) + 
                                   " ventas en el mes, promediando "
                                   + str((len(TransaccionVenta.get_transaccionesven()))/(len(Vendedor.get_vendedores())))
                                   + " ventas por vendedor",
                                   justify="left")
                    infovendedores=tk.Label(container_3, text="info de cada vendedor", justify="left")
                    info2_3=tk.Label(container_3,
                                   text="Suma de ingresos por concepto de venta de autos, y promedio de ingresos en lo corrido del mes de junio:",
                                   justify="left")
                    infoingresos=tk.Label(container_3,
                                          text="Suma de ingresos: #, promedio de ingresos diarios en lo corrido del mes de (mes): #.",
                                          justify="left")
                    
                    # metiendo los labels en el container_3
                    info1_3.pack(side='top', anchor='w', padx=10, pady=10, expand=False)
                    infovendedores.pack(side='top', anchor='w', padx=10, pady=10, expand=False)
                    info2_3.pack(side='top', anchor='w', padx=10, pady=10, expand=False)
                    infoingresos.pack(side='top', anchor='w', padx=10, pady=10, expand=False)
                    ## fin plantilla base (3):

                    # metiendo la info a la plantilla 3
                    # infovendedores
                    ventass=""
                    ingresosautos=0

                    # para saber ingresos por venta de autos
                    for venta in TransaccionVenta.get_transaccionesven():
                        ingresosautos += venta.get_ingreso()

                    # para hacer el string de ventas hechas por vendedores
                    for venta1 in TransaccionVenta.get_transaccionesven():
                        ventass += str(venta1.get_vendedor().get_nombre()) + ": " + str(venta1.get_ingreso()) \
                        + ", el " + str((venta1.get_vendedor().ventas/len(TransaccionVenta.get_transaccionesven())*100)) \
                        + " % del total de ingresos por concepto de venta de autos\n"

                    if ventass=="":
                        infovendedores.config(
                            text="No se han realizado ventas de vehículos hasta el momento")
                    else:
                        infovendedores.config(text=ventass)

                    # infoingresos (calcular suma de ingresos)
                    infoingresos.config(
                        text="Suma de ingresos: " + 
                        str(ingresosautos) + ", promedio de ingresos diarios en lo corrido del mes de "
                        + traducir_mes(str(nombre_mes)) + ": " + str(round((ingresosautos/dia_actual),0)))

                if opcion == "3":
                    
                    # Obtener la fecha y hora actual
                    fecha_actual = datetime.datetime.now()

                    # Obtener el mes de la fecha actual
                    mes_actual = fecha_actual.month
                    dia_actual = fecha_actual.day

                    nombre_mes = fecha_actual.strftime("%B")

                    def traducir_mes2(mes_en_ingles):
                        meses = {
                            'January': 'enero', 'February': 'febrero', 'March': 'marzo', 'April': 'abril',
                            'May': 'mayo', 'June': 'junio', 'July': 'julio', 'August': 'agosto',
                            'September': 'septiembre', 'October': 'octubre', 'November': 'noviembre', 'December': 'diciembre'
                        }
                        return meses[mes_en_ingles]
                    
                    etiqueta2.config(text="ESTADISTICAS DE VENTAS POR MARCA DE AUTO")

                    ## plantilla base (4):
                    container_4=tk.Frame(zona_interaccion2)
                    container_4.pack(side='top', anchor='c', padx=10, pady=10) #, expand=False)

                    # creando los labels donde irá la info
                    info1_4=tk.Label(container_4, 
                                   text="De los " + str(len(Auto.get_autos())) 
                                   + " autos que se tenían a comienzos del mes de junio, " + 
                                   str(len(TransaccionVenta.get_transaccionesven())) 
                                   + " (el " + str(round((len(TransaccionVenta.get_transaccionesven()))/(len(Auto.get_autos())),2))
                                   + "%) se han vendido, son:",
                                   justify="left")
                    infoventacarros=tk.Label(container_4, text="info de cada venta de carro", justify="left")

                    info2_4=tk.Label(container_4, text="Ventas ($) por marca de auto", justify="left")
                    infoventasmarca=tk.Label(container_4, text="ventas por marca", justify="left")

                    infoingresos2=tk.Label(container_4,
                                          text="Suma total de ingresos: #, promedio de ingresos diarios en lo corrido del mes de (mes): #.",
                                          justify="left")
                    
                    # metiendo los labels en el container_4
                    info1_4.pack(side='top', anchor='w', padx=10, pady=10, expand=False)
                    infoventacarros.pack(side='top', anchor='w', padx=10, pady=10, expand=False)
                    info2_4.pack(side='top', anchor='w', padx=10, pady=10, expand=False)
                    infoventasmarca.pack(side='top', anchor='w', padx=10, pady=10, expand=False)
                    infoingresos2.pack(side='top', anchor='w', padx=10, pady=10, expand=False)
                    ## fin plantilla base (4):

                    # metiendo la info a la plantilla 4
                    # infoventacarros
                    ventascarros = ""
                    for ventacarro in TransaccionVenta.get_transaccionesven():
                        ventascarros += Auto.info(ventacarro.get_auto()) + "\n"
                    
                    if ventascarros=="":
                        infoventacarros.config(
                            text="No se han realizado ventas de vehículos hasta el momento")
                    else:
                        infoventacarros.config(text=ventascarros)

                    #infoventasmarca
                    ventasToyota = 0
                    ventasChevrolet = 0
                    ventasMazda = 0

                    sumaventasToyota = 0
                    sumaventasChevrolet = 0
                    sumaventasMazda = 0

                    for ventacarro in TransaccionVenta.get_transaccionesven():
                        if ventacarro.get_auto().get_marca()=="Toyota":
                            ventasToyota+=1
                            sumaventasToyota+=ventacarro.get_auto().get_precio()
                        elif ventacarro.get_auto().get_marca()=="Chevrolet":
                            ventasChevrolet+=1
                            sumaventasChevrolet+=ventacarro.get_auto().get_precio()
                        else :
                            ventasMazda+=1
                            sumaventasMazda+=ventacarro.get_auto().get_precio()

                    sumaTotal = sumaventasToyota + sumaventasChevrolet + sumaventasMazda

                    StringToyota="Mazda: " + str(sumaventasToyota) + ", "+ str(round((sumaventasToyota/sumaTotal)*100,2)) \
                    + "% del total de ventas por concepto de venta de autos"
                    StringChevrolet="Chevrolet: " + str(sumaventasChevrolet) + ", " + str(round((sumaventasChevrolet/sumaTotal)*100,2)) \
                    + "% del total de ventas por concepto de venta de autos"
                    StringMazda="Mazda: " + str(sumaventasMazda) +  ", " + str(round((sumaventasMazda/sumaTotal)*100,2)) \
                    + "% del total de ventas por concepto de venta de autos"

                    StringInfoventasmarca = StringToyota + "\n" + StringChevrolet + "\n" + StringMazda

                    infoventasmarca.config(text=StringInfoventasmarca)

                    # infoingresos (calcular suma de ingresos)
                    infoingresos2.config(
                        text="Suma de ingresos: "
                        + str(sumaTotal) + ", promedio de ingresos diarios en lo corrido del mes de "
                        + traducir_mes2(str(nombre_mes)) + ": " + str(round((sumaTotal/dia_actual),0)))
                    


                    infoventacarros.config(text="")
            zona_interaccion = tk.LabelFrame(ventana_funcionalidad, relief="solid", highlightbackground="blue", bg="red")
            zona_interaccion.pack(side="top", pady=10)

            # Agregar contenido a la zona de interacción para la muestra del nombre de procesos y consultas
            etiquetatitulo = tk.Label(zona_interaccion, text="Bienvenido al portal de estadisticas de nuestro concesionario")
            etiquetatitulo.pack(side="top")

            # Crear la zona de interacción para deescripción del detalle de procesos o consultas
            zona_interaccion2 = tk.LabelFrame(ventana_funcionalidad, relief="solid", highlightbackground="blue")
            zona_interaccion2.pack(side="top")

            # Agregar contenido a la zona de interacción para descripción del detalle de procesos o consultas
            etiqueta2 = tk.Label(zona_interaccion2, text="ESTADISTICAS - INFO FINANCIERA")
            etiqueta2.pack(side="top", pady=7)

            # Coontainer
            container= tk.Frame(zona_interaccion2)
            container.pack(side='top', anchor='w', padx=120, pady=0, expand=False)

            # label, entry y button de cedula admin
            lbadmin = tk.Label(container, text="Introduzca su cedula", justify="left")
            entryadmin = tk.Entry(container)
            botonadmin = tk.Button(container, text="enviar", command=botonadmin1)
            #botonadmin.bind("<botonadmin>", lambda event: botonadmin(entryadmin.get()))
            lbadmin.pack(side='left', padx=0, pady=0)
            entryadmin.pack(side='left', padx=15, pady=0)
            botonadmin.pack(side='left', padx=5, pady=0)

        def crear_nuevo_usuario(nombre_proceso):
            global etiqueta
            global window2
            global ventana_funcionalidad
            global cliente
            limpiar(ventana_funcionalidad)

            def comprobar_cliente(event):
                global valor_nombre_cliente
                global valor_apellido_cliente
                global valor_cedula_cliente
                global valor_telefono_cliente
                global valor_correo_cliente
                global valor_direccion_cliente
                global valor_marca_cliente
                global valor_presupuesto_cliente

                valor_nombre_cliente = fp.getValue("Nombre")
                valor_apellido_cliente = fp.getValue("Apellido")
                valor_cedula_cliente = fp.getValue("Cédula")##
                valor_telefono_cliente = fp.getValue("Teléfono")##
                valor_correo_cliente = fp.getValue("Correo")
                valor_direccion_cliente = fp.getValue("Direccion")
                valor_marca_cliente = fp.getValue("Marca de interés")
                valor_presupuesto_cliente = fp.getValue("Presupuesto")##

                list = [valor_nombre_cliente,valor_apellido_cliente,valor_cedula_cliente,valor_telefono_cliente,valor_correo_cliente,valor_marca_cliente,valor_presupuesto_cliente,valor_direccion_cliente]
                
                if list[2]=="":
                    list[2]=0
                if list[3]=="":
                    list[3]=0
                if list[6]=="":
                    list[6]=0

                int(list[2])
                int(list[3])
                int(list[6])

                if Cliente.get_clientePorCedula(int(list[2]))!=None:
                    Exception(messagebox.showerror("Usuario ya registrado", "Esta cédula ya se encuentra registrada en el concesionario."))
                    for i in fp.entries:
                        i.delete(0, END)
                elif any((valor == "" or valor == 0) and indice != 7 for indice, valor in enumerate(list)):
                    messagebox.showwarning("Campos vacios", "Hay campos vacios, por favor llenelos.")
                else:
                    Cliente(list[0]+ "" + list[1], list[2], list[3], list[4], list[5], list[6], list[7])
                    messagebox.showinfo("Cliente registrado", "Ahora se encuentra registrado.")




            criterios = ["Nombre", "Apellido", "Cédula", "Teléfono", "Correo", "Direccion", "Marca de interés", "Presupuesto"]
            valores_iniciales = ["", "", "", "", "", "", "", ""]
            habilitados = [True, True, True, True, True, True, True, True]

            texto = tk.Label(ventana_funcionalidad, text="Escriba sus datos para crear el registro")
            fp = FieldFrame(ventana_funcionalidad,"Criterio", criterios, "Valor", valores_iniciales, habilitados)
            texto.pack(side="top", pady=5)
            fp.pack(side="top")
            comprobar = tk.Button(ventana_funcionalidad, text="Comprobar")
            comprobar.bind("<Button-1>", lambda event: comprobar_cliente(event))
            comprobar.pack(padx=5, pady=5)

        def administrador(nombre_proceso):
            global etiqueta
            global window2
            global ventana_funcionalidad
            limpiar(ventana_funcionalidad)

            def opciones_administrador(event):
                texto = tk.Label(ventana_funcionalidad, text="Seleccione una opción de administración")
                boton1 = tk.Button(ventana_funcionalidad, text="Asignar horarios")
                boton2 = tk.Button(ventana_funcionalidad, text="Añadir articulo")
                boton3 = tk.Button(ventana_funcionalidad, text="Añadir auto")
                boton4 = tk.Button(ventana_funcionalidad, text="Añadir vendedor")
                boton5 = tk.Button(ventana_funcionalidad, text="Añadir mecánico")
                texto.pack(pady=5)
                boton1.pack(pady=5)
                boton2.pack(pady=5)
                boton3.pack(pady=5)
                boton4.pack(pady=5)
                boton5.pack(pady=5)

            def comprobar_cliente(event):
                global valor_cedula_admin

                valor_cedula_admin = fp.getValue("Cédula")
                admin = Vendedor.get_vendedorPorCedula(int(valor_cedula_admin))
                if admin!=None and admin.get_puesto()=="admin":
                    pass
                else:
                    Exception(messagebox.showwarning("Acceso denegado","Usted no es administrador"))



            criterios = ["Cédula"]
            valores_iniciales = [""]
            habilitados = [True]

            texto = tk.Label(ventana_funcionalidad, text="Escriba sus datos para crear el registro")
            fp = FieldFrame(ventana_funcionalidad,"Criterio", criterios, "Valor", valores_iniciales, habilitados)
            texto.pack(side="top", pady=5)
            fp.pack(side="top")
            comprobar = tk.Button(ventana_funcionalidad, text="Comprobar")
            comprobar.bind("<Button-1>", lambda event: comprobar_cliente(event))
            comprobar.pack(padx=5, pady=5)




        '''print("\n\nMenú principal Concesionario")
        print("1. Venta de Autos")
        print("2. Venta de Repuestos")
        print("3. Taller")
        print("4. Consultar estadisticas / finanzas")
        print("5. Personalizar su auto")
        print("6. Crear nuevo usuario (Comprador)")
        print("7. Administración")'''
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





