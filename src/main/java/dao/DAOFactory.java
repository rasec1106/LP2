package dao;

import interfaces.UniversidadDAO;
import interfaces.EspecialidadDAO;
import interfaces.IngenieroDAO;

public abstract class DAOFactory {
	
   public static final int MYSQL = 1;  
   public static final int ORACLE = 2;
   public static final int SQLSERVER = 3;
   public static final int INFORMIX = 4;
   public static final int DB2 = 5;

   public abstract IngenieroDAO getIngeniero();
   public abstract UniversidadDAO getUniversidad();
   public abstract EspecialidadDAO getEspecialidad();

   public static DAOFactory getDAOFactory(int whichFactory) {
      switch(whichFactory) {
         case MYSQL:
            return new MySQLDAOFactory();
         case ORACLE:
            //return new OracleDAOFactory();
         case SQLSERVER:
            //return new SQLServerDAOFactory();
      }
      return null;
   }
}