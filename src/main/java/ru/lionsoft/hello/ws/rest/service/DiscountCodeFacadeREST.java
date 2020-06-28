/*
 * File:    DiscountCodeFacadeREST.java
 * Project: HelloREST
 * Date:    28 июн. 2020 г. 11:14:37
 * Author:  Igor Morenko <morenko@lionsoft.ru>
 * 
 * Copyright 2005-2020 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.hello.ws.rest.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.lionsoft.hello.ws.rest.entity.DiscountCode;

/**
 * Rest Web Service for entity {@code DiscountCode}
 * @author Igor Morenko
 */
@Stateless
@Path("discountCode")
public class DiscountCodeFacadeREST extends AbstractFacade<DiscountCode> {

    @PersistenceContext(unitName = "SamplePU")
    private EntityManager em;

    public DiscountCodeFacadeREST() {
        super(DiscountCode.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(DiscountCode entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, DiscountCode entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DiscountCode find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Path("{id}/customers")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getCustomers(@PathParam("id") String id) {
        DiscountCode discountCode = super.find(id);
        if (discountCode == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        else 
            return Response.ok(discountCode.getCustomers()).build();
    }

    @GET
    @Path("{id}/productCodes")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getProductCodes(@PathParam("id") String id) {
        DiscountCode discountCode = super.find(id);
        if (discountCode == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        else 
            return Response.ok(discountCode.getProductCodes()).build();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DiscountCode> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DiscountCode> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
