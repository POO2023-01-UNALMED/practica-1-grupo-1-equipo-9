package gestorAplicacion.personal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.activos.*;

public class Mecanico extends Trabajador implements Serializable{
	private static final long serialVersionUID = 1L;
	static ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();
	String autos;
	String especialidad;
	public long pagoSvcs=0;
	long manoObra;
	ArrayList<String> horario=new ArrayList<String>() {{add("9:00-11:00");add("11:00-1:00");add("2:00-4:00");add("4:00-6:00");}};

	public Mecanico(String nombre, long cedula, long telefono, String correo, String direccion, double salario,
			String banco, long cuentaBanco, String autos,String especialidad,long manoObra) {
		super(nombre, cedula, telefono, correo, direccion, salario, banco, cuentaBanco);
		this.autos = autos;
		this.manoObra=manoObra;
		this.especialidad=especialidad;
		Mecanico.mecanicos.add(this);
	}
    public ArrayList<String> getHorario() {
        return horario;
    }

    public void setHorario(ArrayList<String> horario) {
        this.horario = horario;
    }
    public long  getManoObra() {
        return manoObra;
    }

    public void setManoObra(long manoObra) {
        this.manoObra = manoObra;
    }

	public String getAutos() {
		return autos;
	}

	public void setAutos(String autos) {
		this.autos = autos;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad=especialidad;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	
	public static ArrayList<Mecanico> getMecanicos() {
		return mecanicos;
	}
	
	public static void setMecanicos(ArrayList<Mecanico> mecanicos) {
		Mecanico.mecanicos = mecanicos;
	}
	public static ArrayList<Mecanico> mecanicoDisponible(Auto auto) {
	    Scanner sc = new Scanner(System.in);
	    byte input;
	    String salir = null;
	    String especialidad=null;
	    ArrayList<Mecanico> mechs = new ArrayList<Mecanico>();
	    
	    do {

	        input = sc.nextByte();

	        switch (input) {
	        case 1:
                especialidad="Pintura";
        	    for (Mecanico mecanico : getMecanicos()) {
        	        if (especialidad.equals(mecanico.getEspecialidad())&& auto.getMarca().equals(mecanico.getAutos())&&mecanico.getHorario().size()>=1) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
            case 2:
                especialidad="Llantas";
        	    for (Mecanico mecanico : getMecanicos()) {
        	    	if (especialidad.equals(mecanico.getEspecialidad())&& auto.getMarca().equals(mecanico.getAutos())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
            case 3:
                especialidad="Motor";
        	    for (Mecanico mecanico : getMecanicos()) {
        	    	if (especialidad.equals(mecanico.getEspecialidad())&& auto.getMarca().equals(mecanico.getAutos())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
            case 4:
                especialidad="Frenos";
        	    for (Mecanico mecanico : getMecanicos()) {
        	    	if (especialidad.equals(mecanico.getEspecialidad())&& auto.getMarca().equals(mecanico.getAutos())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
            case 5:
                especialidad="ModificacionPintura";
        	    for (Mecanico mecanico : getMecanicos()) {
        	    	if (especialidad.equals(mecanico.getEspecialidad())&& auto.getMarca().equals(mecanico.getAutos())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
                
            case 6:
                especialidad="ModificacionLlantas";
        	    for (Mecanico mecanico : getMecanicos()) {
        	    	if (especialidad.equals(mecanico.getEspecialidad())&& auto.getMarca().equals(mecanico.getAutos())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
                
            case 7:
                especialidad="ModificacionSonido";
        	    for (Mecanico mecanico : getMecanicos()) {
        	    	if (especialidad.equals(mecanico.getEspecialidad())&& auto.getMarca().equals(mecanico.getAutos())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
                
            case 8:
                especialidad="ModificacionFrenos";
        	    for (Mecanico mecanico : getMecanicos()) {
        	    	if (especialidad.equals(mecanico.getEspecialidad())&& auto.getMarca().equals(mecanico.getAutos())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
                
            case 9:
                especialidad="ModificacionEscape";
        	    for (Mecanico mecanico : getMecanicos()) {
        	    	if (especialidad.equals(mecanico.getEspecialidad())&& auto.getMarca().equals(mecanico.getAutos())) {
        	            mechs.add(mecanico);
        	        }
        	        salir="si";
        	    }
                break;
			default:
				System.out.print("\n¿Salir? (si/no)");
				salir = sc.nextLine();
			} 
	    } while(salir.equals(null));
	    return mechs;
	}
	public static Mecanico getMecanicoPorCedula(long cedula){
		Mecanico finder = null;
		for(Mecanico mecanico: mecanicos) {
			if(mecanico.getCedula()==cedula) {
				finder = mecanico;
			} 
		
		}return finder;
	}
	public static byte readByte() {
	    Scanner scanner = new Scanner(System.in);
	    byte num = scanner.nextByte();
	    return num;
	}
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public long getCedula() {
		// TODO Auto-generated method stub
		return cedula;
	}

	@Override
	public long getTelefono() {
		// TODO Auto-generated method stub
		return telefono;
	}

	@Override
	public String getCorreo() {
		// TODO Auto-generated method stub
		return correo;
	}

	@Override
	public String getDireccion() {
		// TODO Auto-generated method stub
		return direccion;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	@Override
	public void setCedula(long cedula) {
		this.cedula=cedula;
	}

	@Override
	public void setTelefono(long telefono) {
		this.telefono=telefono;
	}

	@Override
	public void setCorreo(String correo) {
		this.correo=correo;
	}

	@Override
	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}

	@Override
	int calcularSalario() {
		return (int) (pagoSvcs+getSalario());
	}
	@Override
	public String info() {
		String texto = "Nombre del Mecanico: " + getNombre() + "\n";
		return texto;
	}
	
}
