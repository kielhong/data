package net.kiel.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kiel on 2016. 4. 19..
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
