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

    def get_horario(self):
        return self.horario

    def set_horario(self, horario):
        self.horario = horario

    def get_manoObra(self):
        return self.manoObra

    def set_manoObra(self, manoObra):
        self.manoObra = manoObra

    def get_autos(self):
        return self.autos

    def set_autos(self, autos):
        self.autos = autos

    def setEspecialidad(self, especialidad):
        self.especialidad = especialidad

    def get_especialidad(self):
        return self.especialidad

    @staticmethod
    def get_mecanicos():
        return Mecanico.mecanicos

    @staticmethod
    def set_mecanicos(mecanicos):
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
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos() and len(mecanico.get_horario()) >= 1:
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 2:
                especialidad = "Llantas"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 3:
                especialidad = "Motor"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 4:
                especialidad = "Frenos"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 5:
                especialidad = "ModificacionPintura"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 6:
                especialidad = "ModificacionLlantas"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 7:
                especialidad = "ModificacionSonido"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 8:
                especialidad = "ModificacionFrenos"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 9:
                especialidad = "ModificacionEscape"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
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
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 2:
                especialidad = "ModificacionLlantas"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 3:
                especialidad = "ModificacionSonido"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 4:
                especialidad = "ModificacionFrenos"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            elif input == 5:
                especialidad = "ModificacionEscape"
                for mecanico in Mecanico.get_mecanicos():
                    if especialidad == mecanico.get_especialidad() and auto.get_marca() == mecanico.get_autos():
                        mechs.add(mecanico)
                    salir = "si"
            else:
                print("\n¿Salir? (si/no)")
                input()

        return mechs

    @staticmethod
    def get_mecanicoPorCedula(cedula):
        finder = None
        for mecanico in Mecanico.mecanicos:
            if mecanico.get_cedula() == cedula:
                finder = mecanico

        return finder

    @staticmethod
    def readByte():
        num = int(input())
        return num

    
    def get_nombre(self):
        return self.nombre

    def get_cedula(self):
        return self.cedula

    def get_telefono(self):
        return self.telefono

    def get_correo(self):
        return self.correo

    def get_direccion(self):
        return self.direccion

    def set_nombre(self, nombre):
        self.nombre = nombre

    def set_cedula(self, cedula):
        self.cedula = cedula

    def set_telefono(self, telefono):
        self.telefono = telefono

    def set_correo(self, correo):
        self.correo = correo

    def set_direccion(self, direccion):
        self.direccion = direccion


    def calcular_salario(self):
        return self.pagoSvcs + self.getSalario()


    def info(self):
        texto = "Nombre del Mecanico: " + self.get_nombre() + "\n"
        return texto
