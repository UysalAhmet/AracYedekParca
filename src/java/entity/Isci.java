package entity;

/**
 *
 * @author ahmet
 */

public class Isci {
    private Long isciId;
    private String isciAd;
    private String isciSoyad;
    private String isciTc;
    private Usta usta;

    public Isci() {
    }

    public Isci(Long isciId, String isciAd, String isciSoyad, String isciTc, Usta usta) {
        this.isciId = isciId;
        this.isciAd = isciAd;
        this.isciSoyad = isciSoyad;
        this.isciTc = isciTc;
        this.usta = usta;
    }

    public Long getIsciId() {
        return isciId;
    }

    public void setIsciId(Long isciId) {
        this.isciId = isciId;
    }

    public String getIsciAd() {
        return isciAd;
    }

    public void setIsciAd(String isciAd) {
        this.isciAd = isciAd;
    }

    public String getIsciSoyad() {
        return isciSoyad;
    }

    public void setIsciSoyad(String isciSoyad) {
        this.isciSoyad = isciSoyad;
    }

    public String getIsciTc() {
        return isciTc;
    }

    public void setIsciTc(String isciTc) {
        this.isciTc = isciTc;
    }

    public Usta getUsta() {
        return usta;
    }

    public void setUsta(Usta usta) {
        this.usta = usta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.isciId);
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
        final Isci other = (Isci) obj;
        if (!Objects.equals(this.isciId, other.isciId)) {
            return false;
        }
        return true;
    }
}