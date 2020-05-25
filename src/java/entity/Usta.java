package entity;

/**
 *
 * @author ahmet
 */

public class Usta {
    private Long ustaId;
    private String ustaAd;
    private String ustaSoyad;
    private String ustaTc;

    public Usta() {
    }

    public Usta(Long ustaId, String ustaAd, String ustaSoyad, String ustaTc) {
        this.ustaId = ustaId;
        this.ustaAd = ustaAd;
        this.ustaSoyad = ustaSoyad;
        this.ustaTc = ustaTc;
    }

    public Long getUstaId() {
        return ustaId;
    }

    public void setUstaId(Long ustaId) {
        this.ustaId = ustaId;
    }

    public String getUstaAd() {
        return ustaAd;
    }

    public void setUstaAd(String ustaAd) {
        this.ustaAd = ustaAd;
    }

    public String getUstaSoyad() {
        return ustaSoyad;
    }

    public void setUstaSoyad(String ustaSoyad) {
        this.ustaSoyad = ustaSoyad;
    }

    public String getUstaTc() {
        return ustaTc;
    }

    public void setUstaTc(String ustaTc) {
        this.ustaTc = ustaTc;
    }
    
    
}
