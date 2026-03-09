package net.agrigah.bdccensetspringmvc.repositories;
import net.agrigah.bdccensetspringmvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
