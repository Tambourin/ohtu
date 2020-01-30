package ohtu.verkkokauppa;
import java.util.ArrayList;

interface Bookkeeping {
  void lisaaTapahtuma(String tapahtuma) ;
  ArrayList<String> getTapahtumat();
}