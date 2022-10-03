package controlador;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import entidad.Alumno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.ModelAlumno;

/**
 * Servlet implementation class ServletAlumno
 */
@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
	ModelAlumno m = new ModelAlumno();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		if(tipo.equals("listar"))
			listar(request, response);
		else if(tipo.equals("registrar"))
			registrar(request, response);
		else if(tipo.equals("buscar"))
			buscar(request, response);
		else if(tipo.equals("actualizar"))
			actualizar(request, response);
		else if(tipo.equals("eliminar"))
			eliminar(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("txt_cod"));
		m.eliminar(cod);
		request.getRequestDispatcher("ServletAlumno?tipo=listar").forward(request, response);			
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alumno obj = new Alumno();
		int cod = Integer.parseInt(request.getParameter("txt_cod"));
		String nom = request.getParameter("txt_nom");
		String ape = request.getParameter("txt_ape");
		String dir = request.getParameter("txt_dir");
		int edad = Integer.parseInt(request.getParameter("txt_edad"));
		String cor = request.getParameter("txt_cor");
		String dis = request.getParameter("txt_dis");
		String car = request.getParameter("txt_car");
		
		obj.setCodigo(cod);
		obj.setNombre(nom);
		obj.setApellido(ape);
		obj.setDireccion(dir);
		obj.setEdad(edad);
		obj.setCorreo(cor);
		obj.setDistrito(dis);
		obj.setCargo(car);
		
		int estado = m.actualizar(obj);
		if(estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("txt_cod"));
		Alumno x = m.buscar(cod);
		request.setAttribute("registro", x);
		request.getRequestDispatcher("actualizarAlumno.jsp").forward(request, response);		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alumno obj = new Alumno();
		String nom = request.getParameter("txt_nom");
		String ape = request.getParameter("txt_ape");
		String dir = request.getParameter("txt_dir");
		int edad = Integer.parseInt(request.getParameter("txt_edad"));
		String cor = request.getParameter("txt_cor");
		String dis = request.getParameter("txt_dis");
		String car = request.getParameter("txt_car");
		
		obj.setNombre(nom);
		obj.setApellido(ape);
		obj.setDireccion(dir);
		obj.setEdad(edad);
		obj.setCorreo(cor);
		obj.setDistrito(dis);
		obj.setCargo(car);
		
		int estado = m.registrar(obj);
		if(estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Alumno> info = m.listar();
		request.setAttribute("data", info);
		request.getRequestDispatcher("listarAlumno.jsp").forward(request, response);
	}

}
