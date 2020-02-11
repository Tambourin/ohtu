package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tapahtumankuuntelija implements EventHandler {
  private Button undo;
  private Button plus;
  private Button miinus;
  private Button nollaa;
  private Sovelluslogiikka sovellus;
  TextField tuloskentta; 
  TextField syotekentta;
  
  private ArrayList<Komento> edelliset = new ArrayList<>();

  public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
      this.undo = undo;
      this.plus = plus;
      this.miinus = miinus;
      this.nollaa = nollaa;
      this.syotekentta = syotekentta;
      this.tuloskentta = tuloskentta;
      this.sovellus = new Sovelluslogiikka();
}  

  private Komento valitseKomento(Button button) {
      Map<Button, Komento> komennot = new HashMap<>();
      komennot.put(plus, new Plus(tuloskentta, syotekentta, sovellus) );
      komennot.put(miinus, new Miinus(tuloskentta, syotekentta, sovellus) );
      komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, sovellus) );
      return komennot.get(button);
  }

  @Override
  public void handle(Event event) {      
      if ( event.getTarget() != undo ) {
          Komento komento = valitseKomento((Button)event.getTarget());
          komento.suorita();
          undo.disableProperty().set(false);
          edelliset.add(komento);
      } else {
          Komento edellinen = edelliset.get(edelliset.size() - 1); 
          edellinen.peru();
          edelliset.remove(edelliset.size() - 1);
          if(edelliset.size() == 0) {
            undo.disableProperty().set(true);
          }          
      }                  
  }

}
