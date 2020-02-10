
package ohtu.intjoukkosovellus;

public class JoukkoOperaatio {
    public static IntJoukko yhdistaJoukot(IntJoukko a, IntJoukko b) {
        IntJoukko uusiJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            uusiJoukko.lisaaLuku(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            uusiJoukko.lisaaLuku(bTaulu[i]);
        }
        return uusiJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko uusiJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    uusiJoukko.lisaaLuku(bTaulu[j]);
                }
            }
        }
        return uusiJoukko;

    }

    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaaLuku(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poistaLuku
            (bTaulu[i]);
        }

        return z;
    }
}