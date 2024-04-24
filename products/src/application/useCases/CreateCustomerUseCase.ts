import { AbstractProductRepository } from "src/infra/repositories/AbstractCostumerRepository";
import { CreateProductDto } from "../../application/dtos/CreateProductDto";
import { ResponseProductDto } from "../../application/dtos/ResponseProductDto";

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
        if (!data.name || !data.description || !data.code || !data.value) {
            throw new Error("All fields are required to register a product.");
        } else if (data.code.length > 13) {
            throw new Error("The product's barcode can only have up to 13 characters.");
        }
        const product = await this.productRepository.create(data);
        return product;
    }
}
