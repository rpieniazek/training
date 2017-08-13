import {Injectable} from "@angular/core";
import {Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Hero} from "./hero";

@Injectable()
export class HeroService {
  private apiUrl = 'api/heroes';

  constructor(private http: Http) {

  }

  getHeroes(): Promise<Hero[]> {
    return this.http.get(this.apiUrl)
      .toPromise()
      .then(response => response.json().data as Hero[])
      .catch(this.handleError);
  }

  getHero(id: number): Promise<Hero> {
    return this.http.get(this.apiUrl + '/' + id)
      .toPromise()
      .then(response => response.json().data as Hero)
      .catch(this.handleError);
  }

  handleError(error: any) {
    console.error(error);
    return Promise.reject(error.message || error);
  }
}
