import { FastifyRequest, FastifyReply } from "fastify"

import { ProductRepository } from "../../../../infra/repositories/ProductRepository"
import { CreateProductDto } from "src/domain/dtos/CreateProductDto"
import { CreateProductUseCase } from "src/application/useCases/CreateProductUseCase"
import { describe } from "node:test"


export class CreateProductManager{
    async handle(request: FastifyRequest, reply:FastifyReply){
        const {name, code, description, value, created_at, updated_at} = request.body as { name: string, code: string, description: string, value: number, created_at: Date, updated_at: Date}
        const createProductDto = new CreateProductDto(
            name,
            code,
            description,
            value,
            created_at,
            updated_at,
        )
        const productRepository = new ProductRepository()
        const productUseCase = new CreateProductUseCase(productRepository)
        const product = productUseCase.execute(CreateProductDto)
        
        reply.send(product)
    }
}

