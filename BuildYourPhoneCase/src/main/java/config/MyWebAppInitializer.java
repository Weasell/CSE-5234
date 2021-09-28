package config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	//FIXME
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return null; 
	}
	//FIXME
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] { MyWebConfig.class };
	}
	
	
	@Override
	protected String[] getServletMappings() {
		
		return new String[] { "/" };
	}
}
