import { FastifyReply, FastifyRequest } from "fastify";

export abstract class AbstractProductController {
    abstract create(request: FastifyRequest, reply:FastifyReply): Promise<void>;
    abstract update(request: FastifyRequest, reply:FastifyReply): Promise<void>
    // abstract getById(productId: string): Promise<Product>;
    // abstract getAll(): Promise<Product>;
    // abstract delete(productId: string): void;
}