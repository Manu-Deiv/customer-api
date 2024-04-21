import Email from '../entities/Email';

export interface EmailSenderInterface {
  send(email: Email): Promise<void>;
}
