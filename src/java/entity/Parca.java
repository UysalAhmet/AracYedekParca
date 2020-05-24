package entity;

/**
 *
 * @author H Cem ERYILMAZ
 */

public class Parca {
     private Long parcaId;
    private String parcaAd;
    private String parcaHammadde;
    private Makina makina;
    private Long parcaFiyat;

    public Parca() {
    }

    public Parca(Long parcaId, String parcaAd, String parcaHammadde, Makina makinaId, Long parcaFiyat) {
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
    
}
