package controlador;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import entidad.Proveedor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.ModelProveedor;

/**
 * Servlet implementation class ServletProveedor
 */
@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	ModelProveedor m = new ModelProveedor();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProveedor() {
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
		int cod = Integer.parseInt(request.getParameter("codigo"));
		m.eliminar(cod);
		request.getRequestDispatcher("ServletProveedor?tipo=listar").forward(request, response);			
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Proveedor obj = new Proveedor();
		int cod = Integer.parseInt(request.getParameter("codigo"));
		String raz = request.getParameter("txt_raz");
		String ruc = request.getParameter("txt_ruc");
		String dir = request.getParameter("txt_dir");
		String dni = request.getParameter("txt_dni");
		String nom = request.getParameter("txt_nom");
		String cel = request.getParameter("txt_cel");
		String fec = request.getParameter("txt_fec");
		
		obj.setCodigo(cod);
		obj.setRazonSocial(raz);
		obj.setRuc(ruc);
		obj.setDireccion(dir);
		obj.setDni(dni);
		obj.setNombre(nom);
		obj.setCelular(cel);
		obj.setFecNacimiento(fec);
		
		int estado = m.actualizar(obj);
		if(estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("codigo"));
		Proveedor x = m.buscar(cod);
		request.setAttribute("registro", x);
		request.getRequestDispatcher("actualizarProveedor.jsp").forward(request, response);		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Proveedor obj = new Proveedor();
		String raz = request.getParameter("txt_raz");
		String ruc = request.getParameter("txt_ruc");
		String dir = request.getParameter("txt_dir");
		String dni = request.getParameter("txt_dni");
		String nom = request.getParameter("txt_nom");
		String cel = request.getParameter("txt_cel");
		String fec = request.getParameter("txt_fec");
		
		obj.setRazonSocial(raz);
		obj.setRuc(ruc);
		obj.setDireccion(dir);
		obj.setDni(dni);
		obj.setNombre(nom);
		obj.setCelular(cel);
		obj.setFecNacimiento(fec);
		
		int estado = m.registrar(obj);
		if(estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Proveedor> info = m.listar();
		request.setAttribute("data", info);
		request.getRequestDispatcher("listarProveedor.jsp").forward(request, response);
	}

}
