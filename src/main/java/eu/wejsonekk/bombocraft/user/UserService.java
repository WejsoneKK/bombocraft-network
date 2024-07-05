package eu.wejsonekk.bombocraft.user;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class UserService {
    private UserRepository userRepository;
    private Cache<Integer, User> userCache;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userCache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(100)
                .build();
    }

    public void addUser(User user) throws SQLException {
        userRepository.addUser(user);
        userCache.put(user.getId(), user);
    }

    public User getUserById(int id) throws SQLException {
        return userCache.get(id, userId -> {
            try {
                return userRepository.getUserById(userId);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    public void deleteUser(User user) throws SQLException {
        userRepository.deleteUser(user);
        userCache.invalidate(user.getId());
    }

}
