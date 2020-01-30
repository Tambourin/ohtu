package ohtu.verkkokauppa;

public interface Inventory {
  Tuote haeTuote(int id);
  int saldo(int id);
  void otaVarastosta(Tuote t);
  void palautaVarastoon(Tuote t);
}