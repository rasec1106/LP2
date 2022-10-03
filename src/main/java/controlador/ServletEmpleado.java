package controlador;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import entidad.Empleado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.ModelEmpleado;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	ModelEmpleado m = new ModelEmpleado();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login, clave;
		login = request.getParameter("txtLogin");
		clave = request.getParameter("txtClave");
		Empleado e = m.iniciarSesion(login, clave);
		if(e==null) {
			request.setAttribute("msj", "Error usuario y/o clave");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			response.sendRedirect("menu.jsp");
		}
	}

}
