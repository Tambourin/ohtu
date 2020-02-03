package ohtu;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerList {
  private List<Player> players;


  PlayerList(Player[] players) {
    this.players = new ArrayList<Player>(Arrays.asList(players));  
  }

  public List<Player> getPlayerList() {
    return this.players;
  }

  public List<Player> getByNationality(String nationality) {
    return players
      .stream()
      .filter(player -> player.getNationality().equals(nationality))
      .sorted(Comparator.comparingInt(Player::getPoints).reversed())
      .collect(Collectors.toList());
  }
  
}