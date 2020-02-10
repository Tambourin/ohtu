
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 
   
    public IntJoukko() {
        this(OLETUSKAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS); 
    }        

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaaLuku(int luku) {        
        if (loytyyJoukosta(luku)) {
            return false;
        }        
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm % ljono.length == 0) {
            kasvataJoukkoa();
        }
        return true;
    }

    private void kasvataJoukkoa() {
        int[] taulukkoOld = new int[ljono.length];
        kopioiTaulukko(ljono, taulukkoOld);
        ljono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, ljono);
    }

    public boolean loytyyJoukosta(int luku) {
        if (haeLuvunIndeksi(luku) == -1) {
            return false;
        } 
        return true;
    }

    private int haeLuvunIndeksi(int luku) {
        int luvunIndeksi = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                luvunIndeksi = i;
                break;
            }
        }
        return luvunIndeksi;
    }

    public boolean poistaLuku(int luku) {
        int luvunIndeksi = haeLuvunIndeksi(luku); 
        if (luvunIndeksi == -1) {
            return false;
        }   
        siirraTalukononAlkiot(luvunIndeksi);
        alkioidenLkm--;
        return true;
    }

    private void siirraTalukononAlkiot(int kohta) {
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = ljono[j];
            ljono[j] = ljono[j + 1];
            ljono[j + 1] = apu;
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }
    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += ljono[i];
                tuotos += ", ";
            }
            tuotos += ljono[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
}
