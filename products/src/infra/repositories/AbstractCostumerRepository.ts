import { ResponseProductDto } from "src/application/dtos/ResponseProductDto";
import { CreateProductDto } from "../../application/dtos/CreateProductDto";

export abstract class AbstractProductRepository {
    abstract mapPrismaCustomerToResponseProductDto (prismaCustomer: any): ResponseProductDto
    abstract create({name, code, description, value}: CreateProductDto): Promise<ResponseProductDto>;
}