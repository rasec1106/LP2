package interfaces;

import java.util.List;
import beans.EspecialidadDTO;

public interface EspecialidadDAO {	
	public List<EspecialidadDTO> listarEspecialidad();
	public EspecialidadDTO buscarEspecialidad(int cod);
}
