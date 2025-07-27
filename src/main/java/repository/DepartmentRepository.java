package repository;


import entity.Department;
import jakarta.persistence.EntityManager;


public class DepartmentRepository extends GenericRepositoryImpl<Department, Long> {

    public DepartmentRepository(EntityManager em) {
        super(em, Department.class);
    }
}