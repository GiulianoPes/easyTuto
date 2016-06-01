package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CategoriaFacade {

	@PersistenceContext(unitName = "easyTuto")
	private EntityManager em;

	public Categoria save(Categoria categoria) {
		em.persist(categoria);
		return categoria;
	}

	public void update(Categoria categoria) {
		em.merge(categoria);
	}

	public Categoria findById(long id) {
		Categoria categoria = em.find(Categoria.class, id);
		return categoria;
	}

	public void delete(Categoria categoria) {
		Categoria toRemove = em.merge(categoria);
	}

	public List<Categoria> findAll() {
		List<Categoria> result = em.createNamedQuery("Categoria.findAll").getResultList();
		return result;
	}

	public List<Categoria> findByParameter(String parameter1, String column1, String parameter2, String column2){
		
		Query query = em.createQuery("from Categoria t where t.c1=:p1 and t.c2=:p2");
		query.setParameter("p1", parameter1);
		query.setParameter("p2", parameter2);
		query.setParameter("c1", column1);
		query.setParameter("c2", column2);
		List<Categoria> list = query.getResultList();
		return list;
	}

	public List<Categoria> findByParameter(String parameter, String column) {

		Query query = em.createQuery("from Categoria t where t.c=:p");
		query.setParameter("p", parameter);
		query.setParameter("c", column);
		List<Categoria> list = query.getResultList();
		return list;
	}
}
