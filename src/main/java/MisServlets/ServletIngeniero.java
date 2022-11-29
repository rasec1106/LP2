package MisServlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import beans.IngenieroDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EspecialidadService;
import service.IngenieroService;

/**
 * Servlet implementation class ServletIngeniero
 */
@WebServlet("/ServletIngeniero")
public class ServletIngeniero extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IngenieroService serviIngeniero = new IngenieroService();
    EspecialidadService serviEspecialidad = new EspecialidadService();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIngeniero() {
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
      request.setAttribute("data", serviIngeniero.listaIngeniero());
      // Mandamos la especialidad de Ing. De Sistemas que posee el codigo 1
      request.setAttribute("especialidad", serviEspecialidad.buscaEspecialidad(1));
      request.getRequestDispatcher("consulta-Herrera.jsp").forward(request, response);
   }
   
   private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {		   
	      int cod, uni, esp;
	      String nom, ape, dni;
	      double sue;
	      cod = Integer.parseInt(request.getParameter("txt_cod"));
	      nom = request.getParameter("txt_nom");
	      ape = request.getParameter("txt_ape");
	      dni = request.getParameter("txt_dni");
	      sue = Double.parseDouble(request.getParameter("txt_sue"));
	      uni = Integer.parseInt(request.getParameter("cbo_uni"));
	      esp = Integer.parseInt(request.getParameter("cbo_esp"));
	      IngenieroDTO obj = new IngenieroDTO();
	      obj.setCodigo(cod);
	      obj.setNombre(nom);
	      obj.setApellido(ape);
	      obj.setDni(dni);
	      obj.setSueldo(sue);
	      obj.setCodUniversidad(uni);
	      obj.setCodEspecialidad(esp);
	      serviIngeniero.actualizaIngeniero(obj);
	      request.setAttribute("message", "Se actualizo correctamente el registro");
	      listar(request, response);
	   }catch (Exception e) {
		   request.setAttribute("message", "No se pudo actualizar el registro. "+e.getMessage());
		   listar(request, response);		
	   }
   }
   
   private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {		   
		   	int uni, esp;
	      	String nom, ape, dni;
	      	double sue;
	      	nom = request.getParameter("txt_nom");
	      	ape = request.getParameter("txt_ape");
	      	dni = request.getParameter("txt_dni");
	      	sue = Double.parseDouble(request.getParameter("txt_sue"));
	      	uni = Integer.parseInt(request.getParameter("cbo_uni"));
	      	esp = Integer.parseInt(request.getParameter("cbo_esp"));
	      	IngenieroDTO obj = new IngenieroDTO();
	      	obj.setNombre(nom);
	      	obj.setApellido(ape);
	      	obj.setDni(dni);
	      	obj.setSueldo(sue);
	      	obj.setCodUniversidad(uni);
	      	obj.setCodEspecialidad(esp);
	      	serviIngeniero.registraIngeniero(obj);
	      	request.setAttribute("message", "Se creo correctamente el registro");
	      	listar(request, response);
	   }catch (Exception e) {
		   	request.setAttribute("message", "No se pudo crear el registro. "+e.getMessage());
		   	listar(request, response);		
	   }
   }

   private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int cod = Integer.parseInt(request.getParameter("cod"));
      request.setAttribute("ingeniero", serviIngeniero.buscaIngeniero(cod));
      request.getRequestDispatcher("actualizarIngeniero.jsp").forward(request, response);
   }
   
   private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {
		   int cod = Integer.parseInt(request.getParameter("cod"));
		   serviIngeniero.eliminaIngeniero(cod);
		   request.setAttribute("message", "Se elimino correctamente el registro");
		   listar(request, response);
	   }catch (Exception e) {
		   request.setAttribute("message", "No se pudo eliminar el registro. "+e.getMessage());
		   listar(request, response);
	   }
      
   }
}
