package entity;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.muhasebeciId);
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
        final Muhasebeci other = (Muhasebeci) obj;
        if (!Objects.equals(this.muhasebeciId, other.muhasebeciId)) {
            return false;
        }
        return true;
    }
    
}
