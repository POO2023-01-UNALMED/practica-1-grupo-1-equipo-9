import sys
import os
ruta_activos = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Activos'))
ruta_personal = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'gestorAplicacion', 'Personal'))
ruta_gestor = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))
sys.path.append(ruta_activos)
sys.path.append(ruta_personal)
sys.path.append(ruta_gestor)


from trabajador import Trabajador

class Mecanico(Trabajador):
    mecanicos = []
    horario = []

    def __init__(self, nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco, autos, especialidad, manoObra):
        super().__init__(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco)
        self.autos = autos
        self.especialidad = especialidad
        self.pagoSvcs = 0
        self.manoObra = manoObra
        Mecanico.mecanicos.add(self)
        self.horario.append("9:00-11:00")
        self.horario.append("11:00-1:00")
        self.horario.append("2:00-4:00")
        self.horario.append("4:00-6:00")

    def getHorario(self):
        return self.horario

    def setHorario(self, horario):
        self.horario = horario

    def getManoObra(self):
        return self.manoObra

    def setManoObra(self, manoObra):
        self.manoObra = manoObra

    def getAutos(self):
        return self.autos

    def setAutos(self, autos):
        self.autos = autos

    def setEspecialidad(self, especialidad):
        self.especialidad = especialidad

    def getEspecialidad(self):
        return self.especialidad

    @staticmethod
    def getMecanicos():
        return Mecanico.mecanicos

    @staticmethod
    def setMecanicos(mecanicos):
        Mecanico.mecanicos = mecanicos

    @staticmethod
    def mecanicoDisponible(auto):
        input = 0
        salir = None
        especialidad = None
        mechs = []

        while salir is None:
            input = int(input())

            if input == 1:
                especialidad = "Pintura"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos() and len(mecanico.getHorario()) >= 1:
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 2:
                especialidad = "Llantas"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 3:
                especialidad = "Motor"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 4:
                especialidad = "Frenos"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 5:
                especialidad = "ModificacionPintura"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 6:
                especialidad = "ModificacionLlantas"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 7:
                especialidad = "ModificacionSonido"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 8:
                especialidad = "ModificacionFrenos"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 9:
                especialidad = "ModificacionEscape"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            else:
                print("\n¿Salir? (si/no)")
                input()

        return mechs

    @staticmethod
    def mecanicoModif(auto):
        input = 0
        salir = None
        especialidad = None
        mechs =[]

        while salir is None:
            input = int(input())

            if input == 1:
                especialidad = "ModificacionPintura"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 2:
                especialidad = "ModificacionLlantas"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 3:
                especialidad = "ModificacionSonido"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 4:
                especialidad = "ModificacionFrenos"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 5:
                especialidad = "ModificacionEscape"
                for mecanico in Mecanico.getMecanicos():
                    if especialidad == mecanico.getEspecialidad() and auto.getMarca() == mecanico.getAutos():
                        mechs.add(mecanico)
                    salir = "si"
            else:
                print("\n¿Salir? (si/no)")
                input()

        return mechs

    @staticmethod
    def getMecanicoPorCedula(cedula):
        finder = None
        for mecanico in Mecanico.mecanicos:
            if mecanico.getCedula() == cedula:
                finder = mecanico

        return finder

    @staticmethod
    def readByte():
        num = int(input())
        return num

    
    def getNombre(self):
        return self.nombre

    def getCedula(self):
        return self.cedula

    def getTelefono(self):
        return self.telefono

    def getCorreo(self):
        return self.correo

    def getDireccion(self):
        return self.direccion

    def setNombre(self, nombre):
        self.nombre = nombre

    def setCedula(self, cedula):
        self.cedula = cedula

    def setTelefono(self, telefono):
        self.telefono = telefono

    def setCorreo(self, correo):
        self.correo = correo

    def setDireccion(self, direccion):
        self.direccion = direccion


    def calcularSalario(self):
        return self.pagoSvcs + self.getSalario()


    def info(self):
        texto = "Nombre del Mecanico: " + self.getNombre() + "\n"
        return texto
