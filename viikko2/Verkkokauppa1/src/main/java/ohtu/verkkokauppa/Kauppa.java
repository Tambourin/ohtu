package ohtu.verkkokauppa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {

    private Inventory  varasto;
    private Bank pankki;
    private Ostoskori ostoskori;
    private Reference viitegeneraattori;
    private String kaupanTili;

    /*public Kauppa() {
        varasto = Varasto.getInstance();
        pankki = Pankki.getInstance();
        viitegeneraattori = Viitegeneraattori.getInstance();
        kaupanTili = "33333-44455";
    }*/
    @Autowired
    public Kauppa(Inventory varasto, Bank pankki, Reference viitegeneraattori) {
      this.varasto = varasto;
      this.pankki = pankki;
      this.viitegeneraattori = viitegeneraattori;
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
