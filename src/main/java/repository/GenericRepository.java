package repository;

import java.util.List;

public interface GenericRepository<T,ID> {
    void save(T entity);
    T update(T entity);
    void delete(T entity);
    void deleteById(ID id);
    T findById(ID id);
    List<T> findAll();
    long count();
    boolean existsById(ID id);

}
