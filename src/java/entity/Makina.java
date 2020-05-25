package entity;

/**
 *
 * @author yasemin
 */

public class Makina {
    private Long makinaId;
    private String makinaMarka;
    private String makinaTur;
    private Isci isci;
    private MakinaSorumlusu makinasorumlusu;

    public Makina() {
    }

    public Makina(Long makinaId, String makinaMarka, String makinaTur, Isci isci, MakinaSorumlusu makinasorumlusu) {
        this.makinaId = makinaId;
        this.makinaMarka = makinaMarka;
        this.makinaTur = makinaTur;
        this.isci = isci;
        this.makinasorumlusu = makinasorumlusu;
    }

    public Long getMakinaId() {
        return makinaId;
    }

    public void setMakinaId(Long makinaId) {
        this.makinaId = makinaId;
    }

    public String getMakinaMarka() {
        return makinaMarka;
    }

    public void setMakinaMarka(String makinaMarka) {
        this.makinaMarka = makinaMarka;
    }

    public String getMakinaTur() {
        return makinaTur;
    }

    public void setMakinaTur(String makinaTur) {
        this.makinaTur = makinaTur;
    }

    public Isci getIsci() {
        return isci;
    }

    public void setIsci(Isci isci) {
        this.isci = isci;
    }

    public MakinaSorumlusu getMakinasorumlusu() {
        return makinasorumlusu;
    }

    public void setMakinasorumlusu(MakinaSorumlusu makinasorumlusu) {
        this.makinasorumlusu = makinasorumlusu;
    }


    

}
