package com.mendes.geladaoleao.config.init;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.mendes.geladaoleao.config.WebConfig;

//configurar o DispatcherServlet (primeira requisição que recebemos da web)
public class Appinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?> [] { WebConfig.class};
	}
	/*metodo getServletMappings passando um array do tipo String
	vai definir o padrão da URL que será informado pelo DispatcherServlet*/
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	//CODIGO P/ FORÇAR O UTF-8 NA APLICACAÇÃO
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] {characterEncodingFilter};
	}
	
	
}
