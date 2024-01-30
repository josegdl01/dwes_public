package velazquez.hibernateentregablejgd.services;

import velazquez.hibernateentregablejgd.models.User;

import java.util.List;

public interface UserServices {
    public void deleteUser(User user);
    public void insertUser(User user);
    public void updateUser(User user);
    public User selectUser(Long id);
    public List<User> selectAllUsers();

    public List<User> selectUsersByUsernameOrEmail(String busqueda);
}
