package entity;

/**
 *
 * @author gkhnya
 */

public class Firma {

    private Long firmaId;
    private String firmaAd;
    private String firmaAciklama;

    public Firma() {
    }

    public Firma(Long firmaId, String firmaAd, String firmaAciklama) {
        this.firmaId = firmaId;
        this.firmaAd = firmaAd;
        this.firmaAciklama = firmaAciklama;
    }

    public Long getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Long firmaId) {
        this.firmaId = firmaId;
    }

    public String getFirmaAd() {
        return firmaAd;
    }

    public void setFirmaAd(String firmaAd) {
        this.firmaAd = firmaAd;
    }

    public String getFirmaAciklama() {
        return firmaAciklama;
    }

    public void setFirmaAciklama(String firmaAciklama) {
        this.firmaAciklama = firmaAciklama;
    }

}
