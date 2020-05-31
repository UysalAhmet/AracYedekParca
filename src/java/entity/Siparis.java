/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author ahmet
 */
public class Siparis {
    private Long siparisId;
    private String siparisKod;
    private Long siparisParcaSayi;
    private Parca parca;
    private Muhasebeci muhasebeci;
    private List<Firma> siparisVerenFirmalar;

    public Siparis() {
    }

    public Siparis(Long siparisId, String siparisKod, Long siparisParcaSayi, Parca parca, Muhasebeci muhasebeci) {
        this.siparisId = siparisId;
        this.siparisKod = siparisKod;
        this.siparisParcaSayi = siparisParcaSayi;
        this.parca = parca;
        this.muhasebeci = muhasebeci;
    }


    public Long getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(Long siparisId) {
        this.siparisId = siparisId;
    }

    public String getSiparisKod() {
        return siparisKod;
    }

    public void setSiparisKod(String siparisKod) {
        this.siparisKod = siparisKod;
    }

    public Long getSiparisParcaSayi() {
        return siparisParcaSayi;
    }

    public void setSiparisParcaSayi(Long siparisParcaSayi) {
        this.siparisParcaSayi = siparisParcaSayi;
    }

    public Parca getParca() {
        return parca;
    }

    public void setParca(Parca parca) {
        this.parca = parca;
    }

    public Muhasebeci getMuhasebeci() {
        return muhasebeci;
    }

    public void setMuhasebeci(Muhasebeci muhasebeci) {
        this.muhasebeci = muhasebeci;
    }

    public List<Firma> getSiparisVerenFirmalar() {
        return siparisVerenFirmalar;
    }

    public void setSiparisVerenFirmalar(List<Firma> siparisVerenFirmalar) {
        this.siparisVerenFirmalar = siparisVerenFirmalar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.siparisId);
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
        final Siparis other = (Siparis) obj;
        if (!Objects.equals(this.siparisId, other.siparisId)) {
            return false;
        }
        return true;
    }

    
}
