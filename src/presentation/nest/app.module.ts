import {
  MiddlewareConsumer,
  Module,
  NestModule,
  RequestMethod,
} from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';

import { PrismaModule } from '../../infra/database/nestPrisma/prisma.module';
import { LoggerMiddleware } from './middlewares/ensureAuthenticated';
import { AuthModule } from './modules/auth.module';
import { CustomersModule } from './modules/customers.module';

@Module({
  imports: [
    CustomersModule,
    AuthModule,
    ConfigModule.forRoot({
      isGlobal: true,
    }),
    PrismaModule,
  ],
  controllers: [],
  providers: [],
})
export class AppModule implements NestModule {
  configure(consumer: MiddlewareConsumer) {
    consumer
      .apply(LoggerMiddleware)
      .exclude(
        { path: 'customers', method: RequestMethod.POST },
        { path: 'auth/login', method: RequestMethod.POST },
      )
      .forRoutes('customers', 'auth');
  }
}
