import { FastifyRequest, FastifyReply } from "fastify"

import { CostumeRepository } from "../infra/repositories/CostumeRepository"
import { CreateCustomerUseCase } from "../useCases/CreateCustomerUseCase"
import { CreateProductDto } from "../application/dtos/CreateProductDto"

export class CreateCustomerController{
    async handle(request: FastifyRequest, reply:FastifyReply){
        const {name, email} = request.body as { name: string, email: string}
        const CreateProductDto = new CreateProductDto(
            name, 
            email
        )
        const costumeRepository = new CostumeRepository()
        const customerUseCase = new CreateCustomerUseCase(costumeRepository)
        const customer = customerUseCase.execute(CreateProductDto)
        
        reply.send(customer)
    }
}

