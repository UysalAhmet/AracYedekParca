/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.UstaDAO;
import entity.Usta;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author H Cem ERYILMAZ
 */
@FacesConverter(value="ustaConverter")
public class UstaConverter implements Converter {
     private UstaDAO ustaDao;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getUstaDao().ustaIdBul(Long.valueOf(value));
       
      }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Usta usta=(Usta) value;
        return usta.getUstaId().toString();
        }

    public UstaDAO getUstaDao() {
        if(this.ustaDao==null){
            this.ustaDao= new UstaDAO();
        }
        return ustaDao;
    }
}
