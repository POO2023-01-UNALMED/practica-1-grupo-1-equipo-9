from abc import ABC, abstractmethod

class Persona(ABC):
    @abstractmethod
    def get_nombre(self):
        pass

    @abstractmethod
    def get_cedula(self):
        pass

    @abstractmethod
    def get_telefono(self):
        pass

    @abstractmethod
    def get_correo(self):
        pass

    @abstractmethod
    def get_direccion(self):
        pass

    @abstractmethod
    def set_nombre(self, nombre):
        pass

    @abstractmethod
    def set_cedula(self, cedula):
        pass

    @abstractmethod
    def set_telefono(self, telefono):
        pass

    @abstractmethod
    def set_correo(self, correo):
        pass

    @abstractmethod
    def set_direccion(self, direccion):
        pass

    @abstractmethod
    def info(self):
        pass