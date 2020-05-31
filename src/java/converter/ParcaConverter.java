/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.ParcaDAO;
import entity.Parca;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ahmet
 */
@FacesConverter(value="parcaConverter")
public class ParcaConverter implements Converter{
    private ParcaDAO parcaDao;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getParcaDao().parcaIdBul(Long.valueOf(value));
     }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Parca parca = (Parca) value;
        return parca.getParcaId().toString();
    }

    public ParcaDAO getParcaDao() {
        if(this.parcaDao==null){
            this.parcaDao=new ParcaDAO();
        }
        return parcaDao;
    }
    
}
