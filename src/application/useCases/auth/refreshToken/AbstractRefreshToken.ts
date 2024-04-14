import { RefreshToken } from '../../../../domain/entities/RefreshToken'
import { RefreshTokenDTO } from '../../../../domain/dtos/auth/RefreshToken'


/**
 * Interface for the use case of refreshing a user's authentication token.
 *
 * This interface defines the contract for a use case responsible for refreshing
 * a user's authentication token using a provided refresh token identifier.
 *
 * @class
 */
export abstract class AbstractRefreshTokenUseCase {
  /**
   * Executes the refresh token user use case.
   *
   * @async
   * @param {RefreshTokenDTO} refreshToken - The refresh token information.
   * @returns {Promise<RefreshToken>} The response data.
   *
   * @remarks
   * This method is responsible for handling the logic of refreshing a user's
   * authentication token based on the provided refresh token identifier.
   */
  abstract execute(refreshToken: RefreshTokenDTO): Promise<RefreshToken>
}