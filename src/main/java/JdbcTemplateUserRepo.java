import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class JdbcTemplateUserRepo extends Database {

    private final String sqlGetUserById = "SELECT * FROM public.users WHERE id = :id;";

    private final String sqlCreateUser = "INSERT INTO public.users (name, surname, phone) VALUES (:name, :surname, :phone) RETURNING id;";

    public User getUserById(Long id) {
        return namedParameterJdbcTemplate().queryForObject(
                sqlGetUserById,
                new MapSqlParameterSource()
                        .addValue("id", id),
                new UserRowMapper()
        );
    }

    public Long createUser(User user) {
        return namedParameterJdbcTemplate().queryForObject(
                sqlCreateUser,
                new MapSqlParameterSource()
                        .addValue("name", user.getName())
                        .addValue("surname", user.getSurname())
                        .addValue("phone", user.getPhone()),
                Long.class
        );
    }

    public class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long idFromDb = rs.getLong("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String phone = rs.getString("phone");
            Timestamp createdAt = rs.getTimestamp("created_at");
            Timestamp updatedAt = rs.getTimestamp("updated_at");
            return new User(idFromDb, name, surname, phone, createdAt, updatedAt);
        }
    }
}
