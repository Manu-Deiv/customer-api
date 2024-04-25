import Fastify from 'fastify';
import '../../infrastructure/providers/kafka/consumers';

const app = Fastify();

export { app };
