import nodemailer from 'nodemailer';
import { EmailSenderInterface } from '../../domain/providers/EmailSender';
import { EmailEntity } from '../../domain/entities/Email';
import { EnvironmentVariables } from '../config/EnvironmentVariables';

/**
 * Implementation of the EmailSenderInterface using Nodemailer.
 */
class EmailSender implements EmailSenderInterface {
  private transporter: nodemailer.Transporter;
  private env: EnvironmentVariables;

  /**
   * Constructs an instance of EmailSender.
   */
  constructor() {
    this.env = EnvironmentVariables.getInstance();

    this.transporter = nodemailer.createTransport({
      host: this.env.getMailHost(),
      port: this.env.getMailPort(),
      secure: false, // Use `true` for port 465, `false` for all other ports
      auth: {
        user: this.env.getMailUser(),
        pass: this.env.getMailPassword(),
      },
    });
  }

  /**
   * Sends an email using Nodemailer.
   * @param email - The email entity containing the email details.
   * @returns A Promise that resolves when the email is sent successfully.
   */
  async send(email: EmailEntity): Promise<void> {
    // Send email using nodemailer
    const mailOptions = {
      from: 'your-email@example.com',
      to: email.to,
      subject: email.subject,
      text: email.body
    };

    await this.transporter.sendMail(mailOptions);
  }
}

export default EmailSender;
