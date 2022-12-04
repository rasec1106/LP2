package MisServlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import beans.UsuarioDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuarioService;
import utils.Utils;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UsuarioService serviUsuario = new UsuarioService();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
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
	       else if (xtipo.equals("login")) {
		      login(request, response);
		   }
	}

   private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setAttribute("data", serviUsuario.listaUsuario());
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
	      UsuarioDTO obj = new UsuarioDTO();
	      /*obj.setCodigo(cod);
	      obj.setNombre(nom);
	      obj.setApellido(ape);
	      obj.setDni(dni);
	      obj.setSueldo(sue);
	      obj.setCodUniversidad(uni);
	      obj.setCodEspecialidad(esp);*/
	      serviUsuario.actualizaUsuario(obj);
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
	      	UsuarioDTO obj = new UsuarioDTO();
	      	/*obj.setNombre(nom);
	      	obj.setApellido(ape);
	      	obj.setDni(dni);
	      	obj.setSueldo(sue);
	      	obj.setCodUniversidad(uni);
	      	obj.setCodEspecialidad(esp);*/
	      	serviUsuario.registraUsuario(obj);
	      	request.setAttribute("message", "Se creo correctamente el registro");
	      	listar(request, response);
	   }catch (Exception e) {
		   	request.setAttribute("message", "No se pudo crear el registro. "+e.getMessage());
		   	listar(request, response);		
	   }
   }

   private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int cod = Integer.parseInt(request.getParameter("cod"));
      request.setAttribute("Usuario", serviUsuario.buscaUsuario(cod));
      request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
   }
   
   private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {
		   int cod = Integer.parseInt(request.getParameter("cod"));
		   serviUsuario.eliminaUsuario(cod);
		   request.setAttribute("message", "Se elimino correctamente el registro");
		   listar(request, response);
	   }catch (Exception e) {
		   request.setAttribute("message", "No se pudo eliminar el registro. "+e.getMessage());
		   listar(request, response);
	   }
      
   }
   
   private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {
		   String usuario = request.getParameter("txt_usr");
		   String clave = request.getParameter("txt_clv");
		   UsuarioDTO myUser = serviUsuario.logueaUsuario(usuario, clave);
		   if(myUser != null) {
			   Utils.setCurrentUser(myUser);
			   request.setAttribute("message", "Bienvenido al sistema");
			   request.getRequestDispatcher("index.jsp").forward(request, response);
		   }
		   else {
			   request.setAttribute("message", "Usuario o contrasena incorrectos");
			   request.getRequestDispatcher("login.jsp").forward(request, response);
		   }
	   }catch (Exception e) {
		   request.setAttribute("message", "Hubo un error inesperado!!!"+e.getMessage());
		   request.getRequestDispatcher("login.jsp").forward(request, response);
	   }
   }
}
