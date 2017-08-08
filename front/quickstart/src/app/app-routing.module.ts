import {DashboardComponent} from "./dashboard/dashboard.component";
import {HeroesComponent} from "./hero-list/heroes.component";
import {HeroDetailComponent} from "./hero-detail/hero-detail.component";
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";

const routes = [
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full'//without it fails
  }, {
    path: 'dashboard',
    component: DashboardComponent
  }, {
    path: 'heroes',
    component: HeroesComponent
  }, {
    path: 'detail/:id',
    component: HeroDetailComponent
  }];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
