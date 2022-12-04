package beans;

public class SolicitudDTO {
	private int id;
	private String codigo;
	private String motivo;;
	private String fecha;
	private int idAlmacen;
	private int idUsuario;
	private int idEstado;
	
	public SolicitudDTO() {
		super();
	}

	public SolicitudDTO(int id, String codigo, String motivo, String fecha, int idAlmacen, int idUsuario,
			int idEstado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.motivo = motivo;
		this.fecha = fecha;
		this.idAlmacen = idAlmacen;
		this.idUsuario = idUsuario;
		this.idEstado = idEstado;
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

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	
}
