package CapaLogica;

public class main {

	public static void main(String[] args) {
		Auto a1 = new Auto("Chevrolet", 23000000, 2500, "verde azumadrardo", true, true);
		Auto a2 = new Auto("Chevrolet", 23000000, 2500, "verde azumadrardo", true, false);
		Auto a3 = new Auto("Chevrolet", 23000000, 2500, "verde azumadrardo", true, false);
		Auto a4 = new Auto("Chevrolet", 23000000, 2500, "verde azumadrardo", true, false);

		System.out.print(InventarioAuto.autosDisponibles());

	}

}
