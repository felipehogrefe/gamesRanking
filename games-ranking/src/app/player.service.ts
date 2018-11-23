import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { Player }  from './player';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'


@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  constructor(private http: Http) { }

  increaseMatches(player: Player): Observable<any>{
    return this.http.put(`http://localhost:8080/player/increaseMatches/${player.id}`,'').pipe(map(response => response.json()))
  }
  increaseVictories(player: Player): Observable<any>{
    return this.http.put(`http://localhost:8080/player/increaseVictories/${player.id}`, '').pipe(map(response => response.json()))
  }

  getPlayerList(): Observable<any>{
    return this.http.get('http://localhost:8080/player/orderedList').pipe(map(response => response.json()));
  }

  createPlayer(player: Player): Observable<any>{
    return this.http.post('http://localhost:8080/player/new',player).pipe(map(response => response.json()));
  }
}

