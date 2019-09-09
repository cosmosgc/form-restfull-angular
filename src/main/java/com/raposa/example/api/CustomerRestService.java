package com.raposa.example.api;



import com.raposa.example.Customer;
import com.raposa.example.CustomerDataService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("customers")
public class CustomerRestService {
    private CustomerDataService dataService = CustomerDataService.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return dataService.getCustomerList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String createCustomer(@FormParam("id") int id,
    							 @FormParam("name") String name,
                                 @FormParam("email") String email,
                                 @FormParam("comment") String comment,
								 @FormParam("cnpj") String cnpj){
        return dataService.addCustomer(id, name, email, comment, cnpj);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") String id) {
        Customer customer = dataService.getCustomerById(id);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND)
                      .build();
        } else {
            return Response.ok()
                           .entity(customer)
                           .build();
        }


    }
    
    
}