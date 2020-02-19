package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPSPeli{

  public KPSTekoaly(Tekoaly tekoaly, IO io) {
    super(tekoaly, io);
  }

  protected void kysyTokaSiirto() {
    tokanSiirto = tekoaly.annaSiirto();
    io.tulosta("Tietokone valitsi: " + tokanSiirto);
    tekoaly.asetaSiirto(ekanSiirto);
  }    
}