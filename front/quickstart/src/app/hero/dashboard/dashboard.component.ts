import {Component, OnInit} from "@angular/core";
import {HeroService} from "../hero.service";
import {Hero} from "../hero";

@Component({
  selector: 'my-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']

})
export class DashboardComponent implements OnInit {

  heroes: Hero[];

  constructor(private heroService: HeroService) {
    this.heroService.getHeroes().then(heroes => this.heroes = heroes.slice(1, 5))
  }

  ngOnInit(): void {
  }

}
