package com.dropwizard.helloworld.HelloWorld;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class HelloWorldConfiguration extends Configuration {
	@NotNull
    @Valid
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();
	

	@JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }
	
	
	}
	

