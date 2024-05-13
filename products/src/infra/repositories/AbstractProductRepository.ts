import { CreateProductDto } from "src/domain/dtos/CreateProductDto";
import { ResponseProductDto } from "src/domain/dtos/ResponseProductDto";
import { UpdateProductDto } from "src/domain/dtos/UpdateProductDto";
import { Product } from "src/domain/entities/Product";


export abstract class AbstractProductRepository {
    abstract mapPrismaProductToResponseProductDto (prismaCustomer: any): ResponseProductDto
    abstract create(data: CreateProductDto): Promise<ResponseProductDto>;
    abstract update(productId: string, data: UpdateProductDto): Promise<ResponseProductDto | null>
    abstract getById(productId: string): Promise<ResponseProductDto | null>;
    abstract getAll(): Promise<ResponseProductDto | null>;
    abstract getByCode(code: string): Promise<ResponseProductDto | null>
    abstract delete(productId: string): Promise<boolean>;
}