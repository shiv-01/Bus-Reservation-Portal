import { registerLocaleData } from '@angular/common';
import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminComponent } from './components/admin/admin.component';
import { AvilablebusesComponent } from './components/avilablebuses/avilablebuses.component';
import { BusControlComponent } from './bus-control/bus-control.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { FeedbackControlComponent } from './feedback-control/feedback-control.component';
import { FeedbacksComponent } from './components/feedbacks/feedbacks.component';
import { HomeComponent } from './components/home/home.component';
import { LoginMenuComponent } from './components/login-menu/login-menu.component';
import { RegisterComponent } from './components/register/register.component';
import { ReservationComponent } from './components/reservation/reservation.component';
import { RouteControlComponent } from './route-control/route-control.component';
import { UserControlComponent } from './user-control/user-control.component';

const routes: Routes = [
{
  path:'dashboard',
  component:DashboardComponent
},
{
  path:'register',
  component:RegisterComponent
},
{
  path:'home',
  component:HomeComponent
},
{
  path:'admin',
  component:AdminHomeComponent
},
{
  path:'feedbacks',
  component:FeedbacksComponent
},
{
  path:'reservation',
  component:ReservationComponent
},
{
  path:'',
  component:LoginMenuComponent
},
{
  path:'getAvailableBuses/:from/:to/:date',
  component:AvilablebusesComponent
},
{ path: 'users', component: UserControlComponent },

  { path: 'buscontrol', component: BusControlComponent },

  { path: 'routecontrol', component: RouteControlComponent },

  { path: 'feedbackcontrol', component: FeedbackControlComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
