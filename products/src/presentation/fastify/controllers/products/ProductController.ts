import { FastifyRequest, FastifyReply } from "fastify"

import { CreateProductDto } from "src/domain/dtos/CreateProductDto"
import { CreateProductUseCase } from "src/application/useCases/CreateProductUseCase"
import { AbstractProductController } from "./AbstractProductController"
import { UpdateProductDto } from "src/domain/dtos/UpdateProductDto"
import { UpdateProductUseCase } from "src/application/useCases/UpdateProductUseCase"


export class ProductController implements AbstractProductController{
    constructor (private productUseCase: any){}

    async create(request: FastifyRequest, reply:FastifyReply){
        if (request.body && Object.keys(request.body).length > 0){
            const bodyParams = Object.keys(request.body)
            
            if (bodyParams.includes('name') || bodyParams.includes('description') || bodyParams.includes('code') || bodyParams.includes('value')) {
                const data = request.body as {
                    name: string;
                    code: string;
                    description: string;
                    value: number;  
                }
                const createProductDto = new CreateProductDto(
                    data.name,
                    data.code,
                    data.description,
                    data.value,
                )
                const product = this.productUseCase.execute(createProductDto)
                reply.status(201).send(product)
            }
            
        }
        
    }
    async update(request: FastifyRequest, reply:FastifyReply){
        if (request.body && Object.keys(request.body).length > 0){
            const bodyParams = Object.keys(request.body)
            
            if (bodyParams.includes('id') || bodyParams.includes('name') || bodyParams.includes('code') || bodyParams.includes('description') || bodyParams.includes('value')) {
                const data = request.body as {
                    id: string, 
                    name: string;
                    description: string;
                    code: string;
                    value: number;  
                }
                const updateProductDto = new UpdateProductDto(
                    data.name,
                    data.description,
                    data.code,
                    data.value,
                )
                const product = this.productUseCase.execute(updateProductDto, data.id)
                reply.status(201).send(product)
            }
            
        }
        
    }
}

