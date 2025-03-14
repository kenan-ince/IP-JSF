package converter;

import DAO.CategoryDAO;
import entity.Category;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@FacesConverter(forClass=Category.class, managed = true)
public class CategoryConverter implements Converter{
	
	
	private CategoryDAO dao;

	public CategoryConverter() throws NamingException {
		this.dao = (CategoryDAO) new InitialContext().lookup("java:global/CourseJSF/CategoryDAO");
	}


	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		int id = Integer.parseInt(string);
		Category c = dao.findById(id);
		return c;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object t) {
		Category c = (Category) t;
		return c.getId().toString();
	}

//	public CategoryDAO getDao() {
//		if ( this.dao == null ) {
//			this.dao = new CategoryDAO();
//		}
//		return dao;
//	}
	
}
