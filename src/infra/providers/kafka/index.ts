import { Kafka, logLevel } from 'kafkajs';

const kafka = new Kafka({
  clientId: 'costumer-app',
  brokers: ['kafka:9092'],
  logLevel: logLevel.ERROR,
});

export { kafka };
