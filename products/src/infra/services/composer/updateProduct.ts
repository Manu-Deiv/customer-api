import { UpdateProductUseCase } from "src/application/useCases/UpdateProductUseCase";
import { ProductRepository } from "src/infra/repositories/ProductRepository";
import { ProductController } from "src/presentation/fastify/controllers/products/ProductController";

export function updateProductComposer(){
    const productRepository = new ProductRepository()
    const updateProductUseCase = new UpdateProductUseCase(productRepository)
    const productController = new ProductController(updateProductUseCase)
    return productController
}