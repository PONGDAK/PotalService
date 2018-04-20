package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProductDaoTest {
    private ProductDao productDao;

    @Before
    public void setup() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        productDao = applicationContext.getBean("productDao", ProductDao.class);
    }

    @Test
    public void get(){
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
    }

    @Test
    public void add(){
        Product product = new Product();
        Long id = insertTestData(product);

        Product insertedProduct = productDao.get(id);
        assertEquals(id, insertedProduct.getId());
        assertEquals(product.getTitle(), insertedProduct.getTitle());
        assertEquals(product.getPrice(), insertedProduct.getPrice());
    }

    @Test
    public void update(){
        Product product = new Product();
        Long id = insertTestData(product);
        product.setId(id);
        product.setPrice(12000);
        product.setTitle("바뀐감귤");
        productDao.update(product);

        Product updatedProduct = productDao.get(id);
        assertEquals(product.getId(), updatedProduct.getId());
        assertEquals(product.getTitle(), updatedProduct.getTitle());
        assertEquals(product.getPrice(), updatedProduct.getPrice());
    }

    @Test
    public void delete() throws SQLException {
        Product product = new Product();
        Long id = insertTestData(product);
        productDao.delete(id);

        Product deletedProduct = productDao.get(id);
        assertNull(deletedProduct);
    }

    private Long insertTestData(Product product) {
        product.setTitle("새감귤");
        product.setPrice(10000);

        return productDao.insert(product);
    }
}
