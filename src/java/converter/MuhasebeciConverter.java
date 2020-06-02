package converter;

import dao.MuhasebeciDAO;
import entity.Muhasebeci;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author gkhnya
 */

@FacesConverter(value = "muhasebeciConverter")
public class MuhasebeciConverter implements Converter {

    private MuhasebeciDAO muhasebeciDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getMuhasebeciDao().muhasebeciIdBul(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Muhasebeci muhasebeci = (Muhasebeci) value;
        return muhasebeci.getMuhasebeciId().toString();
    }

    public MuhasebeciDAO getMuhasebeciDao() {
        if (this.muhasebeciDao == null) {
            this.muhasebeciDao = new MuhasebeciDAO();
        }
        return muhasebeciDao;
    }

}
