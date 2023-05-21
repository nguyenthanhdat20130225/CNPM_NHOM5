package db;

import Product.Account;
import org.apache.commons.dbcp.BasicDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBiConnector {
    private static Jdbi jdbi;

    public JDBiConnector() {

    }
    /*
     * Trả về đối tượng Jdbi để thực hiện các truy vấn SQL
     *
     * @return Đối tượng Jdbi
     */
    public static Jdbi get() {
        if (jdbi == null) create();
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }
    /*
     * Tạo và cấu hình đối tượng Jdbi
     */

    public static void create() {
        try {

            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setPassword("");
            ds.setUsername("root");
            ds.setMaxIdle(2);
            ds.setMinIdle(2);
            ds.setUrl("jdbc:mysql://localhost:3306/fast_food");
            Connection cn = ds.getConnection();
            jdbi = Jdbi.create(cn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
