package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;
import model.TblProducto;

public class TblProductoImp implements IProducto{

	@Override
	public void RegistrarProducto(TblProducto producto) {
		// nos conectamos con la U.P
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAMavenMarNoche");
		EntityManager em= emf.createEntityManager();
		
		try {
			//iniciamos la transaccion
			em.getTransaction().begin();
			//invocamos al metodo
			em.persist(producto);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
		}
		finally{
			//cerramos
			em.close();
		}
		
	}// fin del metodo registrar

	@Override
	public void ActualizarProducto(TblProducto producto) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAMavenMarNoche");
		EntityManager em= emf.createEntityManager();
		
		try{
			//iniciamos la transaccion
			em.getTransaction().begin();
			//invocamos el metodo que actualiza
			em.merge(producto);
			//confirmamos
			em.getTransaction().commit();
			}catch(RuntimeException e){
				//enviamos mensaje si hay error
				e.getMessage();
			}finally{
			//cerramos
			em.close();
			}
		
	}//fin del metodo Actualizar

	@Override
	public void EliminarProducto(TblProducto producto) {
		// TODO Auto-generated method stub
		
	}// fin del metodo Eliminar

	@Override
	public List<TblProducto> ListarProducto() {
		// TODO Auto-generated method stub
		return null;
	}// fin del metodo Listar

	@Override
	public TblProducto BuscarProducto(TblProducto producto) {
		// TODO Auto-generated method stub
		return null;
	}//Fin del metodo Buscard

}
