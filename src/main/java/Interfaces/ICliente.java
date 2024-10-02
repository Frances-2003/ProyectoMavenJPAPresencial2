package Interfaces;

import java.util.List;

import model.TblCliente;;

public interface ICliente {
	
	void RegistrarCliente(TblCliente cliente);
	void ActualizarCliente(TblCliente cliente);
	void EliminarCliente(TblCliente cliente);
	List<TblCliente> ListarCliente();
	TblCliente BuscarProducto(TblCliente cliente);

}
