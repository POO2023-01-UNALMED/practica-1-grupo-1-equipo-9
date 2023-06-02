class TransaccionTaller(Transaccion):
    transaccionestal = []

    def __init__(self, tipo, ingreso, cliente, auto, articulo, mecanico, transfer):
        super().__init__(tipo, ingreso, cliente, transfer)
        self.auto = auto
        self.mecanico = mecanico
        self.articulo = articulo
        TransaccionTaller.transaccionestal.append(self)

    def info(self):
        txt = f"Transacción #{self.transfer:08d}: {self.tipo} realizado por {self.mecanico.nombre} para el cliente {self.cliente.nombre} por un total de ${self.ingreso}"
        return txt

    @staticmethod
    def getClientePorCedula(cedula):
        finder = None
        cli = None

        for trans in TransaccionTaller.transaccionestal:
            if trans.getClienteCed() == cedula:
                finder = trans
                cli = finder.getCliente()
                break

        return cli

    @staticmethod
    def getTransaccionporCedula(cedula):
        finder = None

        for trans in TransaccionTaller.transaccionestal:
            if trans.getClienteCed() == cedula:
                finder = trans.getAuto()
                break

        return finder

    def setAuto(self, auto):
        self.auto = auto

    def getAuto(self):
        return self.auto

    def setMecanico(self, mecanico):
        self.mecanico = mecanico

    def getMecanico(self):
        return self.mecanico

    def setArticulo(self, articulo):
        self.articulo = articulo

    def getArticulo(self):
        return self.articulo

    @staticmethod
    def agregarTransaccion(transaccion):
        TransaccionTaller.transaccionestal.append(transaccion)

    @staticmethod
    def eliminarTransaccion(transaccion):
        TransaccionTaller.transaccionestal.remove(transaccion)

    @staticmethod
    def getTransaccionestal():
        return TransaccionTaller.transaccionestal