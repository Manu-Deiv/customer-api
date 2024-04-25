import { app } from "./app";
const start = async () => {
    try {
        app.listen({ port: 3001}, () => {
            console.log(`Server is running on PORT 3001`)
        })
    } catch (error) {
        console.error('Erro ao iniciar o servidor:', error);
        process.exit(1);
    }
}
start();