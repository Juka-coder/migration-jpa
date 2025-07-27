package repository;

import jakarta.persistence.EntityManager;

import java.util.List;

public class GenericRepositoryImpl<T, ID> implements GenericRepository<T, ID> {

    protected EntityManager em;
    private Class<T> entityClass;

    public GenericRepositoryImpl(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    @Override
    public void save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public T update(T entity) {
        em.getTransaction().begin();
        T update = em.merge(entity);
        em.getTransaction().commit();
        return update;
    }

    @Override
    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }


    @Override
    public T findById(ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public void deleteById(ID id) {
        em.getTransaction().begin();
        T x = em.find(entityClass, id);
        if (x != null){
            em.remove(x);
        }
        em.getTransaction().commit();
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("FROM "+ entityClass.getSimpleName(), entityClass)
                .getResultList();
    }

    @Override
    public long count() {
        return em.createQuery("SELECT COUNT(e) FROM " +  entityClass.getSimpleName() +  " e", Long.class)
                .getSingleResult();
    }

    @Override
    public boolean existsById(ID id) {
        return findById(id) != null;
    }
}

