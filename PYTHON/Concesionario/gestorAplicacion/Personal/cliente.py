import sys
sys.path.append('C:\\Users\\felip\\OneDrive\\Documentos\\GitHub\\practica-1-grupo-1-equipo-9\\PYTHON\\Concesionario\\gestorAplicacion\\Personal')
sys.path.append('C:\\Users\\felip\\OneDrive\\Documentos\\GitHub\\practica-1-grupo-1-equipo-9\\PYTHON\\Concesionario\\gestorAplicacion\\Activos')


from persona import Persona

class Cliente(Persona):
    clientes = []

    def __init__(self, nombre, cedula, telefono, correo, modeloInteres, presupuesto, direccion="Medellin"):
        self.nombre = nombre
        self.cedula = cedula
        self.telefono = telefono
        self.correo = correo
        self.direccion = direccion
        self.modeloInteres = modeloInteres
        self.presupuesto = presupuesto
        Cliente.clientes.append(self)

    def getModeloInteres(self):
        return self.modeloInteres

    def getPresupuesto(self):
        return self.presupuesto

    def setModeloInteres(self, modeloInteres):
        self.modeloInteres = modeloInteres

    def setPresupuesto(self, presupuesto):
        self.presupuesto = presupuesto

    def setAuto(self, auto):
        self.auto = auto

    def getAuto(self):
        return self.auto

    @staticmethod
    def getClientes():
        return Cliente.clientes

    @staticmethod
    def getClientePorCedula(cedula):
        finder = None
        for cliente in Cliente.clientes:
            if cliente.getCedula() == cedula:
                finder = cliente
                break
        return finder

    @staticmethod
    def setClientes(clientes):
        Cliente.clientes = clientes

    def info(self):
        texto = "Nombre del cliente: " + self.getNombre() + "\n"
        return texto

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
