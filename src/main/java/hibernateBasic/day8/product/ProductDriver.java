package hibernateBasic.day8.product;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

import java.util.List;

public class ProductDriver {
    private final static String FILE_NAME="day8/product/Product.hbm.xml";

    public static void main(String[] args) {

        insertion(new Product("item-1",100.0));
        insertion(new Product("item-2",-10.0));
        insertion(new Product("item-3",0.0));
        insertion(new Product("item-4",1.0));
        insertion(new Product("item-5",2.0));
        insertion(new Product("item-6",200.0));
        insertion(new Product("item-7",300.0));
        insertion(new Product("item-8",-30.0));

        showProductPriceGreterThan100();
        updateNegativeValue();
        deletionAmountLessThan10();
    }

    private static void deletionAmountLessThan10() {
        Session session = Utility.getSession(FILE_NAME);
        Transaction transaction =session.beginTransaction();
        List<Product> productList =session.createQuery("from Product where amount<10 ",Product.class).getResultList();
        System.out.println(productList);

        for (Product product: productList){
            session.remove(product);
        }
        transaction.commit();
        session.close();
    }

    private static void updateNegativeValue() {
        Session session =Utility.getSession(FILE_NAME);
        Transaction transaction = session.beginTransaction();
        List<Product> productList =session.createQuery("from Product where amount<0 ",Product.class).getResultList();
        System.out.println("Before Update Nagative Number :"+productList);

        for (Product product: productList){
            product.setAmount(10.0);
            session.persist(product);
        }
        transaction.commit();
        session.close();
        Session session1 =Utility.getSession(FILE_NAME);
        List<Product> productList2 =session1.createQuery("from Product ",Product.class).getResultList();
        System.out.println("After Update Nagative Number :"+productList2);
        session.close();
    }

    private static void showProductPriceGreterThan100() {
        Session session =Utility.getSession(FILE_NAME);
        List<Product> productList =session.createQuery("from Product where amount >100",Product.class).getResultList();
        System.out.println("Product whose amount greter than 100 :"+productList);
        session.close();
    }

    private static void insertion(Product product) {
        Session session = Utility.getSession(FILE_NAME);
        Transaction transaction = session.beginTransaction();
        session.persist(product);
        transaction.commit();
        session.close();
    }
}
