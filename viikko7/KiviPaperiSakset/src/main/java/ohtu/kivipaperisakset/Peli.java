package ohtu.kivipaperisakset;

public class Peli {
  private IO io;

  public Peli(IO io) {
    this.io = io;
  }

  public void pelaa() {
    while (true) {
      io.tulosta("\nValitse pelataanko"
              + "\n (a) ihmistä vastaan "
              + "\n (b) tekoälyä vastaan"
              + "\n (c) parannettua tekoälyä vastaan"
              + "\nmuilla valinnoilla lopetataan");

      String vastaus = io.lue();
      if (vastaus.endsWith("a")) {
          KPSPeli.kaksinpeli(io).pelaa();
      } else if (vastaus.endsWith("b")) {
          KPSPeli.tekoaly(io).pelaa();
      } else if (vastaus.endsWith("c")) {
          KPSPeli.tekoalyMuistava(io).pelaa();
      } else {
          break;
      }
    }
  }
}