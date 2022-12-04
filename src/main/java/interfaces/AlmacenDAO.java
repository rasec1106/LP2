package interfaces;

import java.util.List;

import beans.AlmacenDTO;

public interface AlmacenDAO {
	public List<AlmacenDTO> listarAlmacen();
	public int registrarAlmacen(AlmacenDTO obj);
	public int actualizarAlmacen(AlmacenDTO obj);
	public int eliminarAlmacen(int cod);
	public AlmacenDTO buscarAlmacen(int cod);
}
