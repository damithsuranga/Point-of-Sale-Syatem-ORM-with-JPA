package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudDAOimpl;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.entity.OrderDetail;
import lk.ijse.pos.entity.OrderDetailPK;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailDAOImpl extends CrudDAOimpl<OrderDetail,OrderDetailPK> implements OrderDetailDAO {


}
