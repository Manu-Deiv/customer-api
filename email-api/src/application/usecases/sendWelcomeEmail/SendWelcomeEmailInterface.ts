export interface SendWelcomeEmailUseCaseInterface {
  execute(username: string, email: string): Promise<void>;
}
