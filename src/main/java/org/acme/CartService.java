package org.acme;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs .*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

    @Path("/cart")
    public class CartService {

        @Inject
        CartRepository cartRepository;

        @POST
        public Response createCart(CartPayload cartPayload) {
            Cart cart = cartRepository.addCart(cartPayload);
            return Response.status(Response.Status.CREATED).entity(cart).build();
        }

    }
