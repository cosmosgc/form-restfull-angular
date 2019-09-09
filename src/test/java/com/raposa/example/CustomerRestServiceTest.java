package com.raposa.example;


import com.raposa.example.api.CustomerRestService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.Future;

public class CustomerRestServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(CustomerRestService.class);
    }

    @Test
    public void customerRestServiceFormTest() throws Exception {
        Form form = new Form();
        form.param("name", "Alyssa William")
                  .param("address", "1021 Hweitt Street")
                  .param("phone-number", "343-343-3433");

        WebTarget target = target("customers");
        Future<String> response = target.
                   request(MediaType.APPLICATION_FORM_URLENCODED)
                  .accept(MediaType.TEXT_PLAIN)
                  .buildPost(Entity.form(form)).submit(String.class);
        System.out.println(response.get());

        String s = target.path("1").request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(s);
    }
}