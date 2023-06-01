class Mecanico(Trabajador):
    mecanicos = ArrayList[Mecanico]()
    horario = ArrayList[str]()

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
        mechs = ArrayList[Mecanico]()

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
                salir = sc.nextLine()

        return mechs

    @staticmethod
    def mecanicoModif(auto):
        input = 0
        salir = None
        especialidad = None
        mechs = ArrayList[Mecanico]()

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
                salir = sc.nextLine()

        return mechs

    @staticmethod
    def getMecanicoPorCedula(cedula):
        finder = None
        for mecanico in mecanicos:
            if mecanico.getCedula() == cedula:
                finder = mecanico

        return finder

    @staticmethod
    def readByte():
        num = int(input())
        return num

    @Override
    def getNombre():
        return nombre

    @Override
    def getCedula():
        return cedula

    @Override
    def getTelefono():
        return telefono

    @Override
    def getCorreo():
        return correo

    @Override
    def getDireccion():
        return direccion

    @Override
    def setNombre(nombre):
        this.nombre = nombre

    @Override
    def setCedula(cedula):
        this.cedula = cedula

    @Override
    def setTelefono(telefono):
        this.telefono = telefono

    @Override
    def setCorreo(correo):
        this.correo = correo

    @Override
    def setDireccion(direccion):
        this.direccion = direccion

    @Override
    def calcularSalario():
        return pagoSvcs + getSalario()

    @Override
    def info():
        texto = "Nombre del Mecanico: " + getNombre() + "\n"
        return texto
