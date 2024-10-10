package TestEntidades;



import java.util.Date;

import DaoImp.TblProductoImp;
import model.TblProducto;

public class TestProducto {

	public static void main(String[] args) {
		// Realizamos la respectiva instacia
		TblProducto tblpro = new TblProducto();
		TblProductoImp impro= new TblProductoImp();
		
		
		// asignamos valores
		tblpro.setNomprod("Azucar Blanca");
		tblpro.setPrecio(3.5);
		tblpro.setCantidad(4);
		tblpro.setTotal(tblpro.getPrecio()*tblpro.getCantidad());
		tblpro.setCodbarras("799999999");
		tblpro.setNrolote("lote4589");
		Date fecha=new Date();
		Date fechasql=new Date(fecha.getTime());
		tblpro.setFechaven(fechasql);
		
		impro.RegistrarProducto(tblpro);
		
		System.out.println("Dato Registrado en la Bd");
		
		
		/*//Actualizar
		tblpro.setIdproducto(2);
		tblpro.setNomprod("sal");
		tblpro.setPrecio(3.5);
		tblpro.setCantidad(4);
		tblpro.setTotal(tblpro.getPrecio()*tblpro.getCantidad());
		tblpro.setCodbarras("4737643");
		tblpro.setNrolote("lote4339");
		Date fecha=new Date();
		Date fechasql=new Date(fecha.getTime());
		tblpro.setFechaven(fechasql);
		
		impro.ActualizarProducto(tblpro);
		
		System.out.println("Dato Actualizado en la Bd");
*/
	}// fin del metodo principal

}// fin de la clase
