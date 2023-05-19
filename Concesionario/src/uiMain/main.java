package uiMain;

import java.util.*;
import baseDatos.*;
import gestorAplicacion.activos.*;
import gestorAplicacion.personal.*;
import java.time.LocalDate;
import java.time.format.TextStyle;

public class main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		boolean volverAlMenuPrincipal = true;
		/*INTERFAZ*/
		byte input;
		Deserializador.deserializarArrays();		
		do {
			System.out.println("\n\nMenú principal Concesionario");
			System.out.println("1. Venta de Autos");
			System.out.println("2. Venta de Repuestos");
			System.out.println("3. Taller");
			System.out.println("4. Consultar estadisticas de ventas");
			System.out.println("5. Personalizar su auto");
			System.out.println("6. Crear nuevo usuario (Comprador)");	
			System.out.println("7. Administración");	
			System.out.println("8. Salir");		
			System.out.print("Ingrese el número de la opción que va a utilizar: ");
			String respuesta=null;
			input = sc.nextByte();
			
			switch (input) {
			case 1:
				procesoVenta();
	            System.out.print("\n¿Desea volver al menú principal? (si/no): ");
	            respuesta = sc.next();
	            if(respuesta.equals("no")){
					Serializador.serializarArrays();
	                volverAlMenuPrincipal = false;
	            }
	            break;
			case 2:
				ventaRepuestos();
	            System.out.print("\n¿Desea volver al menú principal? (si/no): ");
	            respuesta = sc.next();
	            if(respuesta.equals("no")){
					Serializador.serializarArrays();
	                volverAlMenuPrincipal = false;
	            }
	            break;
			case 3:
				procesoTaller();
	            System.out.print("\n¿Desea volver al menú principal? (si/no): ");
	            respuesta = sc.next();
	            if(respuesta.equals("no")){
					Serializador.serializarArrays();
	                volverAlMenuPrincipal = false;
	            }
	            break;
			case 4:
				stats();
	            System.out.print("\n¿Desea volver al menú principal? (si/no): ");
	            respuesta = sc.next();
	            if(respuesta.equals("no")){
					Serializador.serializarArrays();
	                volverAlMenuPrincipal = false;
	            }
				break;
			case 5:
				personalizarAuto();
	            System.out.print("\n¿Desea volver al menú principal? (si/no): ");
	            respuesta = sc.next();
	            if(respuesta.equals("no")){
					Serializador.serializarArrays();
	                volverAlMenuPrincipal = false;
	            }
	            break;
			case 6:
				crearUsuario();
	            System.out.print("\n¿Desea volver al menú principal? (si/no): ");
	            respuesta = sc.next();
	            if(respuesta.equals("no")){
					Serializador.serializarArrays();
	                volverAlMenuPrincipal = false;
	            }
	            break;
			case 7:
				administracion();
	            System.out.print("\n¿Desea volver al menú principal? (si/no): ");
	            respuesta = sc.next();
	            if(respuesta.equals("no")){
					Serializador.serializarArrays();
	                volverAlMenuPrincipal = false;
	            }
	            break;
			default:
				System.out.print("\nHasta pronto"+"\n"+"\n");
				System.out.print("App realizada por:"+"\n"+"Juan Jose Alzate"+"\n"+"Santiago Florez"+"\n"+"Felipe Velez Fernandez"+"\n"+"Jonatan "+"\n"+"Copyright (c) 2023"+"\n"+"All Rights Reserved"+"\n"+"\n"+"This product is protected by copyright and distributed under"+"\n"+"licenses restricting copying, distribution, and decompilation.");
				Serializador.serializarArrays();
	            volverAlMenuPrincipal = false;
				break;
			}
		}while(volverAlMenuPrincipal);
		
	}
		/*INTERFAZ*/
		
	
	public static void procesoVenta() {
		Cliente comprador = null;
		Vendedor vendedor = null;
		Auto auto = null;
		Scanner sc = new Scanner(System.in);
		
		while (comprador==null) {
			System.out.println("Escriba la cédula del comprador: ");
			long cedula = sc.nextLong();
			comprador = Cliente.getClientePorCedula(cedula);
			if (comprador==null) {
				System.out.println("La cédula ingresada no se encuentra registrada. Por favor, vuelva a ingresarla.");
			}
		}
		
		/*Selección del carro*/
		int opcion = 0;
		System.out.print(comprador.info()+"Su presupuesto es: "+comprador.getPresupuesto()+"\n");
		System.out.println("Estos son los autos de la marca de interés para el cliente disponibles en este momento: ");
		/*AUTOS POR MODELO*/
		
		ArrayList<Auto> autosMod = new ArrayList<Auto>();
		String result1 = String.format("%-20s%-10s%-10s\n", "   Modelo", "   Precio", "   Color");
		int j = 0;
		for (Auto auto1 : gestorAplicacion.activos.InventarioAuto.getAutosDisponibles()) {
	        if (comprador.getModeloInteres().equals(auto1.getMarca())) {
	            j++;
	            autosMod.add(auto1);
	            String carInfo1 = String.format("%-20s%-10s%-10s\n", auto1.getModelo(), auto1.getPrecio(), auto1.getColor());
	            result1 += String.format("%-3d%s", j, carInfo1);
	        }
	    }
		if (autosMod.size()>1){
		    System.out.println("Los carros de la marca " + comprador.getModeloInteres() + " disponibles son:\n");
		    System.out.println(result1);
		    System.out.println("Seleccione el numero del carro" + "[1-" + autosMod.size() + "] ");
	    } else if (autosMod.size()==1) {
	    	System.out.println("El unico carro de modelo " + comprador.getModeloInteres() + " disponible es:\n");
		    System.out.println(result1);
		    System.out.println("Lo desea seleccionar? (y/n): ");
		    String resp = sc.nextLine();
		    if (resp.equals("y")) {
		    	auto=autosMod.get(0);
		    } else {
		    	auto=null;
		    }
	    } else if (autosMod.size()==0) {
	    	System.out.println("No hay carros disponibles del modelo seleccionado");
	    	auto=null;
	    }
		
		/*AUTOS POR MODELO*/
		System.out.println("0. Más opciones de busqueda...");
		System.out.println("Seleccione el Auto en el que está interesado o use las otras opciones de busqueda: ");
		opcion = sc.nextInt();
		if (opcion==0) {
			System.out.println("1. Mostrar Autos por Marca");
			System.out.println("2. Mostrar Autos por precio");
			System.out.println("3. Mostrar todos los autos");
			System.out.println("4. Volver al inicio.");
			System.out.println("Seleccione una opción: ");
			switch (sc.nextInt()){
				/*AUTOS POR MARCA*/
				case 1:
					String marca = ""; 
					System.out.println("1. Mazda");
					System.out.println("2. Toyota");
					System.out.println("3. Chevrolet");
					System.out.println("4. Volver al inicio.");
					System.out.println("Seleccione la marca [1-3]: ");
					switch (sc.nextInt()){
					case 1:
						marca = "Mazda";
						break;
					case 2:
						marca = "Toyota";
						break;
					case 3:
						marca = "Chevrolet";
						break;
					}if (marca!="") {
						ArrayList<Auto> autosMarca = new ArrayList<Auto>();
						for(Auto auto2:gestorAplicacion.activos.InventarioAuto.getAutosDisponibles()) {
							if(auto2.getMarca().equals(marca)) {
								autosMarca.add(auto2);
							}
						}
						System.out.println("Estos son los carros disponibles de esta marca: ");
						int cont = 1;
						String result2 = String.format("%-20s%-20s%-10s\n", "   Modelo", "   Precio", "   Color");
						for (Auto auto3:autosMarca) {
					        String carInfo2 = String.format("%-20s%-20s%-10s\n", auto3.getModelo(), auto3.getPrecio(), auto3.getColor());
					        result2 += String.format("%-3d%s", cont, carInfo2);
					        cont++;
					    }
						System.out.println(result2);
						System.out.println("0  volver");
						System.out.println("Escribe el número del auto a escoger: ");
						if (sc.nextInt()!=0) {
							auto = autosMarca.get(sc.nextInt()-1);
							System.out.println("El auto elegido es " + auto.info());
							System.out.println("¿Desea confirmar?:  (si/no)");
							sc.nextLine();
							/*CREADOR DE TRANSACCION*/
							if (!sc.nextLine().equals("no")) {
								ArrayList<Vendedor> vendedores= Vendedor.selectorVend(auto);
								String resultado = String.format("%-40s%-15s%n", "   Vendedor", "   Tipo de venta");
						 	    byte v=0;
						 	    for (Vendedor vend:vendedores) {
						 	    	v++;
					 	            String vendedorinfo = String.format("%-40s%-15s%n", vend.getNombre(), vend.getPuesto());
					 	            resultado += String.format("%-3d%s", v, vendedorinfo );
						 	    }if (vendedores.size() >= 1) {
						 	        System.out.println("Los vendedores de " + vendedores.get(0).getPuesto() + " disponibles son:\n");
						 	        System.out.println(resultado);
						 	        int num = 0;
						 	        while (num <= 0 || num > vendedores.size()) {
						 	            System.out.println("Seleccione el numero del vendedor" + "[1-" + vendedores.size() + "]: ");
						 	            if (sc.hasNextInt()) {
						 	                num = sc.nextInt();
						 	            } else {
						 	                System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + vendedores.size() + ".");
						 	                sc.nextLine(); // Limpiar la entrada no válida
						 	            }
						 	        }
						 	        vendedor = vendedores.get(num - 1);
		
		
						 	    } else if (vendedores.size() == 0) {
						 	        System.out.println("No hay vendedores disponibles para su vehiculo");
						 	    }
								
								if(comprador.getPresupuesto()>=auto.getPrecio()) {
									auto.setDueno(comprador);
									auto.setDisponible(false);
									comprador.setAuto(auto);
						 	        vendedor.confirmarVenta();
						 	        long deducido = comprador.getPresupuesto()-auto.getPrecio();
									int transfer = (int) (Math.random() * 1000);
									System.out.println(new TransaccionVenta("efectivo", deducido, comprador, auto, vendedor,transfer).info());
									System.out.print("");
								}
							}
						/*CREADOR DE TRANSACCION*/
						
						}else {break;}
						
					}else {
						break;
					}		
						
					break;
				/*AUTOS POR MARCA*/
				/*AUTOS POR PRECIO*/
				case 2:
					int contt = 1;
					System.out.println("Estos son los autos ordenados por precio de mayor a menor: ");
					String result3 = String.format("%-20s%-20s%-10s\n", "   Modelo", "   Precio", "   Color");
					for (Auto auto4:InventarioAuto.getAutosporPrecio(comprador)) {
				        String carInfo3 = String.format("%-20s%-20s%-10s\n", auto4.getModelo(), auto4.getPrecio(), auto4.getColor());
				        result3 += String.format("%-3d%s", contt, carInfo3);
				        contt++;
				    }
					System.out.println(result3);
					System.out.println("0  volver");
					System.out.println("Escribe el número del auto a escoger: ");
					if (sc.nextInt()!=0) {
						auto = InventarioAuto.getAutosporPrecio(comprador).get(sc.nextInt()-1);
						System.out.println("El auto elegido es " + auto.info());
						System.out.println("¿Desea confirmar?:  (si/no)");
						sc.nextLine();
						/*CREADOR DE TRANSACCION*/
						if (!sc.nextLine().equals("no")) {
							ArrayList<Vendedor> vendedores= Vendedor.selectorVend(auto);
							String resultado = String.format("%-40s%-15s%n", "   Vendedor", "   Tipo de venta");
					 	    byte v=0;
					 	    for (Vendedor vend:vendedores) {
					 	    	v++;
				 	            String vendedorinfo = String.format("%-40s%-15s%n", vend.getNombre(), vend.getPuesto());
				 	            resultado += String.format("%-3d%s", v, vendedorinfo );
					 	    }if (vendedores.size() >= 1) {
					 	        System.out.println("Los vendedores de " + vendedores.get(0).getPuesto() + " disponibles son:\n");
					 	        System.out.println(resultado);
					 	        int num = 0;
					 	        while (num <= 0 || num > vendedores.size()) {
					 	            System.out.println("Seleccione el numero del vendedor" + "[1-" + vendedores.size() + "]: ");
					 	            if (sc.hasNextInt()) {
					 	                num = sc.nextInt();
					 	            } else {
					 	                System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + vendedores.size() + ".");
					 	                sc.nextLine(); // Limpiar la entrada no válida
					 	            }
					 	        }
					 	        vendedor = vendedores.get(num - 1);


					 	    } else if (vendedores.size() == 0) {
					 	        System.out.println("No hay vendedores disponibles para su vehiculo");
					 	    }
							
							if(comprador.getPresupuesto()>=auto.getPrecio()) {
								auto.setDueno(comprador);
								auto.setDisponible(false);
								comprador.setAuto(auto);
					 	        vendedor.confirmarVenta();
					 	        long deducido = comprador.getPresupuesto()-auto.getPrecio();
					 	        comprador.setPresupuesto(deducido);
								int transfer = (int) (Math.random() * 1000);
								System.out.println(new TransaccionVenta("efectivo", deducido, comprador, auto, vendedor,transfer).info());
								System.out.print("");

							}
						}else {break;}
						/*CREADOR DE TRANSACCION*/
						break;
					}
					break;
				/*AUTOS POR PRECIO*/
				/*TODOS LOS AUTOS*/
				case 3:
					int conttt = 1;
					System.out.println("Autos Disponibles: ");
					String result4 = String.format("%-20s%-20s%-10s\n", "   Modelo", "   Precio", "   Color");
					for (Auto auto5:InventarioAuto.getAutosDisponibles()) {
				        String carInfo4 = String.format("%-20s%-20s%-10s\n", auto5.getModelo(), auto5.getPrecio(), auto5.getColor());
				        result4 += String.format("%-3d%s", conttt, carInfo4);
				        conttt++;
				    }
					System.out.println(result4);
					System.out.println("0  Volver");
					System.out.println("Escribe el número del auto a escoger: ");
					if (sc.nextInt()!=0) {
						auto = InventarioAuto.getAutosDisponibles().get(sc.nextInt()-1);
						System.out.println("El auto elegido es " + auto.info());
						System.out.println("¿Desea confirmar?:  (si/no)");
						sc.nextLine();
						/*CREADOR DE TRANSACCION*/
						if (!sc.nextLine().equals("no")) {
							ArrayList<Vendedor> vendedores= Vendedor.selectorVend(auto);
							String resultado = String.format("%-40s%-15s%n", "   Vendedor", "   Tipo de venta");
					 	    byte v=0;
					 	    for (Vendedor vend:vendedores) {
					 	    	v++;
				 	            String vendedorinfo = String.format("%-40s%-15s%n", vend.getNombre(), vend.getPuesto());
				 	            resultado += String.format("%-3d%s", v, vendedorinfo );
					 	    }if (vendedores.size() >= 1) {
					 	        System.out.println("Los vendedores de " + vendedores.get(0).getPuesto() + " disponibles son:\n");
					 	        System.out.println(resultado);
					 	        int num = 0;
					 	        while (num <= 0 || num > vendedores.size()) {
					 	            System.out.println("Seleccione el numero del vendedor" + "[1-" + vendedores.size() + "]: ");
					 	            if (sc.hasNextInt()) {
					 	                num = sc.nextInt();
					 	            } else {
					 	                System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + vendedores.size() + ".");
					 	                sc.nextLine(); // Limpiar la entrada no válida
					 	            }
					 	        }
					 	        vendedor = vendedores.get(num - 1);


					 	    } else if (vendedores.size() == 0) {
					 	        System.out.println("No hay vendedores disponibles para su vehiculo");
					 	    }
							
							if(comprador.getPresupuesto()>=auto.getPrecio()) {
								auto.setDueno(comprador);
								auto.setDisponible(false);
								comprador.setAuto(auto);
					 	        vendedor.confirmarVenta();
					 	        long deducido = comprador.getPresupuesto()-auto.getPrecio();
					 	        comprador.setPresupuesto(deducido);
								int transfer = (int) (Math.random() * 1000);
								System.out.println(new TransaccionVenta("efectivo", deducido, comprador, auto, vendedor,transfer).info());
								System.out.print("");

							}
						}else {break;}
						/*CREADOR DE TRANSACCION*/
						break;
					/*TODOS LOS AUTOS*/
					}
					
				case 4:
					break;
			}
		}else if (opcion!=0) {
			auto = autosMod.get(opcion-1);
			System.out.println("El auto elegido es " + auto.info());
			System.out.println("¿Desea confirmar?:  (si/no)");
			sc.nextLine();
			/*CREADOR DE TRANSACCION*/
			if (!sc.nextLine().equals("no")) {
				ArrayList<Vendedor> vendedores= Vendedor.selectorVend(auto);
				String resultado = String.format("%-40s%-15s%n", "   Vendedor", "   Tipo de venta");
		 	    byte v=0;
		 	    for (Vendedor vend:vendedores) {
		 	    	v++;
	 	            String vendedorinfo = String.format("%-40s%-15s%n", vend.getNombre(), vend.getPuesto());
	 	            resultado += String.format("%-3d%s", v, vendedorinfo );
		 	    }if (vendedores.size() >= 1) {
		 	        System.out.println("Los vendedores de " + vendedores.get(0).getPuesto() + " disponibles son:\n");
		 	        System.out.println(resultado);
		 	        int num = 0;
		 	        while (num <= 0 || num > vendedores.size()) {
		 	            System.out.println("Seleccione el numero del vendedor" + "[1-" + vendedores.size() + "]: ");
		 	            if (sc.hasNextInt()) {
		 	                num = sc.nextInt();
		 	            } else {
		 	                System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + vendedores.size() + ".");
		 	                sc.nextLine(); // Limpiar la entrada no válida
		 	            }
		 	        }
		 	        vendedor = vendedores.get(num - 1);


		 	    } else if (vendedores.size() == 0) {
		 	        System.out.println("No hay vendedores disponibles para su vehiculo");
		 	    }
				
				if(comprador.getPresupuesto()>=auto.getPrecio()) {
					auto.setDueno(comprador);
					auto.setDisponible(false);
					comprador.setAuto(auto);
		 	        vendedor.confirmarVenta();
		 	        long deducido = comprador.getPresupuesto()-auto.getPrecio();
		 	        comprador.setPresupuesto(deducido);
					int transfer = (int) (Math.random() * 1000);
					System.out.println(new TransaccionVenta("efectivo", deducido, comprador, auto, vendedor,transfer).info());
					System.out.print("");

				}
			}
			/*CREADOR DE TRANSACCION*/
		}	
	}
	
	public static void procesoTaller() {
			Scanner sc = new Scanner(System.in);
			Cliente propietario = null;
			Auto auto=null;

			
		while (propietario == null || auto == null) {
			System.out.print("Introduzca la cédula del propietario: ");
			long cedula = sc.nextLong(); 
			sc.nextLine();
			//Se ingresa una cedula y se devuelve un cliente y un auto, donde se verifica que el cliente si tenga transacciones.
			propietario = TransaccionVenta.getClientePorCedula(cedula);
			auto = TransaccionVenta.getTransaccionporCedula(cedula);
			
			if (propietario == null || auto == null) {
				System.out.println("La cédula ingresada no se encuentra en Transaccion. Por favor, vuelva a ingresarla.");
			}
		}
		
		System.out.print(propietario.info());
		String confirmarPrp=null;

		while (confirmarPrp==null||confirmarPrp.equals("no")) {
			System.out.print("¿Confirmar propietario? (si/no)");
			confirmarPrp = sc.nextLine();
			if (confirmarPrp.equals("no")) {
				System.out.print("Introduzca la cédula del propietario: ");
				long cedula = sc.nextLong();
				sc.nextLine();
				propietario = TransaccionVenta.getClientePorCedula(cedula);
				auto = TransaccionVenta.getTransaccionporCedula(cedula);
				System.out.print(propietario.info());
				
				if (propietario == null || auto == null) {
					System.out.println("La cédula ingresada no se encuentra en Transaccion. Por favor, vuelva a ingresarla.");
				}
			}
			
		}
		if (confirmarPrp.equals("si")) {
	        System.out.println("\n\nQue deseas hacerle al Vehiculo");
	        System.out.println("1. Latoneria y pintura");
	        System.out.println("2. Cambio de Llantas y alineacion");
	        System.out.println("3. Cambio de Aceite");
	        System.out.println("4. Cambio de Frenos");
	        System.out.print("Ingrese el número de la opción que va a utilizar: ");
	        //Se ingresa el auto que se devolvio anteriormente y este entrega una lista de mecanicos
			ArrayList<Mecanico> mecanicos=Mecanico.mecanicoDisponible(auto);
			//Selector
			Scanner sc1 = new Scanner(System.in);
		    String result = String.format("%-20s%-20s%-10s%-10s%n", "   Nombre","   Cedula", "   Atiende", "   Especialidad");
		    byte j=0;
		    for (Mecanico mecanico : mecanicos) {
		    		j++;
		            String mechInfo = String.format("%-20s%-20s%-10s%-10s%n", mecanico.getNombre(),mecanico.getCedula(), mecanico.getAutos(),mecanico.getEspecialidad());
		            result += String.format("%-3d%s", j, mechInfo);
		    }
		    Mecanico mecanico = null;
		    
		    if (mecanicos.size() >= 1) {
		        System.out.println("Los mecanicos que atienden " + auto.getMarca() + " disponibles son:\n");
		        System.out.println(result);
		        int num = 0;
		        while (num <= 0 || num > mecanicos.size()) {
		            System.out.println("Seleccione el numero del mecanico" + "[1-" + mecanicos.size() + "]: ");
		            if (sc.hasNextInt()) {
		                num = sc.nextInt();
		            } else {
		                 System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + mecanicos.size() + ".");
		                sc.nextLine(); // Limpiar la entrada no válida
		            }
		        }
		        mecanico = mecanicos.get(num - 1);

		    } else if (mecanicos.size() == 0) {
		        System.out.println("No hay mecanicos disponibles que atiendan su vehiculo");
		    }
			String confirmarMech=null;
			while (confirmarMech==null||confirmarMech.equals("no")) {
				System.out.print("¿Confirmar mecanico? (si/no)");
				confirmarMech = sc.nextLine();
		}if(!sc.nextLine().equals("no")) {
			Articulo articulo=null;
			String confirmarProd=null; 
			//Ingresa este mecanico que se selecciono y se devuekve una lista de productos
			ArrayList<Articulo> producto=InventarioArticulo.articuloDispo(mecanico);
			//Selector
	 	    String resultp = String.format("%-15s%-40s%-25s%-40s%-15s%-15s%n", "   Referencia","   Producto", "   Tipo Vehiculo", "   Marca", "   Precio","Cantidad");
	 	    byte i=0;
	 	    for (Articulo articuloi:producto) {
	 	    	i++;
 	            String mechInfo = String.format("%-15s%-40s%-25s%-40s%-15s%-15s%n",articuloi.getReferencia() ,articuloi.getTipoArticulo(), articuloi.getTipoVehiculo(),articuloi.getMarca(),articuloi.getPrecio(),articuloi.getCantidad());
 	            resultp += String.format("%-3d%s", i, mechInfo);
	 	    }if (producto.size() >= 1) {
	 	        System.out.println("Los productos " + mecanico.getEspecialidad() + " disponibles son:\n");
	 	        System.out.println(resultp);
	 	        int num = 0;
	 	        while (num <= 0 || num > producto.size()) {
	 	            System.out.println("Seleccione el numero del producto" + "[1-" + producto.size() + "]: ");
	 	            if (sc.hasNextInt()) {
	 	                num = sc.nextInt();
	 	            } else {
	 	                System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + producto.size() + ".");
	 	                sc.nextLine(); // Limpiar la entrada no válida
	 	            }
	 	        }
	 	        articulo = producto.get(num - 1);

	 	    } else if (producto.size() == 0) {
	 	        System.out.println("No hay productos disponibles para su vehiculo");
	 	    }
			
			while (confirmarProd==null||confirmarProd.equals("no")) {
				System.out.print("¿Confirmar producto? (si/no)");
				confirmarProd = sc.nextLine();
		}if(!sc.nextLine().equals("no")) {
			String confirmarTrans=null;
			while (confirmarTrans==null||confirmarTrans.equals("no")) {
			if(articulo.getEspecialidad().equals("Motor")) {
				System.out.print("El procedimiento a realizar es: Cambio de aceite con "+articulo.getTipoArticulo()+", y su mecanico será "+mecanico.getNombre()+"\n");
			}
			
			else if(articulo.getEspecialidad().equals("Llantas")) {
				System.out.print("El procedimiento a realizar es: Cambio de Llantas con "+articulo.getTipoArticulo()+", y su mecanico será "+mecanico.getNombre()+"\n");
			}
			else if(articulo.getEspecialidad().equals("Pintura")) {
				System.out.print("El procedimiento a realizar es: Latoneria y pintura con "+articulo.getTipoArticulo()+", y su mecanico será "+mecanico.getNombre()+"\n");
			}
			else if(articulo.getEspecialidad().equals("Frenos")) {
				System.out.print("El procedimiento a realizar es: Cambio de frenos con "+articulo.getTipoArticulo()+", y su mecanico será "+mecanico.getNombre()+"\n");
			}
			System.out.print("¿Confirmar Transaccion? (si/no)");
			confirmarTrans= sc.nextLine();
			if(confirmarTrans.equals("si")) {
				//selecciona la hora a la cual esta disponible el mecanico.
				System.out.print("Seleccione la hora para su servicio"+"\n");
				System.out.print("Esta es la agenda de: "+mecanico.getNombre()+"\n");
				 String resulth = String.format("%-20s%n", "   Horario disponible");
				    byte h=0;
				    for(String hora:mecanico.getHorario()) {
				    	h++;
			            String hor = String.format("%-20s%n", hora);
			            resulth += String.format("%-3d%s", h, hor);
				    }
				    if (mecanico.getHorario().size() >= 1) {
				        System.out.println("Las horas disponibles son:\n");
				        System.out.println(resulth);
				        int num = 0;
				        while (num <= 0 || num > mecanico.getHorario().size()) {
				            System.out.println("Seleccione la hora" + "[1-" + mecanico.getHorario().size() + "]: ");
				            if (sc.hasNextInt()) {
				                num = sc.nextInt();
				            } else {
				                 System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + mecanicos.size() + ".");
				                sc.nextLine(); // Limpiar la entrada no válida
				            }
				        }
						System.out.print("La hora de su cita es"+ mecanico.getHorario().get(num-1)+"\n");
				        mecanico.getHorario().remove(num-1);
				    } else if (mecanicos.size() == 0) {
				        System.out.println("No hay hora disponible");
				    }
					long costoTotal=(long) (mecanico.getManoObra()+articulo.getPrecio());
					System.out.print("El precio total por su Servicio es:"+costoTotal+"\n");
					//Reune todos los objetos y crea un objeto llamado transaccion.
					int transfer = (int) (Math.random() * 1000);
					System.out.print(new TransaccionTaller("taller",costoTotal,propietario,propietario.getAuto(),articulo, mecanico,transfer).info()+"\n");
					System.out.print("La Factura le llegara a el correo: "+ propietario.getCorreo());
					mecanico.pagoSvcs+=mecanico.getManoObra();
					if(articulo.getEspecialidad().equals("Llantas")) {
						articulo.cantidad-=4;
						auto.setLlantas(articulo);
					}
					else {
						articulo.cantidad--;
					}
					System.out.print("");
				}
				else {
					System.out.print("Transaccion cancelada"+"\n");
					break;
				}
			}
		}
		}
	}
}
	public static void ventaRepuestos() {
		System.out.print("Bienvenido a nuestro portal de Ventas de Repuestos"+"\n");
		Articulo articulo=null;
		Cliente comprador = null;
		Vendedor vendedor = null;
		Auto auto = null;
		ArrayList<Articulo> repuesto=null;
		ArrayList<Articulo> marca=null;
		Scanner sc = new Scanner(System.in);
		String confirmarComp=null;
		while (comprador==null) {
			while(confirmarComp==null||confirmarComp.equals("no")) {
			System.out.println("Escriba la cédula del comprador: ");
			long cedula = sc.nextLong();
			//Devuelve un cliente que ya debe estar previamente registrado
			comprador = Cliente.getClientePorCedula(cedula);
			System.out.print(comprador.info());
		

			System.out.print("¿Confirmar cliente? (si/no)");
			confirmarComp = sc.nextLine();
			confirmarComp = sc.nextLine();
			}
		}if(!confirmarComp.equals("no")) {
			String confirmarTipo=null;
			while(confirmarTipo==null||confirmarTipo.equals("no")) {
			System.out.print("¿Que repuesto deseas Comprar?"+"\n");
	        System.out.println("1. Repuestos de Motor");
	        System.out.println("2. Escapes");
	        System.out.println("3. Sistema de Sonido");
	        System.out.println("4. Suspension");
	        System.out.print("Ingrese el número de la opción que va a utilizar: ");
	        //Se le pide que escoja un tipo de repuesto a comprar y devuelve una lista de articulos
			repuesto=InventarioArticulo.selectorEspecial();
			System.out.print("Usted Va a comprar un repuesto de: "+repuesto.get(0).getEspecialidad()+"\n");

				System.out.print("¿Confirmar Tipo de repuesto? (si/no)");
				confirmarTipo = sc.nextLine();
				
			}if(!confirmarTipo.equals("no")) {
				String confirmarMarca=null;
				while(confirmarMarca==null||confirmarMarca.equals("no")) {
				System.out.print("¿Que Marca de auto posee?"+"\n");
		        System.out.println("1. Toyota");
		        System.out.println("2. Mazda"); 
		        System.out.println("3. Chevrolet");
		        System.out.print("Ingrese el número de la opción que va a utilizar: ");
		        //Recibe la lista anterior y filtra por marcas de autos y devuelve un array de articulos filtrados
				marca=InventarioArticulo.selectorMarca(repuesto);
				System.out.print("Usted Va a comprar un repuesto de: "+marca.get(0).getMarcaVehiculo()+"\n");
					System.out.print("¿Confirmar Tipo de Vehiculo? (si/no)");
					confirmarMarca = sc.nextLine();
				}if(!confirmarMarca.equals("no")) {
					String confirmarCalidad=null;
					while(confirmarCalidad==null||confirmarCalidad.equals("no")) {
					System.out.print("¿Que calidad desea?"+"\n");
			        System.out.println("1. Premium");
			        System.out.println("2. Basico");
			        System.out.print("Ingrese el número de la opción que va a utilizar: ");
			        //Con la lista anterior se hace un refiltrado, por articulos premium o basico y devuelve una lista de articulos
					ArrayList<Articulo> articulos=InventarioArticulo.selectorCalidad(marca);

					//Selector de articulo despues de los filtros y devuelve un articulo.
					String resultp = String.format("%-40s%-25s%-20s%-15s%n", "   Producto", "   Tipo Vehiculo", "   Marca", "   Precio");
				 	    byte i=0;
				 	    for (Articulo articuloi:articulos) {
				 	    	i++;
			 	            String articuloinfo = String.format("%-40s%-25s%-20s%-15s%n", articuloi.getTipoArticulo(), articuloi.getTipoVehiculo(),articuloi.getMarca(),articuloi.getPrecio());
			 	            resultp += String.format("%-3d%s", i, articuloinfo );
				 	    }if (articulos.size() >= 1) {
				 	        System.out.println("Los productos " + articulos.get(0).getEspecialidad() + " disponibles son:\n");
				 	        System.out.println(resultp);
				 	        int num = 0;
				 	        while (num <= 0 || num > articulos.size()) {
				 	            System.out.println("Seleccione el numero del producto" + "[1-" + articulos.size() + "]: ");
				 	            if (sc.hasNextInt()) {
				 	                num = sc.nextInt();
				 	            } else {
				 	                System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + articulos.size() + ".");
				 	                sc.nextLine(); // Limpiar la entrada no válida
				 	            }
				 	        }
				 	        articulo = articulos.get(num - 1);

				 	    } else if (articulos.size() == 0) {
				 	        System.out.println("No hay productos disponibles para su vehiculo");
				 	    }
					System.out.print(articulo.getTipoArticulo()+" "+ articulo.getMarca()+"\n");

						System.out.print("¿Confirmar repuesto? (si/no)");
						confirmarCalidad = sc.nextLine();
					}if(!sc.nextLine().equals("no")) {	
					String confirmarVendedor=null;
					 while(confirmarVendedor==null||confirmarVendedor.equals("no")) {
						ArrayList<Vendedor> vendedores= Vendedor.selectorVend(articulo);
						String resultado = String.format("%-40s%-15s%n", "   Vendedor", "   Tipo de venta");
				 	    byte v=0;
				 	    for (Vendedor vend:vendedores) {
				 	    	v++;
			 	            String vendedorinfo = String.format("%-40s%-15s%n", vend.getNombre(), vend.getPuesto());
			 	            resultado += String.format("%-3d%s", v, vendedorinfo );
				 	    }if (vendedores.size() >= 1) {
				 	        System.out.println("Los vendedores de " + vendedores.get(0).getPuesto() + " disponibles son:\n");
				 	        System.out.println(resultado);
				 	        int num = 0;
				 	        while (num <= 0 || num > vendedores.size()) {
				 	            System.out.println("Seleccione el numero del vendedor" + "[1-" + vendedores.size() + "]: ");
				 	            if (sc.hasNextInt()) {
				 	                num = sc.nextInt();
				 	            } else {
				 	                System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + vendedores.size() + ".");
				 	                sc.nextLine(); // Limpiar la entrada no válida
				 	            }
				 	        }
				 	        vendedor = vendedores.get(num - 1);

				 	    } else if (vendedores.size() == 0) {
				 	        System.out.println("No hay vendedores disponibles para su vehiculo");
				 	    }
						System.out.print("¿Confirmar vendedor? (si/no)");
						confirmarVendedor = sc.nextLine();
						confirmarVendedor = sc.nextLine();
				 	   }if(!confirmarVendedor.equals("no")) {
				 		   String confirmarTrans=null;
							System.out.print("¿Confirmar Transaccion? (si/no)");
							confirmarTrans= sc.nextLine();
				 		   if(!confirmarTrans.equals("no")) {
				 	        vendedor.confirmarVenta();
							articulo.cantidad--;
							int transfer = (int) (Math.random() * 1000);
							System.out.println(new TransaccionVentaTaller("efectivo", articulo.getPrecio(), comprador, articulo, vendedor,transfer).info());
							System.out.print("La Factura le llegara a el correo: "+ comprador.getCorreo());
							System.out.print("");
				 	   }
				 		   else {
								System.out.print("Transaccion cancelada"+"\n");
				 		   }
				 	   }	  
					}
				}

			}
		}
	}
	
	public static void stats() {
		
		//objetos de prueba
//		Articulo llantas = Articulo.getArticuloPorReferencia(3001);
//		Articulo suspension = Articulo.getArticuloPorReferencia(3002);
//		Articulo sonido = Articulo.getArticuloPorReferencia(3003);
//		Articulo escape = Articulo.getArticuloPorReferencia(3004);
//		Cliente c1= new Cliente("Ana González", 12345678, 87654321, "Calle 5ta, #10-23", "Bogotá", "Toyota", 40000000);
//		Cliente c2= new Cliente("Juan Pérez", 102367459, 300987654, "Carrera 12, #34-56", "Medellín", "Toyota", 35000000);
//		Auto aa1= new Auto("Hilux", "Toyota", 1000, 2700, "verde fofo", true, true,llantas,suspension,sonido,escape);
//		Auto aa2= new Auto("Corolla", "Chevrolet", 2000, 2000, "negro", false, true,llantas,suspension,sonido,escape);
//		Auto aa3= new Auto("Hilux", "Toyota", 3000, 2700, "azul", true, true,llantas,suspension,sonido,escape);
//		Auto aa4= new Auto("Corolla", "Chevrolet", 4000, 2000, "rosa", false, true,llantas,suspension,sonido,escape);
//		Vendedor vendedorr1 = new Vendedor("Juan Guaido", 123456789, 5551234, "juan@ejemplo.com", "Av. Siempre Viva 123", 1000.0, "Banco Ejemplo", 987654321,"Vitrina");
//		Vendedor vendedorr2 = new Vendedor("Pedro Mojica", 987654321, 5554321, "pedro@ejemplo.com", 1500.0, "Banco Otro Ejemplo", 123456789,"Repuestos");
//		Transaccion trr1=new TransaccionVenta ("efectivo",1000,c1,aa1,vendedorr1,1);
//		Transaccion trr2=new TransaccionVenta ("efectivo",2000,c2,aa2,vendedorr1,2);
//		Transaccion trr3=new TransaccionVenta ("efectivo",3000,c1,aa3,vendedorr2,3);
//		Transaccion trr4=new TransaccionVenta ("efectivo",4000,c2,aa4,vendedorr2,4);
//		Mecanico mecanico1 = new Mecanico("Juan Pérez", 123456789, 987654321, "juan@example.com", "Calle Principal 123", 2000.0, "Banco A", 12345, "Toyota, Honda", "Mecánica General", 30);
//		Mecanico mecanico2 = new Mecanico("María Rodríguez", 234567890, 876543210, "maria@example.com", "Avenida Central 456", 1800.0, "Banco B", 9876, "Ford, Chevrolet", "Electricidad Automotriz", 25);
//		Mecanico mecanico3 = new Mecanico("Carlos Gómez", 345678901, 765432109, "carlos@example.com", "Calle Secundaria 789", 2200.0, "Banco C", 45678, "Nissan, Hyundai", "Transmisiones", 35);
//		Mecanico mecanico4 = new Mecanico("Laura López", 456789012, 654321098, "laura@example.com", "Avenida Principal 987", 1900.0, "Banco D", 345, "Volkswagen, BMW", "Frenos", 28);
//		Mecanico mecanico5 = new Mecanico("Pedro Ramírez", 567890123, 543210987, "pedro@example.com", "Calle Central 321", 2100.0, "Banco E", 23456, "Mercedes-Benz, Audi", "Suspensión", 32);
//		TransaccionTaller transaccion1 = new TransaccionTaller("Reparación", 1000, c1, aa1, llantas, mecanico1, 0);
//		TransaccionTaller transaccion2 = new TransaccionTaller("Mantenimiento", 500, c2, aa2, suspension, mecanico2, 1);
//		TransaccionTaller transaccion3 = new TransaccionTaller("Cambio de aceite", 200, c1, aa3, sonido, mecanico3, 0);
//		TransaccionTaller transaccion4 = new TransaccionTaller("Reemplazo de frenos", 800, c2, aa4, escape, mecanico4, 1);
//		TransaccionTaller transaccion5 = new TransaccionTaller("Inspección", 300, c1, aa2, llantas, mecanico5, 0);
		
		// info servicios
		Integer[] servicios = new Integer[6];
        servicios[0] = 2000000;
        servicios[1] = 1500000;
        servicios[2] = 2500000;
        servicios[3] = 1200000;
        servicios[4] = 1800000;
        servicios[5] = 1000000;
        
        String[] rubsvcs = new String[6];
        rubsvcs[0] = "Servicio de agua:";
        rubsvcs[1] = "Servicio de electricidad:";
        rubsvcs[2] = "Servicio de gas:";
        rubsvcs[3] = "Servicio de telefonía e internet:";
        rubsvcs[4] = "Servicio de seguridad:";
        rubsvcs[5] = "Servicio de limpieza:";
        
        // info gastos fijos
        String[] gastosfijos = new String[5];
        gastosfijos[0] = "Alquiler del local:";
        gastosfijos[1] = "Mantenimiento y reparaciones:";
        gastosfijos[2] = "Seguros:";
        gastosfijos[3] = "Publicidad y marketing:";
        gastosfijos[4] = "Costos financieros:";
        
        int[] valgf = new int[5];
        valgf[0] = 1500000;
        valgf[1] = 1000000;
        valgf[2] = 2000000;
        valgf[3] = 1200000;
        valgf[4] = 1300000;
        
		Scanner sc = new Scanner(System.in);
		byte opcion;
		
		LocalDate fecha = LocalDate.now();
		int dia = fecha.getDayOfMonth();
		String nombreMes = fecha.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
		
		System.out.println("¿Qué estadisticas / info financiera quiere consultar?");
		//static ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
		System.out.println("1. Ventas - Vendedor");
		System.out.println("2. Ventas - Autos");
		System.out.println("3. Estado de Resultados");
		System.out.println("4. Estado de Resultados Detallado");
		System.out.println("Selecciona: [1-4]");
		opcion = sc.nextByte();
		switch (opcion){
		case 1:
			
			ArrayList<TransaccionVenta> transaccionesActuales = TransaccionVenta.getTransaccionesven();
			
			ArrayList<Vendedor> vendedores1 = TransaccionVenta.vendedoresVentas(transaccionesActuales); //#1
			
			float num = ((float)vendedores1.size() / ((Vendedor.getVendedores().size()))) * 100;
			int roundedNum = Math.round(num);

			System.out.println("\n" + "-------- De los " + (Vendedor.getVendedores().size()) + " vendedores, " + vendedores1.size()+ " (el " + roundedNum + "%) han logrado ventas en el mes, son: --------");
			
			for (Vendedor vend: vendedores1)
			{
				System.out.println(vend.getNombre());
			}
			
			// para saber la cantidad total de dinero en ventas y # total de ventas:
			long sumaTotal=0;
			int contadorTotal=0;
			for (Transaccion transacc: TransaccionVenta.getTransaccionesven()) {
				sumaTotal = sumaTotal + transacc.getIngreso();
				contadorTotal+=1;}
			
			// para saber la cantidad total de dinero en ventas y # total de ventas:
			System.out.println("\n" + "-------- Suma de dinero en ventas por vendedor: --------");
			
			for (Vendedor vend: vendedores1)
			{
				int suma = 0;
				int contador=0;
				for (TransaccionVenta trans1: TransaccionVenta.getTransaccionesven())
				{
					if (vend.equals(trans1.getVendedor())){
						suma+=trans1.getIngreso();
						contador+=1;
					}
				}
				float num2 = ((float)suma / sumaTotal) * 100;
				int roundedSum = Math.round(num2);
				System.out.println(vend.getNombre() + ": " + suma + " $, el " + roundedSum + " % del total de ingresos por ventas de autos.");
			}
			
			System.out.println("\n" + "-------- # de ventas, y promedio de ingreso por venta de cada vendedor: --------");
			
			for (Vendedor vend: vendedores1)
			{
				int contador=0;
				int suma2 = 0;
				for (TransaccionVenta trans1: TransaccionVenta.getTransaccionesven())
				{
					if (vend.equals(trans1.getVendedor())){
						contador+=1;
						suma2+=trans1.getIngreso();
					}
				}
				int num3 = (suma2 / contador);
				float num4 = ((float)contador/contadorTotal)*100;
				int roundedNum4 = Math.round(num4);
				//int roundedNum3 = Math.round(num3);
				
				System.out.println(vend.getNombre() + ": " + contador + ", el " + roundedNum4 + "% del número total de ventas, promediando " + num3 + " $ por venta.");
			}
			
			float num5 = ((float)sumaTotal/dia);
			int roundedNum5 = Math.round(num5);
			System.out.println("\n" + "-------- Suma de ingresos total, y promedio de ingresos diarios en lo corrido del mes de " + nombreMes + ": --------");
			System.out.println("Suma total de ingresos: " + sumaTotal + ", promedio de ingresos diarios en lo corrido del mes de " + nombreMes + ": " + roundedNum5 + " $.");
			
			break;
			
		case 2:
			
			ArrayList<Auto> autosIniciales = TransaccionVenta.getAutosV();
			ArrayList<Auto> autosVendidosMarca = TransaccionVenta.AutosVendidos(autosIniciales); //#2
			
			float numA = ((float)autosIniciales.size() / (InventarioAuto.getAutos().size())) * 100;
			int roundedNumA = Math.round(numA);
			
			System.out.println("\n" + "-------- De los " + (InventarioAuto.getAutos().size()) + " autos que se tenían a comienzos del mes de " + nombreMes + ", " + autosIniciales.size()+ " (el " + roundedNumA + "%) se han vendido, son: --------");
			for (Auto a: autosIniciales){
				System.out.println(a.info());
			}

			//marcas carros vendidos
			ArrayList<String> marcasVentas = new ArrayList<>();
			for (Auto a: autosIniciales){
				if (marcasVentas.contains(a.getMarca())) {
				} else {
					marcasVentas.add(a.getMarca());
				}
			}
			
			//suma ($) y numero (#) total ventas
			long sumaTotal2=0;
			int contadorTotal2=0;
			for (Transaccion trans1: TransaccionVenta.getTransaccionesven())
				{
				//System.out.println(trans1.getIngreso());
				sumaTotal2+=trans1.getIngreso();
				contadorTotal2+=1;
				}
			
			//ventas por marca
			System.out.println("\n" + "-------- Ventas ($) por marca de auto --------");
			for (String m: marcasVentas) {
				long suma = 0;
				for (Auto a: autosIniciales) {
					if (m.equals(a.getMarca())) {
						suma+=a.getPrecio(); //cambiarlo por el ingreso de la transaccion(?)
					}
				}
				float numero1 = ((float)suma / sumaTotal2) * 100;
				int rednumero = Math.round(numero1);
				System.out.println(m + ": " + suma + ", " + rednumero + "% del total de ventas por concepto de venta de autos");
			}
			
			//# de ventas por marca
			System.out.println("\n" + "-------- Número de Ventas por marca de auto --------");
			for (String m: marcasVentas) {
				int cont=0;
				for (Auto b:autosIniciales) {
					if (m.equals(b.getMarca())) {
						cont+=1;
					}
				}
				float numero2 = ((float)cont / contadorTotal2) * 100;
				int rednumero2 = Math.round(numero2);
				System.out.println(m + ": " + cont + ", " + rednumero2 + "% del numero total de ventas por concepto de venta de autos");
			}
			
			float num6 = ((float)sumaTotal2/dia);
			int roundedNum6 = Math.round(num6);
			System.out.println("\n" + "-------- Suma de ingresos total, y promedio de ingresos diarios en lo corrido del mes de " + nombreMes + ": --------");
			System.out.println("Suma total de ingresos: " + sumaTotal2 + ", promedio de ingresos diarios en lo corrido del mes de " + nombreMes + ": " + roundedNum6 + " $.");
			
			break;
			
		case 3:
			System.out.println("Estado de reaultados desde el 1 hasta el " + dia + " de " + nombreMes + ":");
			
			String[] rubros = new String[4];
			rubros[0] = "+ Ventas Totales: ";
			rubros[1] = "- Costo de Ventas: ";
			rubros[2] = "- Gastos Operacionales y de Ventas: ";
			rubros[3] = "- Impuesto de Renta: ";
			
			
			String[] utilidades = new String[4];
			utilidades[0] = "UTILIDAD BRUTA";
			utilidades[1] = "UTILIDAD OPERATIVA";
			utilidades[2] = "UTILIDAD ANTES DE IMPUESTOS";
			utilidades[3] = "UTILIDAD NETA";
			
			long[] listaFinanzas = new long[4];
			listaFinanzas = Transaccion.estResults(listaFinanzas); // #3
			
			long res=0;
			for (int n = 0; n <= 3; n++) {
				if(n==0) {
					System.out.print("  "+rubros[n]);
					System.out.println(listaFinanzas[n]);
					System.out.print("  "+rubros[n+1]);
					System.out.println(listaFinanzas[n+1]);
					res=listaFinanzas[0]-listaFinanzas[1];
				}
				else if(n>1){
					System.out.println(utilidades[n-1]+": "+res);
					System.out.print("  "+rubros[n]);
					System.out.println(listaFinanzas[n]);
					res-=listaFinanzas[n];
					if (n==3) {
						System.out.println(utilidades[3]+": "+res);
					}
				}
			}
			
		break;
	
		case 4:

			System.out.println("Estado de reaultados desde el 1 hasta el " + dia + " de " + nombreMes + ":");
			long[] listaFinanzas2 = new long[4];
			String[] rubros2 = new String[4];
			rubros2[0] = "+ Ventas Totales: ";
			rubros2[1] = "- Costo de Ventas: ";
			rubros2[2] = "- Gastos Operacionales y de Ventas: ";
			rubros2[3] = "- Impuesto de Renta: ";

			String[] utilidades2 = new String[4];
			utilidades2[0] = "UTILIDAD BRUTA";
			utilidades2[1] = "UTILIDAD OPERATIVA";
			utilidades2[2] = "UTILIDAD ANTES DE IMPUESTOS";
			utilidades2[3] = "UTILIDAD NETA";

			listaFinanzas = Transaccion.estResults(listaFinanzas2);
			
			long res2=0;
			for (int n = 0; n <= 3; n++) {
				if(n==0) {
					System.out.print("  "+rubros2[n]);
					System.out.println(listaFinanzas[n]);
					System.out.println("      Autos vendidos:");
					for (Auto a:TransaccionVenta.getAutosV()) {
						System.out.println("        Auto de marca "+a.getMarca()+", modelo "+a.getModelo()+": "+a.getPrecio());
					}
					System.out.println("      Servicios taller:");
					for (TransaccionTaller t:TransaccionTaller.getTransaccionestal()) {
						System.out.println("        Mecánico(a) "+t.getMecanico().getNombre()+", con valor de: "+t.getIngreso());
					}
					System.out.println("      Venta de articulos taller:");
					for (TransaccionVentaTaller t:TransaccionVentaTaller.getTransaccionesven()) {
			        	System.out.println("        Venta de "+t.getArticulo().getMarca()+" con valor de: "+t.getIngreso());
					}
					System.out.print("  "+rubros2[n+1]);
					System.out.println(listaFinanzas[n+1]);
					
					System.out.println("      Pago a empleados:");
					System.out.println("        Vendedores:");
					for (Vendedor v:Vendedor.getVendedores()) {
						System.out.println("          "+v.getNombre()+", salario: "+v.getSalario());
					}
					System.out.println("        Mecanicos:");
					for (Mecanico m:Mecanico.getMecanicos()) {
						System.out.println("          "+m.getNombre()+", salario: "+m.getSalario());
					}
					res2=listaFinanzas[0]-listaFinanzas[1];
				
				}else if(n>1){
					System.out.println(utilidades2[n-1]+": "+res2);
					System.out.print("  "+rubros2[n]);
					System.out.println(listaFinanzas[n]);
					res2-=listaFinanzas[n];
					if (n==2) {
						System.out.println("      Comisiones:");
						for (TransaccionVenta t:TransaccionVenta.getTransaccionesven()) {
							System.out.println("        "+t.getVendedor().getNombre()+": "+(t.getIngreso())*0.02);
						}
						System.out.println("      Servicios:");
						for (int i=0;i<=5;i++) {
							System.out.println("        "+rubsvcs[i]+" "+servicios[i]);
						}
						System.out.println("      Gatos Fijos:");
						for (int e=0;e<=4;e++) {
							System.out.println("        "+gastosfijos[e]+" "+valgf[e]);
						}
					} else if (n==3) {
						System.out.println(utilidades2[3]+": "+res2);
					}
				}
			}
			
		break;
		}
	}
	
	public static byte readByte() {
	    Scanner scanner = new Scanner(System.in);
	    byte num = scanner.nextByte();
	    return num;
	    
	    
	}
	public static void personalizarAuto() {
	    Scanner sc = new Scanner(System.in);
	    Cliente propietario;
	    Auto auto;
	    
	    System.out.println("Bienvenido a nuestra sección de personalización de automóviles.");
	    
	    do {
	        System.out.print("Introduzca la cédula del propietario: ");
	        long cedula = sc.nextLong();
	        sc.nextLine();
	        
	        propietario = TransaccionVenta.getClientePorCedula(cedula);
	        auto = TransaccionVenta.getTransaccionporCedula(cedula);
	        
	        if (propietario == null || auto == null) {
	            System.out.println("La cédula ingresada no se encuentra en Transaccion. Por favor, vuelva a ingresarla.\n");
	        }
	    } while (propietario == null || auto == null);
	    
	    System.out.println(propietario.info());
	    
	    String confirmarPrp;
	    
	    do {
	        System.out.print("¿Confirmar propietario? (si/no): ");
	        confirmarPrp = sc.nextLine();
	        
	        if (confirmarPrp.equalsIgnoreCase("no")) {
	            System.out.print("Introduzca la cédula del propietario: ");
	            long cedula = sc.nextLong();
	            sc.nextLine();
	            
	            propietario = TransaccionVenta.getClientePorCedula(cedula);
	            auto = TransaccionVenta.getTransaccionporCedula(cedula);
	            
	            System.out.println(propietario.info());
	            
	            if (propietario == null || auto == null) {
	                System.out.println("La cédula ingresada no se encuentra en Transaccion. Por favor, vuelva a ingresarla.");
	            }
	        }
	    } while (confirmarPrp.equalsIgnoreCase("no"));
	    
	    System.out.print("\n¿Desea utilizar el taller con mecánicos o solo desea asignar un vendedor? (taller/vendedor): ");
	    String opcionTaller = sc.nextLine();
	    
	    int opcion = 0;
		if (opcionTaller.equalsIgnoreCase("taller")) {
	        ArrayList<Mecanico> mecanicos = Mecanico.mecanicoDisponible(auto);
	        
	        if (mecanicos.size() >= 1) {
	            System.out.println("\nLos mecánicos disponibles que atienden " + auto.getMarca() + " son:");
	            for (int i = 0; i < mecanicos.size(); i++) {
	                System.out.println((i + 1) + ". " + mecanicos.get(i).getNombre());
	            }
	            
	            int num;
	            
	            do {
	                System.out.print("Seleccione el número del mecánico [1-" + mecanicos.size() + "]: ");
	                num = sc.nextInt();
	                sc.nextLine();
	                
	                if (num < 1 || num > mecanicos.size()) {
	                    System.out.println("Opción inválida. Introduzca un número válido.");
	                }
	            } while (num < 1 || num > mecanicos.size());
	            
	            Mecanico mecanico = mecanicos.get(num - 1);
	            
	            ArrayList<Articulo> productos = InventarioArticulo.articuloDispo(mecanico);
	            
	            if (productos.size() >= 1) {
	                System.out.println("\nLos productos disponibles para " + mecanico.getNombre() + " son:");
	                for (int i = 0; i < productos.size(); i++) {
	                    System.out.println((i + 1) + ". " + productos.get(i).getTipoArticulo());
	                }
	                
	                int prodNum;
	                
	                do {
	                    System.out.print("Seleccione el número del producto [1-" + productos.size() + "]: ");
	                    prodNum = sc.nextInt();
	                    sc.nextLine();
	                    
	                    if (prodNum < 1 || prodNum > productos.size()) {
	                        System.out.println("Opción inválida. Introduzca un número válido.");
	                    }
	                } while (prodNum < 1 || prodNum > productos.size());
	                
	                Articulo producto = productos.get(prodNum - 1);
	                
	                System.out.println("\nHa seleccionado el siguiente procedimiento:");
	                
	                switch (opcion) {
	                    case 5:
	                        System.out.println("Modificación de pintura");
	                        break;
	                    case 6:
	                        System.out.println("Modificación de llantas");
	                        break;
	                    case 7:
	                        System.out.println("Modificación del sonido");
	                        break;
	                    case 8:
	                        System.out.println("Modificación de frenos");
	                        break;
	                    case 9:
	                        System.out.println("Modificación del escape");
	                        break;
	                }
	                
	                System.out.println("Mecánico seleccionado: " + mecanico.getNombre());
	                System.out.println("Producto seleccionado: " + producto.getTipoArticulo());
	                
	                System.out.print("\n¿Confirma el procedimiento, el mecánico y el producto? (si/no): ");
	                String confirmarTrans = sc.nextLine();
	    			if(confirmarTrans.equals("si")) {
	    				//selecciona la hora a la cual esta disponible el mecanico.
	    				System.out.print("Seleccione la hora para su servicio"+"\n");
	    				System.out.print("Esta es la agenda de: "+mecanico.getNombre()+"\n");
	    				 String resulth = String.format("%-20s%n", "   Horario disponible");
	    				    byte h=0;
	    				    for(String hora:mecanico.getHorario()) {
	    				    	h++;
	    			            String hor = String.format("%-20s%n", hora);
	    			            resulth += String.format("%-3d%s", h, hor);
	    				    }
	    				    if (mecanico.getHorario().size() >= 1) {
	    				        System.out.println("Las horas disponibles son:\n");
	    				        System.out.println(resulth);
	    				        int num1 = 0;
	    				        while (num1 <= 0 || num1 > mecanico.getHorario().size()) {
	    				            System.out.println("Seleccione la hora" + "[1-" + mecanico.getHorario().size() + "]: ");
	    				            if (sc.hasNextInt()) {
	    				                num1 = sc.nextInt();
	    				            } else {
	    				                 System.out.println("Entrada invalida. Introduzca un numero entre 1 y " + mecanicos.size() + ".");
	    				                sc.nextLine(); // Limpiar la entrada no válida
	    				            }
	    				        }
	    						System.out.print("La hora de su cita es"+ mecanico.getHorario().get(num1-1)+"\n");
	    				        mecanico.getHorario().remove(num1-1);
	    				    } else if (mecanicos.size() == 0) {
	    				        System.out.println("No hay hora disponible");
	    				    }
	    					long costoTotal=(long) (mecanico.getManoObra()+producto.getPrecio());
	    					System.out.print("El precio total por su Servicio es:"+costoTotal+"\n");
	    					//Reune todos los objetos y crea un objeto llamado transaccion.
	    					int transfer = (int) (Math.random() * 1000);
	    					System.out.print(new TransaccionModificacion("Personalizacion de auto",costoTotal,propietario,propietario.getAuto(), mecanico, producto, transfer).info()+"\n");
	    					mecanico.pagoSvcs+=mecanico.getManoObra();
	    					if(producto.getEspecialidad().equals("\"Modificacion de llantas\"")) {
	    						producto.cantidad-=4;
	    						auto.setLlantas(producto);
	    					}
	    					else {
	    						producto.cantidad--;
	    					}
	    					System.out.print("");
	    				}
	    				else {
	    					System.out.print("Transaccion cancelada"+"\n");
	    					
	    				}
	    			}
	    		}
	    }/* else if (opcionTaller.equalsIgnoreCase("vendedor")) {
	        ArrayList<Vendedor> vendedores = Vendedor.selectorVend(auto);
	        
	        if (vendedores.size() >= 1) {
	            System.out.println("\nLos vendedores disponibles son:");
	            for (int i = 0; i < vendedores.size(); i++) {
	                System.out.println((i + 1) + ". " + vendedores.get(i).getNombre());
	            }
	            
	            
	            
	            
	            
	        }
	    }*/
	}  

		 	  
	public static void crearUsuario() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Bienvenido al portal de creación de usuarios de nuestro concesionario"+"\n");
		System.out.print("Introduzca su Nombre y Apellido"+"\n");
		String usuario=sc.nextLine();
		System.out.print("Introduzca su Cedula"+"\n");
		long cedula=sc.nextLong();
		if(Cliente.getClientePorCedula(cedula)!=null) {
			System.out.print("Señor "+ usuario + " Usted ya se encuentra registrado en nuestro concesionario"+"\n");
		}
		else {
		System.out.print("Introduzca su Telefono"+"\n");
		long telefono=sc.nextLong();
		System.out.print("Introduzca su Correo"+"\n");
		String correo=sc.nextLine();
		correo=sc.nextLine();  
		System.out.print("Introduzca su Direccion"+"\n");
		String direccion=sc.nextLine();
		System.out.print("Introduzca su Marca de interes"+"\n");
		String modelo=sc.nextLine();
		System.out.print("Introduzca su presupuesto"+"\n");
		long presupuesto=sc.nextLong();
		new Cliente(usuario,cedula,telefono,correo,direccion,modelo,presupuesto);
		
		System.out.print("Señor "+usuario + " Usted En este momento se encuentra registrado en nuestro concesionario"+"\n");
		}
}
	public static void administracion() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Bienvenido al portal de administración de nuestro concesionario"+"\n");
		System.out.print("Introduzca su cedula"+"\n"); //3355479
		long cedula=sc.nextLong();
		Vendedor admin=Vendedor.getVendedorPorCedula(cedula);
		if(admin!=null&&admin.getPuesto().equals("admin")) {
			byte input;
			do {
				System.out.print("¿Que labor administrativa desea hacer?"+"\n");
				System.out.print("1. ¿Asignar Horarios a mecanicos?"+"\n");
				System.out.print("2. Añadir articulo (Nuevo)"+"\n");
				System.out.println("3. Añadir Auto (Nuevo)");
				System.out.println("4. Añadir Vendedor (Nuevo)");
				System.out.println("5. Añadir Mecánico (Nuevo)");
				System.out.print("6. Salir del Portal administrativo"+"\n");
				input = sc.nextByte();
				switch(input) {
				case 1:
					System.out.print("¿Introduzca la cedula del mecanico?"+"\n");
					long cedulamecanico=sc.nextLong();
					Mecanico mech=Mecanico.getMecanicoPorCedula(cedulamecanico);
					mech.setHorario(new ArrayList<String>() {{add("9:00-11:00");add("11:00-1:00");add("2:00-4:00");add("4:00-6:00");}});
					System.out.print("Horario Reasignado a "+mech.getNombre()+"\n");
					input=8;
					break;
				case 2:
					System.out.print("Nombre del articulo"+"\n");
					String nombre=sc.nextLine();
					nombre=sc.nextLine();
					System.out.print("Referencia del articulo"+"\n");
					long referencia=sc.nextLong();
					if(Articulo.getArticuloPorReferencia(referencia)!=null) {
						System.out.print("El articulo ya se encuentra registrado en nuestro concesionario"+"\n");
						System.out.print("Presione enter para retornar al menu administrativo"+"\n");
						sc.nextLine();
						sc.nextLine();
					}
					else if(Articulo.getRepuestoPorReferencia(referencia)!=null) {
						System.out.print("El articulo ya se encuentra registrado en nuestro concesionario"+"\n");
						System.out.print("Presione enter para retornar al menu administrativo"+"\n");
						sc.nextLine();
						sc.nextLine();
					}
					
					else {
					System.out.print("Calidad del articulo (premium/basico)"+"\n");
					String calidad=sc.nextLine();
					calidad=sc.nextLine();
					System.out.print("Tipo del articulo (repuesto/taller)"+"\n");
					String tipo=sc.nextLine();
					System.out.print("Especialidad (Llantas/Pintura/Motor/Frenos/Modificacion)"+"\n");
					String especialidad=sc.nextLine();
					System.out.print("Tipo del Vehiculo"+"\n");
					String tipoVehi=sc.nextLine();
					System.out.print("Marca del articulo"+"\n");
					String marca=sc.nextLine();
					System.out.print("precio del articulo"+"\n");
					long precio=sc.nextLong();
					System.out.print("Numero de unidades"+"\n");
					int cantidad=sc.nextInt();
					System.out.print("¿Es para una Marca especial? (si/no)"+"\n");
					sc.nextLine();
					if(sc.nextLine().equals("si")) {
						System.out.print("¿Cual? (Mazda/Toyota/Chevrolet)"+"\n");
						String marcaVehiculo=sc.nextLine();
						new Articulo(calidad,tipo,especialidad,nombre,tipoVehi,marca,precio,cantidad,marcaVehiculo,referencia);
					}
					else {
							System.out.print("El articulo es Generico"+"\n");
						new Articulo(calidad,tipo,especialidad,nombre,tipoVehi,marca,precio,cantidad,referencia);
					}
					System.out.print("Articulo creado con exito"+"\n");
				}
					break;
				case 3: //3355479
					System.out.println("Modelo del carro: ");
					String modelo = sc.nextLine();
					modelo=sc.nextLine();
					System.out.println("Marca del carro: ");
					String marca = sc.nextLine();
					System.out.println("Precio del carro: ");
					Long precio=sc.nextLong();
					System.out.println("Cilindraje del carro: ");
					int cilindraje = sc.nextInt();
					System.out.println("Color del carro: ");
					String color = sc.nextLine();
					color=sc.nextLine();
					System.out.println("El carro es Full Equipo? (si/no): ");
					String fq = sc.nextLine();
					Articulo llantas = Articulo.getArticuloPorReferencia(3001);
					Articulo suspension = Articulo.getArticuloPorReferencia(3002);
					Articulo sonido = Articulo.getArticuloPorReferencia(3003);
					Articulo escape = Articulo.getArticuloPorReferencia(3004);
					
					if (fq.equals("si")) {
						new Auto(modelo, marca, precio, cilindraje, color, true, true, llantas, suspension, sonido, escape);
						System.out.println("El carro " + marca + ", modelo " + modelo + ", FullEquipo se ha añadido con éxito"+"\n");
					} else {
						new Auto(modelo, marca, precio, cilindraje, color, false, true, llantas, suspension, sonido, escape);
						System.out.println("El carro " + marca + ", modelo " + modelo + ", no FullEqipo se ha añadido con éxito"+"\n");
					}
					break;
				case 4:
					System.out.println("Nombre del vendedor: ");
					String nombreVendedor = sc.nextLine();
					nombreVendedor = sc.nextLine();
					System.out.println("Cédula del vendedor: ");
					long cedulaVendedor = sc.nextLong();
					if (Vendedor.getVendedorPorCedula(cedulaVendedor)!=null) {
						System.out.println("Este usuario ya se encuentra registrado en el concesionario.");
					} else {
						System.out.println("Teléfono del vendedor: ");
						long telefonoVendedor = sc.nextLong();
						System.out.println("Correo del vendedor: ");
						String correoVendedor = sc.nextLine();
						correoVendedor = sc.nextLine();
						System.out.println("Dirección del vendedor: ");
						String direccionVendedor = sc.nextLine();
						System.out.println("Salario del vendedor: ");
						double salarioVendedor = sc.nextDouble();
						System.out.println("Banco del vendedor: ");
						String bancoVendedor = sc.nextLine();
						bancoVendedor = sc.nextLine();
						System.out.println("Numero de cuenta de banco del vendedor: ");
						long cuentaBancoVendedor = sc.nextLong();
						System.out.println("Puesto del vendedor(admin,Vitrina,Repuestos): ");
						String puestoVendedor = sc.nextLine();
						puestoVendedor = sc.nextLine();
						
						if (direccionVendedor == "") {
							new Vendedor(nombreVendedor, cedulaVendedor, telefonoVendedor, correoVendedor, "Medellin", salarioVendedor, bancoVendedor, cuentaBancoVendedor, puestoVendedor);
							System.out.println("El vendedor " + nombreVendedor + " con Cédula " + cedulaVendedor + ", ha sido añadido con éxito.");
						} else {
							new Vendedor(nombreVendedor, cedulaVendedor, telefonoVendedor, correoVendedor, direccionVendedor, salarioVendedor, bancoVendedor, cuentaBancoVendedor, puestoVendedor);
							System.out.println("El vendedor " + nombreVendedor + " con Cédula " + cedulaVendedor + ", ha sido añadido con éxito.");
						}
						}
					break;

				case 5:
					System.out.println("Nombre del mecánico: ");
					String nombreMecanico = sc.nextLine();
					System.out.println("Cédula del mecánico: ");
					long cedulaMecanico = sc.nextLong();
					if (Mecanico.getMecanicoPorCedula(cedulaMecanico)!=null) {
						System.out.println("Este usuario ya se encuentra registrado en el concesionario.");
					} else {
						System.out.println("Teléfono del mecánico: ");
						long telefonoMecanico = sc.nextLong();
						System.out.println("Correo del mecánico: ");
						String correoMecanico = sc.nextLine();
						System.out.println("Dirección del mecánico: ");
						String direccionMecanico = sc.nextLine();
						System.out.println("Salario del mecánico: ");
						double salarioMecanico = sc.nextDouble();
						System.out.println("Banco del mecánico: ");
						String bancoMecanico = sc.nextLine();
						System.out.println("Número de cuenta de banco del mecánico: ");
						long cuentaBancoMecanico = sc.nextLong();
						System.out.println("Marca de carros que atiende el mecánico: ");
						String autosMecanico = sc.nextLine();
						System.out.println("Especialidad del mecánico: ");
						String especialidadMecanico = sc.nextLine();
						System.out.println("Valor de mano de obra del mecánico: ");
						long manoObraMecanico =sc.nextLong();
						
						new Mecanico(nombreMecanico, cedulaMecanico, telefonoMecanico, correoMecanico, direccionMecanico, salarioMecanico, bancoMecanico, cuentaBancoMecanico, autosMecanico, especialidadMecanico, manoObraMecanico);
						System.out.println("El mecánico " + nombreMecanico + " con Cédula " + cedulaMecanico + ", ha sido añadido con éxito.");
						}
					}
				break;

				
					
			}while(input!=6);
		}
		else if(admin==null) {
			System.out.print("Usted no tiene acceso a este portal,sera redirigido al menu inicial."+"\n");
		}
	}
	


}
