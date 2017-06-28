import {Component, OnInit} from "@angular/core";
import {Hero} from "./hero";
import {HeroService} from "./hero.service";

@Component({
  selector: 'my-app',
  template: `
    <div *ngFor="let hero of heroes" (click)="onSelect(hero)">
        Hello {{hero.name}}
    </div>
    <hero-detail [hero]="selectedHero"></hero-detail>
`,
  providers: [HeroService]
})

export class AppComponent implements OnInit {
  name = 'Angular';
  title = 'Tour of heroes';
  selectedHero: Hero;
  heroes: Hero[];

  constructor(private heroService: HeroService) {
  };

  ngOnInit() {
    this.getHeroes();
  }

  onSelect(hero: Hero): void {
    this.selectedHero = hero;
  }

  getHeroes() {
    this.heroService.getHeroes().then(heroes => this.heroes = heroes);
  }
}
