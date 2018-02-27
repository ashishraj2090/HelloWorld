package com.dropwizard.helloworld.HelloWorld;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloGreeting {

	@JsonProperty
  private String greeting;


  
  public HelloGreeting(String greeting) {
	  this.greeting=greeting;
  }



public String getGreeting() {
	return greeting;
}
}
