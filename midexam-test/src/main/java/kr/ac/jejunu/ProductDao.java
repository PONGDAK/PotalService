package kr.ac.jejunu;

import java.sql.SQLException;

public class ProductDao {
    private final JdbcContext jdbcContext;

    public ProductDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public Product get(Long id) throws SQLException {
        String sql = "select * from product where id = ?";
        return jdbcContext.queryForObject(id, sql);
    }

    public Long insert(Product product) throws SQLException {
        String sql = "insert into product(title, price) values (?, ?)";
        return jdbcContext.insert(product, sql, this);
    }

    public void update(Product product) throws SQLException {
        String sql = "update product set title = ?, price = ? WHERE  id = ?";
        Object[] params = new Object[]{product.getTitle(), product.getPrice(), product.getId()};
        jdbcContext.update(sql, params);

    }

    public void delete(Long id) throws SQLException {
        String sql = "delete from product WHERE  id = ?";
        Object[] params = new Object[]{id};
        jdbcContext.update(sql, params);
    }

}
