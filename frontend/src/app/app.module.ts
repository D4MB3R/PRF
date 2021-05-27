import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { AngularFireModule } from '@angular/fire';
import { environment } from 'src/environments/environment';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { ErrorComponent } from './pages/error/error.component';
import { DataService } from './services/data.service';
import { LoggedInService } from './services/logged-in.service';
import { ManageTransactionsComponent } from './pages/manage-transactions/manage-transactions.component';
import { ManagePurchasesComponent } from './pages/manage-purchases/manage-purchases.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainPageComponent,
    ErrorComponent,
    ManageTransactionsComponent,
    ManagePurchasesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    AngularFireModule.initializeApp(environment.firebase),
    HttpClientModule
  ],
  providers: [DataService, LoggedInService],
  bootstrap: [AppComponent]
})
export class AppModule { }
