import {Component, OnInit} from "@angular/core";
import {Hero} from "../hero";
import {HeroService} from "../hero.service";
import {Router} from "@angular/router"

@Component({
  selector: 'my-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})

export class HeroesComponent implements OnInit {
  selectedHero: Hero;
  heroes: Hero[];

  constructor(private heroService: HeroService,
              private router: Router) {
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

  goToDetails() {
    this.router.navigate(['/detail', this.selectedHero.id]);
  }

  onSaveHero(heroName: string) {
    heroName = heroName.trim();
    if (!heroName) {
      return;
    }

    this.heroService.save(heroName).then(value => {
      this.heroes.push(value);
      this.selectedHero = null;
    });
  }

  delete(hero: Hero): void {
    this.heroService.delete(hero.id)
      .then(() => {
        this.heroes = this.heroes.filter(h => h !== hero);
        console.log(this.heroes);
        if (this.selectedHero === hero) {
          this.selectedHero = null;
        }
      })
  }
}
