package eu.wejsonekk.bombocraft.user;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@DatabaseTable(tableName = "users")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @DatabaseField(columnName = "player_uniqueId", canBeNull = true, unique = true, id = true)
    public UUID uniqueId;

    @DatabaseField(columnDefinition = "player_nickname", canBeNull = false)
    private String nickname;

    @DatabaseField(columnName = "first_login", canBeNull = false, dataType = DataType.DATE_TIME)
    public Long firstLogin;
    @DatabaseField(columnName = "last_login", canBeNull = false, dataType = DataType.DATE_TIME)
    public long lastLogin;

}
