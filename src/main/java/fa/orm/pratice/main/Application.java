package fa.orm.pratice.main;

import fa.orm.pratice.hibernate.HibernateUtils;

public class Application {

    public static void main(String[] args) {
        HibernateUtils.getSessionFactory();
    }
}
