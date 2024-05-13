import { FastifyInstance, FastifyPluginOptions, FastifyRequest, FastifyReply } from "fastify";;
import { createProductComposer } from "src/infra/services/composer/createProduct";
import { updateProductComposer } from "src/infra/services/composer/updateProduct";

export async function routes(fastify: FastifyInstance, options: FastifyPluginOptions) {
    fastify.post("/product", async(request: FastifyRequest, reply: FastifyReply) => {
        const controller = createProductComposer()
        return controller.create(request, reply)
    })
    fastify.patch("/product", async(request: FastifyRequest, reply: FastifyReply) => {
        const controller = updateProductComposer()
        return controller.update(request, reply)
    })

    
}