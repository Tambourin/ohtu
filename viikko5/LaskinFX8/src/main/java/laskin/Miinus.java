package laskin;

import javafx.scene.control.TextField;

public class Miinus extends Lasku {

  public Miinus(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
    super(tuloskentta, syotekentta, sovellus);
  }

  public void laske() {
    int arvo = super.haeSyotekentanArvo();
    sovellus.miinus(arvo);
  }
}