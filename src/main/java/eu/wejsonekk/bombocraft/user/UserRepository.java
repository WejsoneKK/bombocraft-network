package eu.wejsonekk.bombocraft.user;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import org.bukkit.Bukkit;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;

public interface UserRepository {
    CompletableFuture<Void> update(User user);

    CompletableFuture<User> findUser(UUID uniqueId);

    CompletableFuture<Set<User>> getAllUsers();

    CompletableFuture<User> deleteUser(UUID uniqueId);

}
