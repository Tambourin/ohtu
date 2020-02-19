package ohtu.kivipaperisakset;

public abstract class KPSPeli {
  protected IO io;
  private Tuomari tuomari;
  protected Tekoaly tekoaly;

  protected String ekanSiirto;
  protected String tokanSiirto;

  protected KPSPeli(Tekoaly tekoaly, IO io) {
    this.tuomari = new Tuomari();
    this.tekoaly = tekoaly;
    this.io = io;
  }

  public static KPSPeli tekoaly(IO io) {
    return new KPSTekoaly(new TekoalyYksinkertainen(), io);
  }

  public static KPSPeli tekoalyMuistava(IO io) {
    return new KPSTekoaly(new TekoalyMuistava(20), io);
  }

  public static KPSPeli kaksinpeli(IO io) {
    return new KPSPelaajaVsPelaaja(null, io);
  }

  public void pelaa() {
    io.tulosta("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
    
    do {      
      kysyEkaSiirto();
      kysyTokaSiirto();      
      paivitaTilanne();
    }
    while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto));
    
    io.tulosta("");;
    io.tulosta("Kiitos!");
    io.tulosta(tuomari.toString());
  }

  private void kysyEkaSiirto() {
    System.out.print("Ensimmäisen pelaajan siirto: ");
    ekanSiirto = io.lue();
  }

  protected abstract void kysyTokaSiirto();

  private void paivitaTilanne() {
    tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
    io.tulosta(tuomari.toString());
    io.tulosta("");
  }

  private static boolean onkoOkSiirto(String siirto) {
    return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
  }

}