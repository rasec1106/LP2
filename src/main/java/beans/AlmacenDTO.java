package beans;

import java.util.ArrayList;

public class AlmacenDTO {
	private int id;
	private String codigo;
	private String direccion;;
	private String telefono;
	private double metrosCuadrados;
	private ArrayList<ProductoDTO> productos;
	
	public AlmacenDTO() {
		super();
	}
	
	public AlmacenDTO(int id, String codigo, String direccion, String telefono, double metrosCuadrados,
			ArrayList<ProductoDTO> productos) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.metrosCuadrados = metrosCuadrados;
		this.productos = productos;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public double getMetrosCuadrados() {
		return metrosCuadrados;
	}
	
	public void setMetrosCuadrados(double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public ArrayList<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoDTO> productos) {
		this.productos = productos;
	}

}
