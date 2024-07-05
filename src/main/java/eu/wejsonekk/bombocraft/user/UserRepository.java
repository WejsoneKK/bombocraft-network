package eu.wejsonekk.bombocraft.user;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import org.bukkit.Bukkit;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class UserRepository {
    private Dao<User, Integer> userDao;

    public UserRepository(ConnectionSource connectionSource) throws SQLException {
        userDao = DaoManager.createDao(connectionSource, User.class);
    }

    public void addUser(User user) throws SQLException {
        Bukkit.getLogger().log(Level.INFO, "Creating new User " + user.getName());
        userDao.create(user);
    }

    public User getUserById(int id) throws SQLException {
        Bukkit.getLogger().log(Level.INFO, "Get User By ID (" + id + ")");
        return userDao.queryForId(id);
    }

    public List<User> getAllUsers() throws SQLException {
        Bukkit.getLogger().log(Level.INFO, "Geting all Users in Cache");
        return userDao.queryForAll();
    }

    public void deleteUser(User user) throws SQLException {
        Bukkit.getLogger().log(Level.INFO, "Delete User from Cache" + user.getName().toString());
        userDao.delete(user);
    }
}
