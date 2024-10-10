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
		// nos conectamos con la U.P
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAMavenMarNoche");
				EntityManager em= emf.createEntityManager();
				
				try {
					em.getTransaction().begin();
					//recuperamos el codigo a eliminar
					TblProducto codelim=em.find(TblProducto.class, producto.getIdproducto());
					//aplicamos una condicion
					if(codelim !=null){
						em.remove(codelim);
					}
					//confirmamos
					em.getTransaction().commit();
					
					
				} catch (Exception e) {
					if(em.getTransaction().isActive()) em.getTransaction().rollback();
					e.getMessage();
				}finally{
					//cerramos 
					em.close();
				}
		
	}// fin del metodo Eliminar

	@Override
	public List<TblProducto> ListarProducto() {
		// nos conectamos con la U.P
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAMavenMarNoche");
		EntityManager em= emf.createEntityManager();
		List<TblProducto> listado=null;
		//iniciamos la transaccion
		try {
			em.getTransaction().begin();
			//aplicando JPQL(JAVA PERSISTENCE QUERY LANGUAGE)
			listado=em.createQuery("select p from TblProducto p", TblProducto.class).getResultList();
			em.getTransaction().commit();
			
			
			
		} catch (Exception e) {
			e.getMessage();
		}finally{
			em.close();
		}
		return listado;
	}// fin del metodo Listar

	@Override
	public TblProducto BuscarProducto(TblProducto producto) {
		// nos conectamos con la U.P
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAMavenMarNoche");
				EntityManager em= emf.createEntityManager();
				TblProducto buscaprod=null;
			try {
			//iniciamos la transaccion	
				em.getTransaction().begin();
				buscaprod=em.find(TblProducto.class,producto.getIdproducto());
				//confirmamos
				em.getTransaction().commit();
			} catch (Exception e) {
				e.getMessage();
			}finally{
				em.close();
			}
		
				
		return buscaprod;
	}//Fin del metodo Buscard

}
