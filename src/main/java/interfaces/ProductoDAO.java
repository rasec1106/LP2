package interfaces;

import java.util.List;
import beans.ProductoDTO;

public interface ProductoDAO {
	
	// Los métodos del CRUD
	
	public List<ProductoDTO> listarProducto();
	public ProductoDTO buscarProducto(int cod);
	public int registrarProducto(ProductoDTO obj);
	public int actualizarProducto(ProductoDTO obj);
	public int eliminarProducto(int cod);
}
