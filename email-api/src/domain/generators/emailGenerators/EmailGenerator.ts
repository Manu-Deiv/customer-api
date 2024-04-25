import { EmailEntity } from '../../entities/Email';

export interface EmailGeneratorInterface {
  generateWelcomeEmail(username: string, email: string): EmailEntity;
}
