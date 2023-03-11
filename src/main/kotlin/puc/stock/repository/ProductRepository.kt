package puc.stock.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import puc.stock.model.Product

@Repository
interface ProductRepository : JpaRepository<Product, Long>