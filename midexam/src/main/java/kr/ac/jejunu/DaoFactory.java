package kr.ac.jejunu;

public class DaoFactory {
    public static ProductDao getProductDao() {
        return new ProductDao(getConnectionMaker());
    }

    public static ConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
