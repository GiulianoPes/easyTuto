package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TutoFacade {
	
	@PersistenceContext(unitName = "easyTuto")
    private EntityManager em;
	
	public Tuto save(Tuto tuto){		
		em.persist(tuto);
		return tuto;
	}
	
	public Tuto save(String nome, String descrizione, Date dataCreazione){	
		Tuto tuto = new Tuto(nome, descrizione, dataCreazione);
		em.persist(tuto);
		return tuto;
	}


	public void update(Tuto tuto){	
		em.merge(tuto);
	}

	public Tuto findById(long id){
		Tuto tuto = em.find(Tuto.class, id);
		return tuto;
	}

	public void delete(Tuto tuto){
		Tuto toRemove = em.merge(tuto);
	}

	public List<Tuto> findAll() {
		List<Tuto> result = em.createNamedQuery("Tuto.findAll").getResultList();
		return result;
	}

	public List<Tuto> findByParameter(String parameter1, String column1, String parameter2, String column2){	
		Query query = em.createQuery("from Tuto t where t.c1=:p1 and t.c2=:p2");
		query.setParameter("p1", parameter1);
		query.setParameter("p2", parameter2);
		query.setParameter("c1", column1);
		query.setParameter("c2", column2);
		List<Tuto> list = query.getResultList();
		return list;
	}

	public List<Tuto> findByParameter(String parameter, String column) {		
		Query query = em.createQuery("from Categoria t where t.c=:p");
		query.setParameter("p", parameter);
		query.setParameter("c", column);
		List<Tuto> list = query.getResultList();
		
		return list;
	}
}