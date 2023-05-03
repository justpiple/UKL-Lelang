import java.util.Scanner;

public class Aplikasi {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Petugas petugas = new Petugas();
    Masyarakat masyarakat = new Masyarakat();
    Barang barang = new Barang();
    Lelang lelang = new Lelang();

    pilihMenu(in, petugas, masyarakat, barang, lelang);
  }

  public static void pilihMenu(Scanner in, Petugas petugas, Masyarakat masyarakat, Barang barang, Lelang lelang) {
    String role = null;
    int menu = 0, akun = -1;

    do {
      if (menu == 98) {
        System.out.println("Logout success!");
        role = null;
        menu = 0;
        akun = -1;
      }
      if (role == null) {
        System.out.println("Selamat datang di Aplikasi Lelang");
        System.out.print("Login sebagai: (petugas/masyarakat): ");
        role = in.nextLine();

        while (!role.equalsIgnoreCase("petugas") && !role.equalsIgnoreCase("masyarakat")) {
          System.out.println("Tidak ada dalam pilihan!");
          System.out.print("Login sebagai: (petugas/masyarakat): ");
          role = in.nextLine();
        }
      } else if (role.equalsIgnoreCase("petugas")) {
        if (akun == -1) {
          for (int i = 0; i < petugas.getSize(); i++) {
            System.out.println(i + 1 + ". " + petugas.getNamaByIndex(i));
          }
          System.out.println("Masuk dengan akun petugas: ");
          akun = in.nextInt() - 1;
          in.nextLine();
        }
        menu = menuPetugas(menu, in, akun, petugas);
        switch (menu) {
          case 1:
            addBarang(in, barang);
            menu = 0;
            break;
          case 2:
            removeBarang(in, barang);
            menu = 0;
            break;
          case 3:
            tampilBarang(barang, masyarakat);
            menu = 0;
            break;
          case 4:
            tampilLelang(lelang, masyarakat, barang);
            menu = 0;
            break;
          case 5:
            tampilMasyarakat(masyarakat);
            menu = 0;
            break;
        }
      } else if (role.equalsIgnoreCase("masyarakat")) {
        menu = menuMasyarakat(menu, in);
        switch (menu) {
          case 1:
            lelangMasyarakat(in, barang, lelang, masyarakat);
            menu = 0;
            break;
          case 2:
            tampilBarang(barang, masyarakat);
            menu = 0;
            break;
        }
      }
    } while (menu != 99);
  }

  public static int menuMasyarakat(int menu, Scanner in) {
    if (menu == 0) {
      System.out.println("Halo selamat datang");
      System.out.println("=====Menu=====");
      System.out.println("1. Lelang");
      System.out.println("2. List Barang");
      System.out.println("98. Logout");
      System.out.println("99. Keluar aplikasi");
      System.out.println("==============");
      System.out.print("Pilih Menu: ");
      menu = in.nextInt();
      in.nextLine();
    }
    return menu;
  }

  public static int menuPetugas(int menu, Scanner in, int idAkun, Petugas petugas) {
    if (menu == 0) {
      System.out.println("=====Menu=====");
      System.out.println("1. Tambah Barang");
      System.out.println("2. Hapus Barang");
      System.out.println("3. List Barang");
      System.out.println("4. List Lelang");
      System.out.println("5. List Masyarakat");
      System.out.println("98. Logout");
      System.out.println("99. Keluar aplikasi");
      System.out.println("==============");
      System.out.print("Pilih Menu: ");
      menu = in.nextInt();
      in.nextLine();
    }
    return menu;
  }

  public static void lelangMasyarakat(Scanner in, Barang barang, Lelang lelang, Masyarakat masyarakat) {
    System.out.println("=====Lelang barang=====");
    tampilBarang(barang, masyarakat);
    System.out.print("Masukkan ID barang: ");
    int tempIdBarang = in.nextInt() - 1;
    if (!barang.status.get(tempIdBarang)) {
      System.out.println("Barang sudah di lelang.");
    } else {
      int hargaAwal = barang.hargaAwal.get(tempIdBarang);
      int idPemenang = -1;
      int tempHT = 0;

      for (int i = 0; i < masyarakat.getSize(); i++) {
        System.out.println("===== User" + (i + 1) + " =====");
        int tempTawar = hargaAwal + 1;
        do {
          if (tempTawar < hargaAwal)
            System.out.println("Harga tawar tidak boleh lebih murah!");
          System.out.print("Masukkan harga tawar: ");
          tempTawar = in.nextInt();
        } while (tempTawar < hargaAwal);
        lelang.add(i, tempIdBarang, tempTawar);
        if (tempTawar > tempHT) {
          tempHT = tempTawar;
          idPemenang = i;
        }
      }
      System.out.println("Pemenang tawar adalah: " + masyarakat.getNamaByIndex(idPemenang));
      System.out.println("Dengan harga tawar: " + tempHT);
      barang.status.set(tempIdBarang, false);
    }

  }

  public static void addBarang(Scanner in, Barang barang) {
    String tempName;
    int tempHarga, tempPemilik;
    System.out.println("=====Tambah barang=====");
    System.out.print("Nama barang: ");
    tempName = in.nextLine();
    System.out.print("Id pemilik barang: ");
    tempPemilik = in.nextInt();
    System.out.print("Harga barang: ");
    tempHarga = in.nextInt();
    barang.add(tempPemilik, tempName, tempHarga);
  }

  public static void removeBarang(Scanner in, Barang barang) {
    System.out.println("=====Hapus barang=====");
    System.out.print("Id barang: ");
    barang.remove(in.nextInt() - 1);
  }

  public static void tampilBarang(Barang barang, Masyarakat masyarakat) {
    for (int i = 0; i < barang.getSize(); i++) {
      System.out.println("=====Barang " + (i + 1) + "====");
      System.out.println("Nama Barang: " + barang.namaBarang.get(i));
      System.out.println("Pemilik: " + masyarakat.getNamaByIndex(barang.idMasyarakat.get(i)));
      System.out.println("Harga Awal: " + barang.hargaAwal.get(i));
      System.out.println("Status: " + (barang.status.get(i) ? "Ada" : "Tidak ada"));
      System.out.println("====================");
    }
  }

  public static void tampilMasyarakat(Masyarakat masyarakat) {
    for (int i = 0; i < masyarakat.getSize(); i++) {
      System.out.println("=====Masyarakat " + (i + 1) + "====");
      System.out.println("Nama: " + masyarakat.getNamaByIndex(i));
      System.out.println("Alamat: " + masyarakat.getAlamatByIndex(i));
      System.out.println("Telpon: " + masyarakat.getTeleponByIndex(i));
      System.out.println("====================");
    }
  }

  public static void tampilLelang(Lelang lelang, Masyarakat masyarakat, Barang barang) {
    for (int i = 0; i < lelang.getSize(); i++) {
      System.out.println("=====Lelang " + (i + 1) + "====");
      System.out.println("Nama Penawar: " + masyarakat.getNamaByIndex(lelang.idPenawar.get(i)));
      System.out.println("Nama Barang: " + barang.namaBarang.get(lelang.idBarang.get(i)));
      System.out.println("Harga Awal: " + barang.hargaAwal.get(lelang.idBarang.get(i)));
      System.out.println("Harga Tawar: " + lelang.hargaTawar.get(i));
      System.out.println("====================");
    }
  }

}