package Interfaces;

import model.TblUsuario;
import java.util.List;;

public interface IUsuario {
	
	void RegitrarUsuario(TblUsuario usuario);
	void ActualizarUsuario(TblUsuario usuario);
	void EliminarUsuario(TblUsuario usuario);
	List<TblUsuario> ListarUsuario();
	TblUsuario BuscarUsuario(TblUsuario usuario);
	

}
