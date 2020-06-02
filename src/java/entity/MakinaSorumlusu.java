package entity;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.makinasorumlusuId);
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
        final MakinaSorumlusu other = (MakinaSorumlusu) obj;
        if (!Objects.equals(this.makinasorumlusuId, other.makinasorumlusuId)) {
            return false;
        }
        return true;
    }
    
    

}
