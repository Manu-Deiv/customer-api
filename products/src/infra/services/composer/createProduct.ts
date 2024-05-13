import { CreateProductUseCase } from "src/application/useCases/CreateProductUseCase";
import { ProductRepository } from "src/infra/repositories/ProductRepository";
import { ProductController } from "src/presentation/fastify/controllers/products/ProductController";

export function createProductComposer(){
    const productRepository = new ProductRepository()
    const createProductUseCase = new CreateProductUseCase(productRepository)
    const productController = new ProductController(createProductUseCase)
    return productController
}