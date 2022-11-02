package beans;

public class MarcaDTO {
	
	private int codigo;
	private String nombre;
	private String categoria;
	
	public MarcaDTO() {
		super();
	}
	public MarcaDTO(int codigo, String nombre, String categoria) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoria = categoria;
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
