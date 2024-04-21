import Email from '../../entities/Email';

export interface EmailGeneratorInterface {
  generateWelcomeEmail(username: string, email: string): Email;
}
