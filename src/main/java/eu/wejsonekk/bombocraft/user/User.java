package eu.wejsonekk.bombocraft.user;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.UUID;

@DatabaseTable(tableName = "users")

public class User {

    @DatabaseField(generatedId = true)
    private int Id;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField(canBeNull = true, unique = true)
    public UUID uniqueId;

    public User() {
    }

    public User(String name, UUID uniqueId) {
        this.name = name;
        this.uniqueId = uniqueId;
    }

    public void setId(int id) {
        Id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }
    public UUID getUniqueId() {
        return uniqueId;
    }

    public int getId() {
        return Id;
    }
}
