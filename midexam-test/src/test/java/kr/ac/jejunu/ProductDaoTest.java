package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ProductDaoTest {
    private ProductDao productDao;
    private DaoFactory daoFactory;

    @Before
    public void setup() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        productDao = applicationContext.getBean("productDao", ProductDao.class);
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
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
        Long id = getaLong(product);

        Product insertedProduct = productDao.get(id);
        assertThat(insertedProduct.getId(), is(id));
        assertThat(insertedProduct.getTitle(), is(product.getTitle()));
        assertThat(insertedProduct.getPrice(), is(product.getPrice()));
    }

    private Long getaLong(Product product) throws ClassNotFoundException, SQLException {
        product.setTitle("테스트");
        product.setPrice(1000);
        return productDao.insert(product);
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        Product product = new Product();
        Long id = insertProductTest(product);

        product.setId(id);
        product.setTitle("바뀐이름");
        product.setPrice(12000);
        productDao.update(product);

        Product updateProduct = productDao.get(id);
        assertThat(updateProduct.getId(), is(product.getId()));
        assertThat(updateProduct.getTitle(), is(product.getTitle()));
        assertThat(updateProduct.getPrice(), is(product.getPrice()));



    }

    private Long insertProductTest(Product product) throws ClassNotFoundException, SQLException {
        product.setTitle("테스트");
        product.setPrice(1000);
        return productDao.insert(product);
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        Product product = new Product();
        Long id = insertProductTest(product);

        productDao.delete(id);

        Product deletedProduct = productDao.get(id);
        assertThat(deletedProduct, nullValue());

    }
}
