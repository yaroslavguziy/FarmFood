package com.gpec.FarmFood.repositories;

import com.gpec.FarmFood.model.db.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    List<Seller> findAllByCity(String city);
}
