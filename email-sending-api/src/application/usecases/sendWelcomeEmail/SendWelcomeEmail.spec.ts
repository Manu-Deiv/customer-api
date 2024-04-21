import { describe, beforeEach, it, vi, expect } from 'vitest';

import { EmailGeneratorInterface } from '../../../domain/generators/emailGenerators/EmailGenerator';
import { EmailSenderInterface } from '../../../domain/providers/EmailSender';
import { SendWelcomeEmailUseCase } from './SendWelcomeEmail';
import { SendWelcomeEmailUseCaseInterface } from './SendWelcomeEmailInterface';

describe('SendWelcomeEmailUseCase', () => {
  let emailSenderMock: EmailSenderInterface;
  let emailGeneratorMock: EmailGeneratorInterface;
  let sendWelcomeEmailUseCase: SendWelcomeEmailUseCaseInterface;

  beforeEach(() => {
    emailSenderMock = {
      send: vi.fn().mockResolvedValue(undefined),
    };

    emailGeneratorMock = {
      generateWelcomeEmail: vi.fn().mockReturnValue({
        to: 'recipient@example.com',
        subject: 'Welcome to Our Platform!',
        body: 'Welcome message',
      }),
    };

    sendWelcomeEmailUseCase = new SendWelcomeEmailUseCase(
      emailSenderMock,
      emailGeneratorMock,
    );
  });

  it('should send welcome email successfully', async () => {
    const username = 'testuser';
    const email = 'testuser@example.com';

    await sendWelcomeEmailUseCase.execute(username, email);

    expect(emailGeneratorMock.generateWelcomeEmail).toHaveBeenCalledWith(
      username,
      email,
    );
    expect(emailSenderMock.send).toHaveBeenCalledWith({
      to: email,
      subject: 'Welcome to Our Platform!',
      body: 'Welcome message',
    });
  });
});
