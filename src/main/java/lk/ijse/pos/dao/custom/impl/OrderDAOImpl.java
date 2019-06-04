package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudDAOimpl;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.entity.Order;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl extends CrudDAOimpl<Order,Integer> implements OrderDAO {




    @Override
    public int getLastOrderId() throws Exception {
       return (int) em.createNativeQuery("SELECT id FROM `orders` Order BY id DESC LIMIT 1 ").getSingleResult();
    }


}
