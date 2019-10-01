/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.dao.crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Carlos Fernando
 */
public abstract class CrudService<T> {

    private Class<T> entityClass;

    public CrudService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    /**
	 * 
	 * @author Carlos Fernando
	 * @fecha 30/09/2019 - 9:41:10 p. m.
	 * @metodo create
         * @descripcion registra una entidad en base de datos
         * @param entity
	 */
    public void create(T entity) {
        try{
            getEntityManager().persist(entity);
        }catch(ConstraintViolationException ex){
            throw new PersistenceException("No se puede persistir la entidad: " + entity + " error " +ex.getMessage());
        }catch(PersistenceException ex){
            throw new PersistenceException("Un error ha ocurrido desde el abstract facade: " + entity, ex);
        }
        
    }
    
    /**
	 * 
	 * @author Carlos Fernando
	 * @fecha 30/09/2019 - 9:41:10 p. m.
	 * @metodo edita una entidad dada por parametro
	 */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
	 * 
	 * @author Carlos Fernando
	 * @fecha 30/09/2019 - 9:41:10 p. m.
	 * @metodo remove
         * @descripcion elimina una entidad recibida por parametro
         * @param entity 
	 */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
	 * 
	 * @author Carlos Fernando
	 * @fecha 30/09/2019 - 9:37:26 p. m.
	 * @metodo
	 * @param id	
	 * @return
	 */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
	 * 
	 * @author Carlos Fernando
	 * @fecha 30/09/2019 - 9:37:26 p. m.
	 * @metodo
	 * @descripcion
	 * @return
	 */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
	 * 
	 * @author Carlos Fernando
	 * @fecha 30/09/2019 - 9:37:26 p. m.
	 * @metodo
	 * @param range	 
	 * @return
	 */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
	 * 
	 * @author Carlos Fernando
	 * @fecha 30/09/2019 - 9:41:10 p. m.
	 * @metodo
	 */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
