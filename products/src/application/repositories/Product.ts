import { CreateProductDto } from "src/domain/dtos/CreateProductDto";
import { UpdateProductDto } from "src/domain/dtos/UpdateProductDto";
import { Product } from "src/domain/entities/Product";

/**
 * Abstract class representing a product controller.
 */
export abstract class AbstractProductController {
    /**
     * Create a new product.
     * @param {CreateProductDto} createProductDto - The data to create the product.
     * @returns {Promise<Product>} A promise that resolves to the created product.
     */
    abstract createProduct(createProductDto: CreateProductDto): Promise<Product>;

    /**
     * Update an existing product.
     * @param {string} productId - The ID of the product to update.
     * @param {UpdateProductDto} updateProductDto - The data to update the product.
     * @returns {Promise<Product>} A promise that resolves to the updated product.
     */
    abstract updateProduct(productId: string, updateProductDto: UpdateProductDto): Promise<Product>;

    /**
     * Get a product by its ID.
     * @param {string} productId - The ID of the product to retrieve.
     * @returns {Promise<Product>} A promise that resolves to the retrieved product.
     */
    abstract getProductById(productId: string): Promise<Product>;

    /**
     * Get all products.
     * @returns {Promise<Product>} A promise that resolves to an array of all products.
     */
    abstract getAllProduct(): Promise<Product>;

    /**
     * Delete a product.
     * @param {string} productId - The ID of the product to delete.
     */
    abstract deleteProduct(productId: string): void;
}