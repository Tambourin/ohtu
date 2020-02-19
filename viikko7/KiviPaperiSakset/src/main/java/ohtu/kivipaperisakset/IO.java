package ohtu.kivipaperisakset;

import java.util.Scanner;

public class IO {
  private static final Scanner scanner = new Scanner(System.in);

  public String lue() {
    String syote = scanner.nextLine();
    return syote;
  }

  public void tulosta(String string) {
    System.out.println(string);
  }
}