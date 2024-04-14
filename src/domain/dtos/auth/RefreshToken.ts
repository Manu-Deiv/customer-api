/**
 * Data Transfer Object (DTO) representing a refresh token.
 *
 * @class
 */
export class RefreshTokenDTO {
  /**
   * The unique identifier for the refresh token.
   */
  id: string;

  /**
   * The expiration time of the refresh token (in seconds).
   */
  expires_in: number;

  /**
   * The user ID associated with the refresh token.
   */
  user_id: string;

  /**
   * The creation timestamp of the refresh token.
   */
  createdAt: Date;

  /**
   * Constructs a new RefreshTokenDTO object.
   * @param {string} id - The unique identifier for the refresh token.
   * @param {number} expires_in - The expiration time of the refresh token (in seconds).
   * @param {string} user_id - The user ID associated with the refresh token.
   * @param {Date} createdAt - The creation timestamp of the refresh token.
   */
  constructor(id: string, expires_in: number, user_id: string, createdAt: Date) {
    this.id = id;
    this.expires_in = expires_in;
    this.user_id = user_id;
    this.createdAt = createdAt;
  }
}
