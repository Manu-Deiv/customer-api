import { EmailGeneratorInterface } from '../../../domain/generators/emailGenerators/EmailGenerator';
import { EmailSenderInterface } from '../../../domain/providers/EmailSender';
import { SendWelcomeEmailUseCaseInterface } from './SendWelcomeEmailInterface';

export class SendWelcomeEmailUseCase
  implements SendWelcomeEmailUseCaseInterface
{
  private emailSender: EmailSenderInterface;
  private emailGenerator: EmailGeneratorInterface;

  constructor(
    emailSender: EmailSenderInterface,
    emailGenerator: EmailGeneratorInterface,
  ) {
    this.emailSender = emailSender;
    this.emailGenerator = emailGenerator;
  }

  async execute(username: string, email: string): Promise<void> {
    const welcomeEmail = this.emailGenerator.generateWelcomeEmail(
      username,
      email,
    );
    welcomeEmail.to = email;
    await this.emailSender.send(welcomeEmail);
  }
}
