package entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author gkhnya
 */

public class Firma {

    private Long firmaId;
    private String firmaAd;
    private String firmaAciklama;
    private List<Siparis> verilenSiparisler;

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

    public List<Siparis> getVerilenSiparisler() {
        return verilenSiparisler;
    }

    public void setVerilenSiparisler(List<Siparis> verilenSiparisler) {
        this.verilenSiparisler = verilenSiparisler;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.firmaId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Firma other = (Firma) obj;
        if (!Objects.equals(this.firmaId, other.firmaId)) {
            return false;
        }
        return true;
    }

}
