package puc.stock.model

data class PurchaseDTO (
    val id: Long,
    val itens: List<ItemDTO>,
    val buyer:Int,
    val price: Double
)