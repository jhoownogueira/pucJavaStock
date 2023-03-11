package puc.stock.services

import org.springframework.stereotype.Service
import puc.stock.model.PurchaseDTO
import puc.stock.repository.ProductRepository

@Service
class StockService(private val productRepository: ProductRepository) {

    fun darBaixaNoEstoque(purchaseDTO: PurchaseDTO) {
        purchaseDTO.itens.forEach {
            val product = productRepository.findById(it.productId).orElseThrow {
                throw NoSuchElementException("Produto $it não encontrado")
            }

            val newAmount = product.stock - it.amount
            if (newAmount < 0) {
                throw IllegalArgumentException("A quantidade disponível em estoque é insuficiente para a baixa")
            }

            product.stock = newAmount
            productRepository.save(product)

        }




    }

}

//class ServicoCompra(private val servicoProduto: ServicoProduto) {
//    fun realizarCompra(compraDTO: CompraDTO) {
//        val produtosVendidos = mutableListOf<Produto>()
//        compraDTO.produtos.forEach { produtoDTO ->
//            val produtoExistente = servicoProduto.recuperarProdutoPorNome(produtoDTO.nome)
//            if (produtoExistente != null) {
//                if (produtoExistente.quantidadeEmEstoque >= produtoDTO.quantidade) {
//                    produtoExistente.quantidadeEmEstoque -= produtoDTO.quantidade
//                    produtosVendidos.add(produtoExistente)
//                } else {
//                    throw EstoqueInsuficienteException("Quantidade insuficiente do produto ${produtoDTO.nome}.")
//                }
//            } else {
//                throw ProdutoNaoEncontradoException("Produto com nome ${produtoDTO.nome} não encontrado.")
//            }
//        }
//
//        val venda = servicoProduto.realizarVenda(produtosVendidos)
//        // enviar informações de entrega para serviço externo de entregas
//    }
//}
