package entity;

/**
 *
 * @author gkhnya
 */

public class Muhasebeci {

    private Long muhasebeciId;
    private String muhasebeciAd;
    private String muhasebeciSoyad;
    private String muhasebeciTc;

    public Muhasebeci() {
    }

    public Muhasebeci(Long muhasebeciId, String muhasebeciAd, String muhasebeciSoyad, String muhasebeciTc) {
        this.muhasebeciId = muhasebeciId;
        this.muhasebeciAd = muhasebeciAd;
        this.muhasebeciSoyad = muhasebeciSoyad;
        this.muhasebeciTc = muhasebeciTc;
    }

    public Long getMuhasebeciId() {
        return muhasebeciId;
    }

    public void setMuhasebeciId(Long muhasebeciId) {
        this.muhasebeciId = muhasebeciId;
    }

    public String getMuhasebeciAd() {
        return muhasebeciAd;
    }

    public void setMuhasebeciAd(String muhasebeciAd) {
        this.muhasebeciAd = muhasebeciAd;
    }

    public String getMuhasebeciSoyad() {
        return muhasebeciSoyad;
    }

    public void setMuhasebeciSoyad(String muhasebeciSoyad) {
        this.muhasebeciSoyad = muhasebeciSoyad;
    }

    public String getMuhasebeciTc() {
        return muhasebeciTc;
    }

    public void setMuhasebeciTc(String muhasebeciTc) {
        this.muhasebeciTc = muhasebeciTc;
    }

}
