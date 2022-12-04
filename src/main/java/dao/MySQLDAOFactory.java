package dao;

import interfaces.UniversidadDAO;
import interfaces.UsuarioDAO;
import interfaces.AlmacenDAO;
import interfaces.EspecialidadDAO;
import interfaces.EstadoDAO;
import interfaces.IngenieroDAO;
import interfaces.ProductoDAO;
import interfaces.SolicitudDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public IngenieroDAO getIngeniero() {
		return new MySQLIngenieroDAO();
	}

	@Override
	public UniversidadDAO getUniversidad() {
		return new MySQLUniversidadDAO();
	}

	@Override
	public EspecialidadDAO getEspecialidad() {
		return new MySQLEspecialidadDAO();
	}

	@Override
	public AlmacenDAO getAlmacen() {
		return new MySQLAlmacenDAO();
	}

	@Override
	public EstadoDAO getEstado() {
		return new MySQLEstadoDAO();
	}

	@Override
	public ProductoDAO getProducto() {
		return new MySQLProductoDAO();
	}

	@Override
	public SolicitudDAO getSolicitud() {
		return new MySQLSolicitudDAO();
	}

	@Override
	public UsuarioDAO getUsuario() {
		return new MySQLUsuarioDAO();
	}

}
