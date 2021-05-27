import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminGuard } from './guards/admin.guard';
import { AuthGuard } from './guards/auth.guard';
import { LoginComponent } from './login/login.component';
import { ErrorComponent } from './pages/error/error.component';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { ManagePurchasesComponent } from './pages/manage-purchases/manage-purchases.component';
import { ManageTransactionsComponent } from './pages/manage-transactions/manage-transactions.component';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'mainpage', component: MainPageComponent, canActivate: [AuthGuard]},
  {path: 'manage-purchases', component: ManagePurchasesComponent, canActivate: [AuthGuard, AdminGuard]},
  {path: 'manage-transactions', component: ManageTransactionsComponent, canActivate: [AuthGuard, AdminGuard]},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
