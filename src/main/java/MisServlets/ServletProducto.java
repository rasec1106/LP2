package MisServlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import beans.ProductoDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductoService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductoService serviProducto = new ProductoService();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProducto() {
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
      request.setAttribute("data", serviProducto.listaProducto());
      request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
   }
   
   private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      int marca, stock, cod;
	      cod = Integer.parseInt(request.getParameter("txt_cod"));
	      String des = request.getParameter("txt_des");
	      double pre = Double.parseDouble(request.getParameter("txt_pre"));
	      stock = Integer.parseInt(request.getParameter("txt_stock"));
	      marca = Integer.parseInt(request.getParameter("cbo_marca"));
	      ProductoDTO obj = new ProductoDTO();
	      obj.setCodigo(cod);
	      obj.setDescripcion(des);
	      obj.setPrecio(pre);
	      obj.setStock(stock);
	      obj.setCodMarca(marca);
	      serviProducto.actualizaProducto(obj);
	      listar(request, response);
   }

   private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int marca, stock;
      String des = request.getParameter("txt_des");
      double pre = Double.parseDouble(request.getParameter("txt_pre"));
      stock = Integer.parseInt(request.getParameter("txt_stock"));
      marca = Integer.parseInt(request.getParameter("cbo_marca"));
      ProductoDTO obj = new ProductoDTO();
      obj.setDescripcion(des);
      obj.setPrecio(pre);
      obj.setStock(stock);
      obj.setCodMarca(marca);
      serviProducto.registraProducto(obj);
      listar(request, response);
   }

   private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int cod = Integer.parseInt(request.getParameter("cod"));
      request.setAttribute("Producto", serviProducto.buscaProducto(cod));
      request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
   }
   
   private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int cod = Integer.parseInt(request.getParameter("cod"));
      serviProducto.eliminaProducto(cod);
      listar(request, response);
   }

}
