package interfaces;

import java.util.List;
import beans.ProductoDTO;

public interface ProductoDAO {
	
	// Los metodos del CRUD
	public List<ProductoDTO> listarProducto();
}
