package dao;

import interfaces.UniversidadDAO;
import interfaces.UsuarioDAO;
import interfaces.AlmacenDAO;
import interfaces.EspecialidadDAO;
import interfaces.EstadoDAO;
import interfaces.IngenieroDAO;
import interfaces.ProductoDAO;
import interfaces.SolicitudDAO;

public abstract class DAOFactory {
	
   public static final int MYSQL = 1;  
   public static final int ORACLE = 2;
   public static final int SQLSERVER = 3;
   public static final int INFORMIX = 4;
   public static final int DB2 = 5;

   public abstract IngenieroDAO getIngeniero();
   public abstract UniversidadDAO getUniversidad();
   public abstract EspecialidadDAO getEspecialidad();
   public abstract AlmacenDAO getAlmacen();
   public abstract EstadoDAO getEstado();
   public abstract ProductoDAO getProducto();
   public abstract SolicitudDAO getSolicitud();
   public abstract UsuarioDAO getUsuario();

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