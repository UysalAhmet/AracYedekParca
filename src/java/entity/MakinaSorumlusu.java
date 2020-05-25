/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author yasemin
 */
public class MakinaSorumlusu {
    
    private Long makinasorumlusuId;
    private String makinasorumlusuAd;
    private String makinasorumlusuSoyad;
    private String makinasorumlusuTc;

    public MakinaSorumlusu() {
    }

    public MakinaSorumlusu(Long makinasorumlusuId, String makinasorumlusuAd, String makinasorumlusuSoyad, String makinasorumlusuTc) {
        this.makinasorumlusuId = makinasorumlusuId;
        this.makinasorumlusuAd = makinasorumlusuAd;
        this.makinasorumlusuSoyad = makinasorumlusuSoyad;
        this.makinasorumlusuTc = makinasorumlusuTc;
    }

    public Long getMakinasorumlusuId() {
        return makinasorumlusuId;
    }

    public void setMakinasorumlusuId(Long makinasorumlusuId) {
        this.makinasorumlusuId = makinasorumlusuId;
    }

    public String getMakinasorumlusuAd() {
        return makinasorumlusuAd;
    }

    public void setMakinasorumlusuAd(String makinasorumlusuAd) {
        this.makinasorumlusuAd = makinasorumlusuAd;
    }

    public String getMakinasorumlusuSoyad() {
        return makinasorumlusuSoyad;
    }

    public void setMakinasorumlusuSoyad(String makinasorumlusuSoyad) {
        this.makinasorumlusuSoyad = makinasorumlusuSoyad;
    }

    public String getMakinasorumlusuTc() {
        return makinasorumlusuTc;
    }

    public void setMakinasorumlusuTc(String makinasorumlusuTc) {
        this.makinasorumlusuTc = makinasorumlusuTc;
    }

}
