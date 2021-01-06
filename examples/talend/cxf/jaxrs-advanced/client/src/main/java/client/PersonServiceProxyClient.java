/**
 * Copyright (C) 2010 Talend Inc. - www.talend.com
 */
package client;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import common.advanced.Person;
import common.advanced.PersonCollection;
import common.advanced.PersonService;

public final class PersonServiceProxyClient {

    private PersonService proxy;
    
    public PersonServiceProxyClient() {
        
    }
    
    public PersonServiceProxyClient(PersonService personService) {
        this.proxy = personService;
    }
    
    public void setPersonService(PersonService proxy) {
        this.proxy = proxy;
        useService();
    }
    
    
    public void useService() {
        System.out.println("Using a simple JAX-RS proxy to get all the persons...");
        // getPersons(a, b): a is zero-based start index, b is number of records
        // to return (-1 for all)
        Response resp = proxy.getPersons(0, -1);
        if (resp.getStatus() == 200) {
            PersonCollection personColl = resp.readEntity(PersonCollection.class);
            List<Person> persons = personColl.getList();
            for (Iterator<Person> it = persons.iterator(); it.hasNext();) {
                Person person = it.next();
                System.out.println("ID " + person.getId() + " : " + person.getName() + ", age : "
                                   + person.getAge());
            }
        }

        System.out.println("Using PATCH...");
        WebClient.getConfig(proxy).getRequestContext().put("use.async.http.conduit",
        		true);
        String patch = proxy.patch();
        System.out.println("Patch: " + patch);
    }

}
