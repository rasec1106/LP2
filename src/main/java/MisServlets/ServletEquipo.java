package MisServlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import beans.EquipoDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EquipoService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletEquipo")
public class ServletEquipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EquipoService serviEquipo = new EquipoService();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEquipo() {
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
	      else if (xtipo.equals("buscarpre")) {
	          buscarPrecio(request, response);
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
      request.setAttribute("data", serviEquipo.listaEquipo());
      request.getRequestDispatcher("consulta-Herrera.jsp").forward(request, response);
   }
   
   private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {		   
	      int marca, pais, stock, cod;
	      cod = Integer.parseInt(request.getParameter("txt_cod"));
	      String des = request.getParameter("txt_des");
	      double pre = Double.parseDouble(request.getParameter("txt_pre"));
	      stock = Integer.parseInt(request.getParameter("txt_stock"));
	      marca = Integer.parseInt(request.getParameter("cbo_marca"));
	      pais = Integer.parseInt(request.getParameter("cbo_pais"));
	      EquipoDTO obj = new EquipoDTO();
	      obj.setCodigo(cod);
	      obj.setDescripcion(des);
	      obj.setPrecio(pre);
	      obj.setStock(stock);
	      obj.setCodMarca(marca);
	      obj.setCodPais(pais);
	      serviEquipo.actualizaEquipo(obj);
	      request.setAttribute("message", "Se actualizo correctamente el registro");
	      listar(request, response);
	   }catch (Exception e) {
		   request.setAttribute("message", "No se pudo actualizar el registro. "+e.getMessage());
		   listar(request, response);		
	}
   }

   private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int marca, stock;
      String des = request.getParameter("txt_des");
      double pre = Double.parseDouble(request.getParameter("txt_pre"));
      stock = Integer.parseInt(request.getParameter("txt_stock"));
      marca = Integer.parseInt(request.getParameter("cbo_marca"));
      EquipoDTO obj = new EquipoDTO();
      obj.setDescripcion(des);
      obj.setPrecio(pre);
      obj.setStock(stock);
      obj.setCodMarca(marca);
      serviEquipo.registraEquipo(obj);
      listar(request, response);
   }

   private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int cod = Integer.parseInt(request.getParameter("cod"));
      request.setAttribute("equipo", serviEquipo.buscaEquipo(cod));
      request.getRequestDispatcher("actualizarEquipo.jsp").forward(request, response);
   }
   
   private void buscarPrecio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("txt_precio");
		try {
			double precio = Double.parseDouble(dato);
			request.setAttribute("data", serviEquipo.buscarPrecio(precio));
			request.getRequestDispatcher("consulta-Herrera.jsp").forward(request, response);						
		} catch (Exception e) {
			request.setAttribute("message", "Formato de precio incorrecto");
			listar(request, response);
		}
		
	}
   
   private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {
		   int cod = Integer.parseInt(request.getParameter("cod"));
		   serviEquipo.eliminaEquipo(cod);
		   request.setAttribute("message", "Se elimino correctamente el registro");
		   listar(request, response);
	   }catch (Exception e) {
		   request.setAttribute("message", "No se pudo eliminar el registro. "+e.getMessage());
		   listar(request, response);
	}
      
   }

}
