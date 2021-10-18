package com.onlineorder.onlineorder.dao;

import com.onlineorder.onlineorder.entity.Authorities;
import com.onlineorder.onlineorder.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;  //thread safe

    //Sava customer log in information
    public void signUp(Customer customer) {
        //Assign and save authorities upon signUp
        Authorities authorities = new Authorities();
        authorities.setEmail(customer.getEmail());
        authorities.setAuthorities("ROLE_USER");

        Session session = null;
        try {
            session = sessionFactory.openSession();  //Connect to database
            session.beginTransaction();
            session.save(customer);
            session.save(authorities);
            session.getTransaction().commit();  //Save to database when commit()
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //Return a customer object
    public Customer getCustomer(String email) {
        Customer customer = null;
        Session session = null;
        try {
            //Assume there's no synchronized read/write situation，did not use transaction
            session = sessionFactory.openSession();
            customer = session.get(Customer.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return customer;
    }
}