package com.mendes.geladaoleao.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.mendes.geladaoleao.controller.CervejasController;

@Configuration // pra definir como classe de configuraçao
@ComponentScan(basePackageClasses = { CervejasController.class }) // componente scan para encontrar as classes
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
	//
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		this.applicationContext = applicationContext;
	}
	
	
	/* Configurando a VIEW pra encontrar
	 * as paginas HTML e processar os objetos
	 * */
	
	@Bean
	public ViewResolver viewResolver() {
		
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		//vai utilizar o template engine pra "resolver" kk
		resolver.setTemplateEngine(templateEngine());
		//setando encoding como UTF-8 pra n ter problema com os acentos e etc
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}
	
	@Bean
	public TemplateEngine templateEngine() {
		
		SpringTemplateEngine engine = new SpringTemplateEngine ();
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());
		
		return engine;
	}
	private ITemplateResolver templateResolver() {
		//SpringResourceTemplateResolver usado para resolver Templates 
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		//
		resolver.setApplicationContext(applicationContext);
		//usando o obj resolver e chamando o setPrefix
		//pra definir onde vai ser achado, no caso na pasta templates dentro do src/main/resources
		resolver.setPrefix("classpath:/templates/");
		//definindo o modo do template, nesse caso HTML
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		//
		return resolver;
	}
	
	//configurando o bootstrap: //
	/* utilizando o mvc (spring), podemos usar o método 'addResourceHandlers' do webmvcconfigureadapter
	 * que vai basicamente informar onde vai ser chamado o "bootstrap" ou seja os recursos
	 * nesse caso informei no 'addResourceHandler' > "/**"
	 * e no 'addResourceLocations' passei o "classpath" (src/main/resources) a pasta static
	 * ou seja, ele vai buscar os recursos staticos na classpath static (aula 5.3)
	 *  */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
}
