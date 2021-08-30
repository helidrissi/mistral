package fr.mistral.multipledatasources.dao.product;

import fr.mistral.multipledatasources.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
