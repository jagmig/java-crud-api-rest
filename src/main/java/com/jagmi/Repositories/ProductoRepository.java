package com.jagmi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jagmi.Entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
