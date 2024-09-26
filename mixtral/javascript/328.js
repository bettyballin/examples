import { NgModule } from '@angular/core';
import { AngularFireDatabaseModule } from '@angular/fire/database';
import { environment } from '../environments/environment';

@NgModule({
  imports: [
    AngularFireDatabaseModule.initializeApp(environment.firebaseConfig)
  ],
  declarations: [],
  providers: [],
  bootstrap: []
})
export class AppModule {}