package MisServlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import beans.SolicitudDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SolicitudService;

/**
 * Servlet implementation class ServletSolicitud
 */
@WebServlet("/ServletSolicitud")
public class ServletSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SolicitudService serviSolicitud = new SolicitudService();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSolicitud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String xtipo = request.getParameter("tipo");
	      if (xtipo.equals("listar")) {
	          listar(request, response);
	       }
	       else if (xtipo.equals("buscar")) {
	          buscar(request, response);
	       }
	       else if (xtipo.equals("registrar")) {
	          registrar(request, response);
	       }
	       else if (xtipo.equals("actualizar")) {
	          actualizar(request, response);
	       }
	       else if (xtipo.equals("eliminar")) {
	          eliminar(request, response);
	       }
	}

   private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setAttribute("data", serviSolicitud.listaSolicitud());
      request.getRequestDispatcher("listarSolicitud.jsp").forward(request, response);
   }
   
   private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {		   
		   int solicitante, usuario, almacen, estado;
	      	String codigo, motivo, fecha;
	      	codigo = request.getParameter("txt_cod");
	      	motivo = request.getParameter("txt_mot");
	      	fecha = request.getParameter("txt_fec");
	      	solicitante = Integer.parseInt(request.getParameter("id_sol"));
	      	usuario = Integer.parseInt(request.getParameter("cbo_usr"));
	      	almacen = Integer.parseInt(request.getParameter("cbo_alm"));
	      	estado = Integer.parseInt(request.getParameter("cbo_est"));
	      	SolicitudDTO obj = new SolicitudDTO();
	        obj.setCodigo(codigo);
	        obj.setIdSolicitante(solicitante);
	        obj.setMotivo(motivo);
	        obj.setFecha(fecha);
	        obj.setIdAlmacen(almacen);
	        obj.setIdUsuario(usuario);
	        obj.setIdEstado(estado);
	        serviSolicitud.actualizaSolicitud(obj);
	        request.setAttribute("message", "Se actualizo correctamente el registro");
	        listar(request, response);
	   	}catch (Exception e) {
	   		request.setAttribute("message", "No se pudo actualizar el registro. "+e.getMessage());
	   		listar(request, response);		
	   	}
   }
   
   private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {		   
		   	int solicitante, usuario, almacen, estado;
	      	String codigo, motivo, fecha;
	      	codigo = request.getParameter("txt_cod");
	      	motivo = request.getParameter("txt_mot");
	      	fecha = request.getParameter("txt_fec");
	      	solicitante = Integer.parseInt(request.getParameter("id_sol"));
	      	usuario = Integer.parseInt(request.getParameter("cbo_usr"));
	      	almacen = Integer.parseInt(request.getParameter("cbo_alm"));
	      	estado = Integer.parseInt(request.getParameter("cbo_est"));
	      	SolicitudDTO obj = new SolicitudDTO();
	        obj.setCodigo(codigo);
	        obj.setIdSolicitante(solicitante);
	        obj.setMotivo(motivo);
	        obj.setFecha(fecha);
	        obj.setIdAlmacen(almacen);
	        obj.setIdUsuario(usuario);
	        obj.setIdEstado(estado);
	      	serviSolicitud.registraSolicitud(obj);
	      	request.setAttribute("message", "Se creo correctamente el registro");
	      	listar(request, response);
	   }catch (Exception e) {
		   	request.setAttribute("message", "No se pudo crear el registro. "+e.getMessage());
		   	listar(request, response);		
	   }
   }

   private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int cod = Integer.parseInt(request.getParameter("cod"));
      request.setAttribute("Solicitud", serviSolicitud.buscaSolicitud(cod));
      request.getRequestDispatcher("actualizarSolicitud.jsp").forward(request, response);
   }
   
   private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {
		   int cod = Integer.parseInt(request.getParameter("cod"));
		   serviSolicitud.eliminaSolicitud(cod);
		   request.setAttribute("message", "Se elimino correctamente el registro");
		   listar(request, response);
	   }catch (Exception e) {
		   request.setAttribute("message", "No se pudo eliminar el registro. "+e.getMessage());
		   listar(request, response);
	   }
      
   }
}
