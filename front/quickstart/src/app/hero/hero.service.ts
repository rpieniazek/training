import {Injectable} from "@angular/core";
import {Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Hero} from "./hero";

@Injectable()
export class HeroService {
  private apiUrl = 'api/heroes/';

  constructor(private http: Http) {

  }

  getHeroes(): Promise<Hero[]> {
    return this.http.get(this.apiUrl)
      .toPromise()
      .then(response => response.json().data as Hero[])
      .catch(this.handleError);
  }

  getHero(id: number): Promise<Hero> {
    return this.http.get(this.apiUrl + id)
      .toPromise()
      .then(response => response.json().data as Hero)
      .catch(this.handleError);
  }

  update(hero: Hero): Promise<Hero> {
    return this.http
      .put(this.apiUrl + hero.id, JSON.stringify(hero))
      .toPromise()
      .then(() => hero)
      .catch(this.handleError);
  }

  save(heroName: string): Promise<Hero> {
    return this.http
      .post(this.apiUrl, JSON.stringify({name: heroName}))
      .toPromise()
      .then(res => res.json().data as Hero)
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    return this.http.delete(this.apiUrl + id)
      .toPromise()
      .then(() => null)
      .catch(this.handleError)
  }

  handleError(error: any) {
    console.error(error);
    return Promise.reject(error.message || error);
  }
}
