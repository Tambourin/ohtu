package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KPSPeli{

  public KPSPelaajaVsPelaaja(Tekoaly tekoaly, IO io) {
    super(tekoaly, io);
  }

  protected void kysyTokaSiirto() {
    io.tulosta("Toisen pelaajan siirto: ");
    tokanSiirto = io.lue();
  }
}