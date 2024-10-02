package Interfaces;

import model.TblProducto;
import java.util.List;;

public interface IProducto {
	//Declaramos su metodo
	void RegistrarProducto(TblProducto producto);
	void ActualizarProducto(TblProducto producto);
	void EliminarProducto(TblProducto producto);
	List<TblProducto> ListarProducto();
	TblProducto BuscarProducto(TblProducto producto);

}// fin de la interfas

