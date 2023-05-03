import java.util.ArrayList;

public class Lelang {
  ArrayList<Integer> idPenawar = new ArrayList<Integer>();
  ArrayList<Integer> idBarang = new ArrayList<Integer>();
  ArrayList<Integer> hargaTawar = new ArrayList<Integer>();

  public int getSize() {
    return this.idPenawar.size();
  }

  public void add(int idPenawar, int idBarang, int hargaTawar) {
    this.idPenawar.add(idPenawar);
    this.idBarang.add(idBarang);
    this.hargaTawar.add(hargaTawar);
  }
}
