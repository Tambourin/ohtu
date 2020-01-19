package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
  Reader readerStub = new Reader() {
 
    public List<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player("Semenko", "EDM", 4, 12));
        players.add(new Player("Lemieux", "PIT", 45, 54));
        players.add(new Player("Kurri",   "EDM", 37, 53));
        players.add(new Player("Yzerman", "DET", 42, 56));
        players.add(new Player("Gretzky", "EDM", 35, 89));

        return players;
    }
};

  Statistics stats;

  @Before
  public void alustus() {
    this.stats = new Statistics(readerStub);
  }

  @Test
  public void topScorersPalauttaaOikeakokoisenListan() {
    List<Player> pelaajat = stats.topScorers(3);    
    assertEquals(4, pelaajat.size());
  }

  @Test
  public void teamPalauttaaListanPelaajista() {
    List<Player> joukkueenPelaajat = stats.team("EDM");
    assertEquals(3, joukkueenPelaajat.size());
  }

  @Test
  public void pelaajaLoytyy() {
    Player pelaaja = stats.search("Semenko");
    assertEquals("Semenko", pelaaja.getName());
  }

  @Test
  public void pelaajaaEiLoydy() {
    
    assertEquals(null, stats.search("name"));
  }

}