import { AbstractProductRepository } from "src/infra/repositories/AbstractProductRepository";
import { CreateProductDto } from "../../application/dtos/CreateProductDto";
import { ResponseProductDto } from "../../application/dtos/ResponseProductDto";
import { Product } from "src/domain/entities/Product";
import { Barcode } from "src/domain/valueObjects/barcode";

/**
 * Use case class responsible for creating a new product.
 */
export class CreateProductUseCase {
    
    private productRepository: AbstractProductRepository;

    /**
     * Constructor of the CreateProductUseCase class.
     * @param {AbstractProductRepository} productRepository - The repository for product operations.
     */
    constructor(productRepository: AbstractProductRepository){
        this.productRepository = productRepository; 
    }

    /**
     * Method to execute the creation of a new product.
     * @param {CreateProductDto} data - The data required to create the product.
     * @returns {Promise<ResponseProductDto>} - A promise that resolves to the created product.
     * @throws {Error} - If any required field is missing or if the code length exceeds 13 characters.
     */
    async execute(data: CreateProductDto): Promise<ResponseProductDto> {
        const entity = new Product(
            data.name,
            data.code,
            data.description,
            data.value
        )
        const productAlreadyExist = await this.productRepository.getByCode(entity.code);
        if (productAlreadyExist){
            throw new Error("The product's code already exists")
        }
        const product = await this.productRepository.create(data); 
        return product;
    }
}
