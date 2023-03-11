package puc.stock.controller

import org.springframework.web.bind.annotation.*
import puc.stock.model.PurchaseDTO
import puc.stock.services.StockService

@RestController
@RequestMapping("/stock")
class StockController(private val stockService: StockService) {

    @PostMapping("/write_off")
    fun darBaixa(@RequestBody purchaseDTO: PurchaseDTO) {
        return stockService.darBaixaNoEstoque(purchaseDTO)

    }


}