package com.project.sessions;

import com.project.entities.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class RolSession {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void create(Rol rol) {
        entityManager.persist(rol);        
    }
    public void update(Rol rol){
        entityManager.merge(rol);
    }  
    public void remove(Rol rol){
        entityManager.remove(rol);
    } 
    public List<Rol> findAll() {
        CriteriaQuery cq =
                entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Rol.class));
        return entityManager.createQuery(cq).getResultList();
    }  
}
