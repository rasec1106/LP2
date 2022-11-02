package dao;

import interfaces.MarcaDAO;
import interfaces.PaisDAO;
import interfaces.EquipoDAO;

public abstract class DAOFactory {
	
   public static final int MYSQL = 1;  
   public static final int ORACLE = 2;
   public static final int SQLSERVER = 3;
   public static final int INFORMIX = 4;
   public static final int DB2 = 5;

   public abstract EquipoDAO getEquipo();
   public abstract MarcaDAO getMarca();
   public abstract PaisDAO getPais();

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