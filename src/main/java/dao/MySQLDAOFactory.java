package dao;

import interfaces.UsuarioDAO;
import interfaces.AlmacenDAO;
import interfaces.EstadoDAO;
import interfaces.ProductoDAO;
import interfaces.SolicitudDAO;

public class MySQLDAOFactory extends DAOFactory {


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
