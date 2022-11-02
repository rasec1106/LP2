package dao;

import interfaces.ProductoDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public ProductoDAO getProducto() {
		return new MySQLProductoDAO();
	}

}
