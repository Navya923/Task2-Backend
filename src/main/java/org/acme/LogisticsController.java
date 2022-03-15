package org.acme;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("logistics")
public class LogisticsController {

    @Inject
    CartRepository cartRepository;

    @GET
    public List<Cart> getCarts(){
        System.out.println("fetching cart list for logistics");
        List<Cart> carts = cartRepository.getCarts(Arrays.asList(Status.NEW));
        System.out.println(carts);
        return carts;
    }


    @POST
    @Path("approve/{id}")

    @Transactional
    public Response approveCart( @PathParam("id") long id){
        System.out.println("Approve cart id : " +id);
        Cart cart = Cart.findById(id);
        cart.setStatus(Status.LOGISTICS_APPROVAL);
        cart.persist();
        return Response.status(Response.Status.OK).build();
    }



    @POST
    @Path("reject/{id}")
    @Transactional
    public Response rejectCart( @PathParam("id") long id){
        Cart cart = Cart.findById(id);
        cart.setStatus(Status.LOGISTICS_REJECT);
        cart.persist();
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("approved_carts")
    public List<Cart> GetApprovedCarts() {
        System.out.println("fetching approved cart list for logistics");
        List<Cart> carts = cartRepository.getCarts(Arrays.asList(Status.PROCUREMENT_APPROVAL, Status.FINANCE_APPROVAL, Status.LOGISTICS_REJECT));
        System.out.println(carts);
        return carts;
    }


    @GET
    @Path("rejected_carts")
    public List<Cart> GetRejectedCarts() {
        System.out.println("fetching rejected cart list for logistics");
        List<Cart> carts = cartRepository.getCarts(Arrays.asList(Status.LOGISTICS_REJECT));
        System.out.println(carts);
        return carts;
    }


}

