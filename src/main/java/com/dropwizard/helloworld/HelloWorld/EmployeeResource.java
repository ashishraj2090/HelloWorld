package com.dropwizard.helloworld.HelloWorld;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;



@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {


	
    /**
     * The DAO object to manipulate employees.
     */
    private EmployeeDAO employeeDAO;

    /**
     * Constructor.
     *
     * @param employeeDAO DAO object to manipulate employees.
     */
    public EmployeeResource(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

   
	/**
     * Looks for employees whose first or last name contains the passed
     * parameter as a substring. If name argument was not passed, returns all
     * employees stored in the database.
     *
     * @param name query parameter
     * @return list of employees whose first or last name contains the passed
     * parameter as a substring or list of all employees stored in the database.
     */
    @GET
    @Path("{name}")
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Employee> findByName(
    	
            @QueryParam("name") Optional<String> name
    ) {
        if (name.isPresent()) {
            return employeeDAO.findByName(name.get());
        } else {
            return employeeDAO.findAll();
        }
    }

    /**
     * Method looks for an employee by her id.
     *
     * @param id the id of an employee we are looking for.
     * @return Optional containing the found employee or an empty Optional
     * otherwise.
     */
    @GET
    @Path("/{id}")
    @UnitOfWork
    public jersey.repackaged.com.google.common.base.Optional<Employee> findById(@PathParam("id") LongParam id) {
        return employeeDAO.findById(id.get());
    }
}