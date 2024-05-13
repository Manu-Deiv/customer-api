import { AbstractProductRepository } from "src/infra/repositories/AbstractProductRepository";
import { ResponseProductDto } from "../../application/dtos/ResponseProductDto";
import { UpdateProductDto } from "../dtos/UpdateProductDto";

/**
 * Use case class responsible for updating a new product.
 */
export class UpdateProductUseCase {
    
    private productRepository: AbstractProductRepository;

    /**
     * Constructor of the UpdateProductUseCase class.
     * @param {AbstractProductRepository} productRepository - The repository for product operations.
     */
    constructor(productRepository: AbstractProductRepository){
        this.productRepository = productRepository;
    }

    /**
     * Method to execute the update of a new product.
     * @param {UpdateProductDto} data - The data required to update the product.
     * @returns {Promise<ResponseProductDto>} - A promise that resolves to the updated product.
     * @throws {Error} - If any required field is missing or if the code length exceeds 13 characters.
     */
    async execute(data: UpdateProductDto, productId: string): Promise<ResponseProductDto> {
        const product = await this.productRepository.getByCode(productId);
        if (!product){
            throw new Error("The product doesn't exist.")
        }
        const productUpdated = await this.productRepository.update(productId, data);
        return productUpdated;
    }
}
