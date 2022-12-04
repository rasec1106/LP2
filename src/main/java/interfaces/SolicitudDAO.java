package interfaces;

import java.util.List;

import beans.SolicitudDTO;

public interface SolicitudDAO {
	public List<SolicitudDTO> listarSolicitud();
	public int registrarSolicitud(SolicitudDTO obj);
	public int actualizarSolicitud(SolicitudDTO obj);
	public int eliminarSolicitud(int cod);
	public SolicitudDTO buscarSolicitud(int cod);
}
