package laskin;

import javafx.scene.control.TextField;


public abstract class Lasku extends Komento {
  public Lasku(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
    super(tuloskentta, syotekentta, sovellus);
  }

  @Override
  public void suorita() {
    tulosEnnenSuoritusta = sovellus.tulos();
    laske();
    super.asetaKentat();    
  }

  protected abstract void laske();

}