package net.youssouf.bdcc_spring_boot.repository;

import net.youssouf.bdcc_spring_boot.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainsIgnoreCase(String keyword, Pageable pageable);

}
