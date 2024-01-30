package velazquez.hibernateentregablejgd.services.impl;

import org.hibernate.Session;
import velazquez.hibernateentregablejgd.dao.UserDAO;
import velazquez.hibernateentregablejgd.dao.impl.UserDAOImpl;
import velazquez.hibernateentregablejgd.models.User;
import velazquez.hibernateentregablejgd.services.UserServices;

import java.util.List;

public class UserServicesImpl implements UserServices {

    private UserDAO userDAO;



    public UserServicesImpl(Session session) {
    this.userDAO = new UserDAOImpl(session);
    }

    @Override
    public void deleteUser(User user) {
        if(user != null && user.getId() != null){
            userDAO.deleteItem(user);
        }
    }

    @Override
    public void insertUser(User user) {
        if(user != null && user.getId() == null){
            userDAO.insertItem(user);
        }
    }

    @Override
    public void updateUser(User user) {
        if(user != null && user.getId() != null){
            userDAO.updateItem(user);
        }
    }

    @Override
    public User selectUser(Long id) {
        User user = null;

        if(id != null){
            user = userDAO.selectItem(id);
        }

        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        return userDAO.selectAllItems();
    }

    public List<User> selectUsersByUsernameOrEmail(String busqueda){
        return userDAO.selectUsersByNameOrEmail(busqueda);
    }
}
