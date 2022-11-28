package interfaces;

import java.util.List;
import beans.IngenieroDTO;

public interface IngenieroDAO {
	
	public List<IngenieroDTO> listarIngeniero();
	public int registrarIngeniero(IngenieroDTO obj);
	public int actualizarIngeniero(IngenieroDTO obj);
	public int eliminarIngeniero(int cod);
	/*public List<IngenieroDTO> buscarPorPrecio(double precio);
	public IngenieroDTO buscarEquipo(int cod);*/
}
