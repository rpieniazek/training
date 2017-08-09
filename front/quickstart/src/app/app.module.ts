import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";

import {AppComponent} from "./app.component";
import {HeroDetailComponent} from "./hero/hero-detail/hero-detail.component";
import {HeroesComponent} from "./hero/hero-list/heroes.component";
import {HeroService} from "./hero/hero.service";
import {DashboardComponent} from "./hero/dashboard/dashboard.component";
import {AppRoutingModule} from "./app-routing.module";

@NgModule({
  imports: [BrowserModule,
    FormsModule,
    AppRoutingModule],
  declarations: [AppComponent,
    HeroesComponent,
    HeroDetailComponent,
    DashboardComponent],
  bootstrap: [AppComponent],
  providers: [HeroService]

})

export class AppModule {
}
