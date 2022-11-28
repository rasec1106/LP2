package beans;

public class IngenieroDTO {
	private int codigo;
	private String nombre;
	private String apellido;
	private String dni;
	private double sueldo;
	private int codUniversidad;
	private String nomUniversidad;
	private int codEspecialidad;
	private String nomEspecialidad;
	
	public IngenieroDTO() {
		super();
	}

	public IngenieroDTO(int codigo, String nombre, String apellido, String dni, double sueldo, int codUniversidad,
			String nomUniversidad, int codEspecialidad, String nomEspecialidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sueldo = sueldo;
		this.codUniversidad = codUniversidad;
		this.nomUniversidad = nomUniversidad;
		this.codEspecialidad = codEspecialidad;
		this.nomEspecialidad = nomEspecialidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getCodUniversidad() {
		return codUniversidad;
	}

	public void setCodUniversidad(int codUniversidad) {
		this.codUniversidad = codUniversidad;
	}

	public String getNomUniversidad() {
		return nomUniversidad;
	}

	public void setNomUniversidad(String nomUniversidad) {
		this.nomUniversidad = nomUniversidad;
	}

	public int getCodEspecialidad() {
		return codEspecialidad;
	}

	public void setCodEspecialidad(int codEspecialidad) {
		this.codEspecialidad = codEspecialidad;
	}

	public String getNomEspecialidad() {
		return nomEspecialidad;
	}

	public void setNomEspecialidad(String nomEspecialidad) {
		this.nomEspecialidad = nomEspecialidad;
	}	
	
}
