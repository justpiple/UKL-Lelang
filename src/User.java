import java.util.ArrayList;

public interface User {
  ArrayList<String> nama = new ArrayList<String>();
  ArrayList<String> alamat = new ArrayList<String>();
  ArrayList<String> telepon = new ArrayList<String>();

  public int getSize();

  public String getNamaByIndex(int i);

  public String getAlamatByIndex(int i);

  public String getTeleponByIndex(int i);

  public void add(String nama, String alamat, String telepon);

  public void remove(int i);
  /*
   * AUTHOR @Kusindra Aji Rabbany
   */
}
