/*
 * File:    ApplicationConfig.java
 * Project: HelloREST
 * Date:    28 июн. 2020 г. 11:14:37
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2020 LionSoft LLC. All rights reserved.
 */

package ru.lionsoft.hello.ws.rest.service;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@ApplicationScoped
@ApplicationPath("/api")
//@DeclareRoles("USER")
//@BasicAuthenticationMechanismDefinition(realmName = "file")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ru.lionsoft.hello.ws.rest.service.CustomerFacadeREST.class);
        resources.add(ru.lionsoft.hello.ws.rest.service.DiscountCodeFacadeREST.class);
        resources.add(ru.lionsoft.hello.ws.rest.service.ManufacturerFacadeREST.class);
        resources.add(ru.lionsoft.hello.ws.rest.service.MicroMarketFacadeREST.class);
        resources.add(ru.lionsoft.hello.ws.rest.service.ProductCodeFacadeREST.class);
        resources.add(ru.lionsoft.hello.ws.rest.service.ProductFacadeREST.class);
        resources.add(ru.lionsoft.hello.ws.rest.service.PurchaseOrderFacadeREST.class);
    }
    
}
