import prismaClient from "../../prisma"
import { AbstractProductRepository } from "./AbstractProductRepository";
import { ResponseProductDto } from "src/domain/dtos/ResponseProductDto";
import { CreateProductDto } from "src/domain/dtos/CreateProductDto";
import { UpdateProductDto } from "src/domain/dtos/UpdateProductDto";
import { Product } from "src/domain/entities/Product";


export class ProductRepository implements AbstractProductRepository{
    public mapPrismaProductToResponseProductDto (prismaProduct: any): ResponseProductDto {
        const responseProductDto = new ResponseProductDto(
            prismaProduct.id,
            prismaProduct.name, 
            prismaProduct.code,
            prismaProduct.value,
            prismaProduct.description,
            prismaProduct.created_at,
            prismaProduct.updated_at,
        )
        return responseProductDto 
    }

    async create(data: CreateProductDto): Promise<ResponseProductDto> {
        const product = await prismaClient.product.create({
            data: {
                name: data.name,
                code: data.code,
                description: data.description,
                value: data.value,
            }
        })
        return this.mapPrismaProductToResponseProductDto(product)
    }

    async update(productId: string, data: UpdateProductDto): Promise<ResponseProductDto| null>{
        const updatedProduct = await prismaClient.product.update({
            where: {id: productId},
            data: {
                name: data.name,
                description: data.description,
                value: data.value,
            }
        })
        return updatedProduct ? this.mapPrismaProductToResponseProductDto(updatedProduct) : null
    }

    async getById(productId: string): Promise<ResponseProductDto | null> {
        const productById = await prismaClient.product.findUnique({
            where: {
                id: productId,
            }
        })
        
        return productById ?  this.mapPrismaProductToResponseProductDto(productById) : null
    }
    
    async getByCode(code: string): Promise<ResponseProductDto | null> {
        const product = await prismaClient.product.findFirst({
            where: {
                code,
            }
        })
        return product ? this.mapPrismaProductToResponseProductDto(product): null
    }
    async getAll(): Promise<ResponseProductDto | null> {
        const allProducts = await prismaClient.product.findMany()
        return allProducts.map((product) =>
            this.mapPrismaProductToResponseProductDto(product),
          );
    }

    async delete(productId: string): Promise<boolean> {
        const deleted = await prismaClient.product.delete({
            where: {
              id: productId
            },
        })
        return !!deleted
    }
    
}