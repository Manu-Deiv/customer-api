import { EmailEntity } from '../entities/Email';

export interface EmailSenderInterface {
  send(emailEntity: EmailEntity): Promise<void>;
}
