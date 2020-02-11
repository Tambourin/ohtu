package laskin;

import javafx.scene.control.TextField;

public class Plus extends Lasku {
  public Plus(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
    super(tuloskentta, syotekentta, sovellus);
  }

  protected void laske() {
    int arvo = super.haeSyotekentanArvo();
    sovellus.plus(arvo);   
  }

}