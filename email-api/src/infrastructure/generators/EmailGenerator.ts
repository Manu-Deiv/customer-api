import * as fs from 'fs';
import * as Handlebars from 'handlebars';
import * as path from 'path';

import { EmailEntity } from '../../domain/entities/Email';
import { EmailGeneratorInterface } from '../../domain/generators/emailGenerators/EmailGenerator';

/**
 * Class responsible for generating email content based on templates.
 */
export class EmailGenerator implements EmailGeneratorInterface {
  private welcomeTemplate: HandlebarsTemplateDelegate;

  /**
   * Constructs an EmailGenerator instance.
   */
  constructor() {
    /**
     * Resolves the absolute file path of the welcome email template.
     * @type {string}
     */
    const templatePath = path.resolve(
      __dirname,
      '../../../src/infrastructure/templates/welcome.html',
    );

    /**
     * Reads the template file and compiles it using Handlebars.
     */
    const templateSource = fs.readFileSync(templatePath, 'utf8');
    this.welcomeTemplate = Handlebars.compile(templateSource);
  }

  /**
   * Generates a welcome email for the given username and email address.
   * @param {string} username - The username of the recipient.
   * @param {string} email - The email address of the recipient.
   * @returns {EmailEntity} The generated email entity.
   */
  generateWelcomeEmail(username: string, email: string): EmailEntity {
    /**
     * Generates HTML content for the email using the compiled template.
     */
    const htmlContent = this.welcomeTemplate({ username, email });

    /**
     * Constructs the email entity with the email address as the recipient, the subject, and the HTML content.
     */
    const subject = `Welcome, ${username}!`;
    return new EmailEntity(email, subject, htmlContent);
  }
}
