import { kafkaConsumer } from "../kafka.consumer";

export async function createCustomerConsumer(){
  
  
  const consumer = await kafkaConsumer("CUSTOMER_CREATED")
  console.log("CUSTOMER_CREATED");
  await consumer.run({
    eachMessage: async ({ message }) => {
      console.log(message);
      
      const messageToString = message.value?.toString();
      console.log(messageToString);
      
    }
  })
}
createCustomerConsumer()