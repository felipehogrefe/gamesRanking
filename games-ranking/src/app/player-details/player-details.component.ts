import { Component, OnInit, Input } from '@angular/core';
import { Player } from '../player';
import { PlayerService } from '../player.service';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-player-details',
  templateUrl: './player-details.component.html',
  styleUrls: ['./player-details.component.css']
})
export class PlayerDetailsComponent implements OnInit {  
  @Input() selectedPlayer: Player;

  constructor(private playerService: PlayerService) { }

  ngOnInit() {
  }

  setSelectedPlayer(player: Player){
    this.selectedPlayer=player;
  }

  public increaseVictories() {
    this.playerService.increaseVictories(this.selectedPlayer).subscribe(response => {
      console.log(response);
      if (response === "OK") {
        this.selectedPlayer.victories++;
        this.selectedPlayer.matches++;
      }
    })
  }

  public increaseMatches() {
    this.playerService.increaseMatches(this.selectedPlayer).subscribe(response => {
      console.log(response);
      if (response === "OK") {
        this.selectedPlayer.matches++;
      }
    })
  }

}
