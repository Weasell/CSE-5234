package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "controller" })
public class MyWebConfig extends WebMvcConfigurerAdapter  {
	
	//FIXME
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/** ").addResourceLocations("/css/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		}
	
	//FIXME
	 @Bean
	 public InternalResourceViewResolver getInternalResourceViewResolver() {        
		 InternalResourceViewResolver resolver = new InternalResourceViewResolver();        
		 resolver.setPrefix("/WEB-INF/jsp/");        
		 resolver.setSuffix(".jsp");
		 return resolver;   
		 }

}
