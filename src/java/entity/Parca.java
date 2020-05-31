/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author ahmet
 */
public class Parca {
    private Long parcaId;
    private String parcaAd;
    private String parcaHammadde;
    private Makina makina;
    private Long parcaFiyat;

    public Parca() {
    }

    public Parca(Long parcaId, String parcaAd, String parcaHammadde, Makina makina, Long parcaFiyat) {
        this.parcaId = parcaId;
        this.parcaAd = parcaAd;
        this.parcaHammadde = parcaHammadde;
        this.makina = makina;
        this.parcaFiyat = parcaFiyat;
    }

    public Long getParcaId() {
        return parcaId;
    }

    public void setParcaId(Long parcaId) {
        this.parcaId = parcaId;
    }

    public String getParcaAd() {
        return parcaAd;
    }

    public void setParcaAd(String parcaAd) {
        this.parcaAd = parcaAd;
    }

    public String getParcaHammadde() {
        return parcaHammadde;
    }

    public void setParcaHammadde(String parcaHammadde) {
        this.parcaHammadde = parcaHammadde;
    }

    public Makina getMakina() {
        return makina;
    }

    public void setMakina(Makina makina) {
        this.makina = makina;
    }

   

    public Long getParcaFiyat() {
        return parcaFiyat;
    }

    public void setParcaFiyat(Long parcaFiyat) {
        this.parcaFiyat = parcaFiyat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.parcaId);
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
        final Parca other = (Parca) obj;
        if (!Objects.equals(this.parcaId, other.parcaId)) {
            return false;
        }
        return true;
    }
    
    
}
