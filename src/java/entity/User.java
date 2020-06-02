package entity;

/**
 *
 * @author ahmet
 */

public class User {

    private String kullaniciAd;
    private String sifre;

    @Override
    public String toString() {
        return "User{" + "kullaniciAd=" + kullaniciAd + ", sifre=" + sifre + '}';
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

}
