package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
  TextField tuloskentta;
  TextField syotekentta;
  Sovelluslogiikka sovellus;
  protected int tulosEnnenSuoritusta;
  
  public Komento(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
    this.tuloskentta = tuloskentta;
    this.syotekentta = syotekentta;
    this.sovellus = sovellus;
  }

  protected int haeSyotekentanArvo() {
    int arvo = 0;
    try {
        arvo = Integer.parseInt(syotekentta.getText());
    } catch (Exception e) {
    }
    return arvo; 
  }

  protected void asetaKentat(){
    tuloskentta.setText(Integer.toString(sovellus.tulos()));
    syotekentta.setText("");
  }

  public void peru() {
    sovellus.setTulos(tulosEnnenSuoritusta);
    asetaKentat();
  };

  public abstract void suorita();
}