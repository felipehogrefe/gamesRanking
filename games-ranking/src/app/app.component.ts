import { Component } from '@angular/core';
import { Player } from './player';
import { PlayerService } from './player.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedPlayer: Player;
  title = 'Games Ranking';
  haveSelected = false;
  serverReachable = true;

  public players: Player[];

  constructor(private playerService: PlayerService) { }

  ngOnInit() {
    this.refreshPlayersList();
  }

  private reSelectPlayer() {
    for (let p of this.players) {
      if (this.haveSelected) {
        if (p.id === this.selectedPlayer.id) {
          this.selectedPlayer = p;
        }
      }
    }
  }

  private refreshPlayersList() {
    this.playerService.getPlayerList().subscribe(
      players => {
        this.players = players
        this.reSelectPlayer();
      }, error => {        
        this.regError(error);
      }
    );
  }
  regError(error: Error): any {
    this.serverReachable = false;
    console.error('Error: ' + error);
    throw new Error(error.message);
  }

  onSelect(player: Player): void {
    this.haveSelected = true;
    this.selectedPlayer = player;
  }

  public createPlayer(_name: string, _victories: number, _matches: number) {
    if (_name.trim().length != 0 && _victories.toString().trim().length != 0 && _matches.toString().trim().length != 0) {
      this.playerService.createPlayer(new Player(this.players.length + 1, _name, _victories, _matches)).subscribe(response => {
        if (response === "CREATED") {
          this.refreshPlayersList();
        } else {
          //show error component
        }
      }, error => {        
        this.regError(error);
      })
    }
  }

  public increaseVictories() {
    this.playerService.increaseVictories(this.selectedPlayer).subscribe(response => {
      if (response === "OK") {
        this.selectedPlayer.victories++;
        this.selectedPlayer.matches++;
      }
    }, error => {        
      this.regError(error);
    })
  }

  public increaseMatches() {
    this.playerService.increaseMatches(this.selectedPlayer).subscribe(response => {
      if (response === "OK") {
        this.selectedPlayer.matches++;
      }
    }, error => {        
      this.regError(error);
    })
  }
}
