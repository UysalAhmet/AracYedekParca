/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.SiparisDAO;
import entity.Siparis;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ahmet
 */
@FacesConverter(value="siparisConverter")
public class SiparisConverter implements Converter{
    private SiparisDAO siparisDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getSiparisDao().siparisIdBul(Long.valueOf(value));
     }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Siparis siparis = (Siparis)value;
        return siparis.getSiparisId().toString();
     }

    public SiparisDAO getSiparisDao() {
        if(this.siparisDao==null){
            this.siparisDao= new SiparisDAO();
        }
        return siparisDao;
    }
    
}
