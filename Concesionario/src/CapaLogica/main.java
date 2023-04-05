package CapaLogica;

public class main {

	public static void main(String[] args) {
		Auto a1= new Auto("Cupra", 20000000, 5400, "verde fofo", true, false);
		Cliente c1= new Cliente("Ernesto",123443222,556655,"trtr","avenida siempreviva","cupra",23000000);
		
		System.out.print(InventarioAuto.autosDisponibles());


	}

}
