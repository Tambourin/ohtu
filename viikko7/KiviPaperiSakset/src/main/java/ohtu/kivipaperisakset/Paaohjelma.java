package ohtu.kivipaperisakset;

public class Paaohjelma {
    private static final IO io = new IO();   

    public static void main(String[] args) {
      Peli peli = new Peli(io);
      peli.pelaa();       
    }
}
