/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.MakinaDAO;
import entity.Makina;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author yasemin
 */
@FacesConverter(value="makinaConverter")
public class MakinaConverter implements Converter {
  private MakinaDAO makinaDao;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getMakinaDao().makinaIdBul(Long.valueOf(value));
     }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Makina makina =(Makina)value;
        return makina.getMakinaId().toString();
     }

    public MakinaDAO getMakinaDao() {
        if(this.makinaDao==null){
            this.makinaDao= new MakinaDAO();
        }
        return makinaDao;
    }
  
}
