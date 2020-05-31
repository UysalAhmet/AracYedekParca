/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import entity.MakinaSorumlusu;
import dao.MakinaSorumlusuDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author yasemin
 */
@FacesConverter(value = "makinaSorumlusuConverter")
public class MakinaSorumlusuConverter implements Converter {

    private MakinaSorumlusuDAO makinaSorumlusuDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getMakinaSorumlusuDao().makinaSorumlusuIdBul(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        MakinaSorumlusu makinaSorumlusu = (MakinaSorumlusu) value;
        return makinaSorumlusu.getMakinasorumlusuId().toString();
    }

    public MakinaSorumlusuDAO getMakinaSorumlusuDao() {
        if (this.makinaSorumlusuDao == null) {
            this.makinaSorumlusuDao = new MakinaSorumlusuDAO();
        }
        return makinaSorumlusuDao;
    }

}
