package dao;

import interfaces.MarcaDAO;
import interfaces.PaisDAO;
import interfaces.EquipoDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public EquipoDAO getEquipo() {
		return new MySQLEquipoDAO();
	}

	@Override
	public MarcaDAO getMarca() {
		return new MySQLMarcaDAO();
	}

	@Override
	public PaisDAO getPais() {
		return new MySQLPaisDAO();
	}

}
