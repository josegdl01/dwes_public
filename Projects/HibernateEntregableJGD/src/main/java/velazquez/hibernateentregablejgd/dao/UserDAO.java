package velazquez.hibernateentregablejgd.dao;

import velazquez.hibernateentregablejgd.dao.generic.GenericDAO;
import velazquez.hibernateentregablejgd.models.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User> {

    public List<User> selectUsersByNameOrEmail(String busqueda);
}
