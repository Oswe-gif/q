package co.edu.unisabana.parcialarquitectura.repository;

public class Database {

  public int savePurchase(int buyerCode, String item) {
    if (buyerCode == 0 || item == null || item.isEmpty()) {
      return 0;
    }
    return 1;
  }
}
