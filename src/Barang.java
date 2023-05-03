import java.util.ArrayList;

public class Barang {
  ArrayList<Integer> idMasyarakat = new ArrayList<Integer>();
  ArrayList<String> namaBarang = new ArrayList<String>();
  ArrayList<Integer> hargaAwal = new ArrayList<Integer>();
  ArrayList<Boolean> status = new ArrayList<Boolean>();

  Barang() {
    this.add(0, "Lukisan A", 9_000);
    this.add(1, "Lukisan B", 30_000);
    this.add(2, "Lukisan C", 12_000);
  }

  public int getSize() {
    return namaBarang.size();
  }

  public void remove(int i) {
    this.idMasyarakat.remove(i);
    this.namaBarang.remove(i);
    this.hargaAwal.remove(i);
    this.status.remove(i);
  }

  public void add(int idMasyarakat, String namaBarang, int hargaAwal) {
    this.idMasyarakat.add(idMasyarakat);
    this.namaBarang.add(namaBarang);
    this.hargaAwal.add(hargaAwal);
    this.status.add(true);
  }
}
