package converter;

import dao.FirmaDAO;
import entity.Firma;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author gkhnya
 */

@FacesConverter(value = "firmaConverter")
public class FirmaConverter implements Converter {

    private FirmaDAO firmaDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getFirmaDao().firmaIdBul(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Firma firma = (Firma) value;
        return firma.getFirmaId().toString();
    }

    public FirmaDAO getFirmaDao() {
        if (this.firmaDao == null) {
            this.firmaDao = new FirmaDAO();
        }
        return firmaDao;
    }

}
