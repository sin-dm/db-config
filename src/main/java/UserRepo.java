import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo extends Database {

    public User getUserById(Long id) {
        String sql = "SELECT * FROM public.users WHERE ID = ?;";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            Long idFromDb;
            String name;
            String surname;
            String phone;
            Timestamp createdAt;
            Timestamp updatedAt;
            if (rs.next()) {
                idFromDb = rs.getLong("id");
                name = rs.getString("name");
                surname = rs.getString("surname");
                phone = rs.getString("phone");
                createdAt = rs.getTimestamp("created_at");
                updatedAt = rs.getTimestamp("updated_at");
                return new User(idFromDb, name, surname, phone, createdAt, updatedAt);
            } else {
                return new User("test", "test", "test");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось получить пользователя из БД: " + e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM public.users;";
        try {
            List<User> users = new ArrayList<>();
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.isClosed()) {
                while (rs.next()) {
                    User user = new User(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("phone"),
                            rs.getTimestamp("created_at"),
                            rs.getTimestamp("updated_at"));
                    users.add(user);
                }
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось получить пользователей из БД: " + e.getMessage());
        }
    }

    public User createUser(User user) {
        String sql = "INSERT INTO public.users (name, surname, phone) VALUES (?, ?, ?) RETURNING id;";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getPhone());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Long id = rs.getLong("id");
                user.setId(id);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось создать пользователя в БД: " + e.getMessage());
        }
    }
}
