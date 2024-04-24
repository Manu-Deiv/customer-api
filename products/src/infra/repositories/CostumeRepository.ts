import { CreateCustomerDto } from "src/application/dtos/CreateCostumeDto";
import prismaClient from ".. /prisma"
import { AbstractCostumerRepository } from "./AbstractCostumerRepository";
import { ResponseCustomerDto } from "src/application/dtos/ResponseCostumeDto";


export class CostumeRepository implements AbstractCostumerRepository{
    public mapPrismaCustomerToResponseCustomerDto (prismaCustomer: any): ResponseCustomerDto {
        const responseCustomerDto = new ResponseCustomerDto(prismaCustomer.name, prismaCustomer.email, prismaCustomer.status )
        return responseCustomerDto 
        
    }

    async create(data: CreateCustomerDto): Promise<ResponseCustomerDto> {
        const customer = await prismaClient.customer.create({
            data: {
                name: data.name,
                email: data.email,
                status: true
            }
        })
        
        return this.mapPrismaCustomerToResponseCustomerDto(customer)
    }

    // async update(data:)
    
}