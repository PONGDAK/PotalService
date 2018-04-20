package kr.ac.jejunu;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao {
    private final JdbcContext jdbcContext;

    public ProductDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public Product get(Long id) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            String sql = "select * from product where id = ?";
            Object[] params = new Object[]{id};
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(int i=0; i<params.length; i++){
                preparedStatement.setObject(i+1, params[i]);
            }
                    return preparedStatement;
            };
        return jdbcContext.jdbcConextForGet(statementStrategy);
    }

    public Long insert(Product product) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            String sql = "insert into product(title, price) values (?, ?)";
            Object[] params = new Object[]{product.getTitle(), product.getPrice()};
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for(int i=0; i<params.length; i++){
                preparedStatement.setObject(i+1, params[i]);
            }
                return preparedStatement;
        };
        return jdbcContext.jdbcContextForInsert(statementStrategy);
    }

    public void update(Product product) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            String sql = "update product set title = ?, price = ? where id= ?";
            Object[] params = new Object[]{product.getTitle(), product.getPrice(), product.getId()};
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(int i=0; i<params.length; i++){
                preparedStatement.setObject(i+1, params[i]);
            }
                    return preparedStatement;
            };
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            String sql = "delete from product where id= ?";
            Object[] params = new Object[]{id};
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(int i=0; i<params.length; i++){
                preparedStatement.setObject(i+1, params[i]);
            }
                return preparedStatement;
        };
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }
}
