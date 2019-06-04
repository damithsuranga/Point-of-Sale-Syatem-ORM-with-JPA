package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudDAOimpl;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.entity.Item;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAOImpl extends CrudDAOimpl<Item,String> implements ItemDAO {

}
