class TransaccionVentaTaller(Transaccion):
    transaccionesvental = []

    def __init__(self, tipo, ingreso, cliente, articulo, vendedor, transfer):
        super().__init__(tipo, ingreso, cliente, transfer)
        self.articulo = articulo
        self.vendedor = vendedor
        TransaccionVentaTaller.transaccionesvental.append(self)

    def info(self):
        txt = f"Transacción #{self.transfer:08d}: venta realizada por {self.vendedor.getNombre()} para el cliente {self.cliente.getNombre()} por un total de ${self.articulo.getPrecio()} por el artículo {self.articulo.getMarca()}"
        return txt

    @staticmethod
    def getClientePorCedula(cedula):
        finder = None
        cli = None

        for trans in TransaccionVentaTaller.transaccionesvental:
            if trans.getClienteCed() == cedula:
                finder = trans
                cli = finder.getCliente()
                break

        return cli

    @staticmethod
    def getTransaccionporCedula(cedula):
        finder = None

        for trans in TransaccionVentaTaller.transaccionesvental:
            if trans.getClienteCed() == cedula:
                finder = trans.getArticulo()
                break

        return finder

    def setArticulo(self, articulo):
        self.articulo = articulo

    def getArticulo(self):
        return self.articulo

    def setVendedor(self, vendedor):
        self.vendedor = vendedor

    def getVendedor(self):
        return self.vendedor

    @staticmethod
    def agregarTransaccion(transaccion):
        TransaccionVentaTaller.transaccionesvental.append(transaccion)

    @staticmethod
    def eliminarTransaccion(transaccion):
        TransaccionVentaTaller.transaccionesvental.remove(transaccion)

    @staticmethod
    def getTransaccionesven():
        return TransaccionVentaTaller.transaccionesvental
