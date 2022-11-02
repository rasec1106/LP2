package beans;

public class PaisDTO {
	
	private int codigo;
	private String nombre;
	private String continente;	
	
	public PaisDTO() {
		super();
	}
	public PaisDTO(int codigo, String nombre, String continente) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.continente = continente;
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
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	
}
