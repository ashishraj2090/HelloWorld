package com.dropwizard.helloworld.HelloWorld;



import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dropwizard.helloworld.health.DemoHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class HelloWorldApplication extends Application<HelloWorldConfiguration>{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldApplication.class);
	
	public static final String LOGGER_STRING = "class=\"{}\" method=\"{}\" message=\"{}\"";

	/** The Constant METHOD_STARTS. */
	public static final String METHOD_START = "Method Start";

	/** The Constant METHOD_EXIT. */
	public static final String METHOD_EXIT = "Method Exit";
	
	/** The Constant METHOD_EXIT. */
	public static final String TOKEN = "token";
	
	
	private final HibernateBundle<HelloWorldConfiguration> hibernateBundle = new HibernateBundle<HelloWorldConfiguration> (Employee.class){
	
		 @Override
         public DataSourceFactory getDataSourceFactory (HelloWorldConfiguration configuration ) {
             return configuration.getDataSourceFactory();
         }
     };

    public static void main( String[] args ) throws Exception {
    	System.out.println("Hello World Application");
    	System.out.println(LOGGER);
  LOGGER.info("this is my logger");
   
    //System.out.println(LOGGER);
    	
    	new HelloWorldApplication().run(args);
    	   
    }
    
    @Override
    public void initialize (final Bootstrap<HelloWorldConfiguration> bootstrap) { 
    	bootstrap.addBundle(hibernateBundle);
    }
    

	@Override
	public void run (final HelloWorldConfiguration conf,final Environment envr) throws Exception {
	
		 final EmployeeDAO employeeDAO = new EmployeeDAO(hibernateBundle.getSessionFactory());
		    
		envr.jersey().register(new HelloResource());
		envr.jersey().register(new EmployeeResource(employeeDAO));
		
	}
}
