/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;
import dao.IsciDAO;
import entity.Isci;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author H Cem ERYILMAZ
 */
@FacesConverter(value = "isciConverter")
public class IsciConverter implements Converter {

    private IsciDAO isciDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
return this.getIsciDao().isciIdBul(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
   
        Isci isci =(Isci) value;
        return isci.getIsciId().toString();
    
    }

    public IsciDAO getIsciDao() {
        if(this.isciDao==null){
            this.isciDao= new IsciDAO();
        }
        return isciDao;
    }

}
