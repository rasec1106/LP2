package dao;



import interfaces.ProductoDAO;

public abstract class DAOFactory {
	
   // Posibles orígenes de datos
   public static final int MYSQL = 1;  
   public static final int ORACLE = 2;
   public static final int SQLSERVER = 3;
   public static final int INFORMIX = 4;
   public static final int DB2 = 5;

   // Trae tantas interfaces como tengas
   public abstract ProductoDAO getProducto();

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