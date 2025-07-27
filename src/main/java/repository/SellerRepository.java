package repository;

import entity.Seller;
import jakarta.persistence.EntityManager;

public class SellerRepository extends GenericRepositoryImpl<Seller, Long> {

    public SellerRepository(EntityManager em, Class<Seller> entityClass) {
        super(em, entityClass);
    }
}
