import { AbstractProductRepository } from "src/infra/repositories/AbstractCostumerRepository";
import { ResponseProductDto } from "../../application/dtos/ResponseProductDto";
import { UpdateProductDto } from "../dtos/UpdateProductDto";

/**
 * Use case class responsible for creating a new product.
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
     * Method to execute the creation of a new product.
     * @param {UpdateProductDto} data - The data required to update the product.
     * @returns {Promise<ResponseProductDto>} - A promise that resolves to the updated product.
     * @throws {Error} - If any required field is missing or if the code length exceeds 13 characters.
     */
    async execute(data: UpdateProductDto, productId: number): Promise<ResponseProductDto> {
        const product = await this.productRepository.getById(productId);
        if (!product){
            throw new Error("O produto não foi encontrado.")
        }
        const productUpdated = await this.productRepository.update(data, product);
        return productUpdated;
    }
}
