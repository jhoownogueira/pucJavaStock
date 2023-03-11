package puc.stock.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Product(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String,
        val description: String,
        val price: Double,
        val stock: Int,
)