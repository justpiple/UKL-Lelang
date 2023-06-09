import java.util.ArrayList;

public class Masyarakat implements User {
  private ArrayList<String> nama = new ArrayList<String>();
  private ArrayList<String> alamat = new ArrayList<String>();
  private ArrayList<String> telepon = new ArrayList<String>();

  Masyarakat() {
    this.add("Masyarakat1", "Jl. Situ", "+62888888888");
    this.add("Masyarakat2", "Jl. Situ", "+62888888888");
    this.add("Masyarakat3", "Jl. Situ", "+62888888888");
  }

  @Override
  public int getSize() {
    return nama.size();
  }

  @Override
  public String getNamaByIndex(int i) {
    return nama.get(i);
  }

  @Override
  public String getAlamatByIndex(int i) {
    return alamat.get(i);
  }

  @Override
  public String getTeleponByIndex(int i) {
    return telepon.get(i);
  }

  @Override
  public void add(String nama, String alamat, String telepon) {
    this.nama.add(nama);
    this.alamat.add(alamat);
    this.telepon.add(telepon);
  }

  @Override
  public void remove(int i) {
    this.nama.remove(i);
    this.alamat.remove(i);
    this.telepon.remove(i);
  }
  /*
   * AUTHOR @Kusindra Aji Rabbany
   */
}
