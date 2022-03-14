package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CartRepository implements PanacheRepository<Cart> {

    @Inject
    EntityManager em;
    @Transactional
    public Cart addCart(CartPayload payload) {
        Cart cart = new Cart();
        cart.setTitle(payload.getTitle());
        cart .setQuantity(payload.getQuantity());
        cart .setPrice(payload.getPrice());
        cart .setStatus(Status.NEW);
        cart .persist();
        return cart ;
        }

        @Transactional
        public List<Cart > getCarts(List<Status> status) {
        TypedQuery<Cart> q =
                em.createQuery("select t from Cart t where t.status in (:status)", Cart.class);
        q.setParameter("status", status);
        return q.getResultList();
    }


//    @Transactional
//    public List<Cart > getAllCarts(List<Status> status) {
//        TypedQuery<Cart> q =
//                em.createQuery("select t from Cart t where t.status in (:status)", Cart.class);
//        q.setParameter("status", status);
//        return q.getResultList();
//    }


    @Transactional
    public void updateStatus(long id, Status status) {
        Cart  cart  = Cart .findById(id);
        cart .setStatus(status);
        cart.persist();

        }

    }
