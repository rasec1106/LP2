package dao;

import interfaces.UniversidadDAO;
import interfaces.EspecialidadDAO;
import interfaces.IngenieroDAO;

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

}
