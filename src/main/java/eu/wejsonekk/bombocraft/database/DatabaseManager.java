package eu.wejsonekk.bombocraft.database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import eu.wejsonekk.bombocraft.user.User;
import org.bukkit.Server;

import java.io.File;
import java.sql.SQLException;

public class DatabaseManager {

    private Server server;
    private File dataFile;

    private static final String DATABASE_URL = "jdbc:sqlite:plugins/bombocraft-network/users.db";

    public static ConnectionSource getConnectionSource() throws SQLException {
        return new JdbcConnectionSource(DATABASE_URL);
    }

    public static void createTables() throws Exception {
        ConnectionSource connectionSource = getConnectionSource();
        TableUtils.createTableIfNotExists(connectionSource, User.class);
        connectionSource.close();
    }


}
