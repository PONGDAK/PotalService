package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest {
    private  ProductDao productDao;
    @Before
    public void setup() {
        productDao = new ProductDao();

    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        productDao = new ProductDao();
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        Product product = new Product();
        product.setTitle("새감귤");
        product.setPrice(15000);

        Long id = productDao.insert(product);

        Product insertedProduct = productDao.get(id);
        assertEquals(id, insertedProduct.getId());
        assertEquals(product.getTitle(), insertedProduct.getTitle());
        assertEquals(product.getPrice(), insertedProduct.getPrice());

    }
}
