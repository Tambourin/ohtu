package laskin;

import javafx.scene.control.TextField;

public class Nollaa extends Komento {

  public Nollaa(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
    super(tuloskentta, syotekentta, sovellus);
  }

  public void suorita() {
    tulosEnnenSuoritusta = sovellus.tulos();
    sovellus.nollaa();
  }

}