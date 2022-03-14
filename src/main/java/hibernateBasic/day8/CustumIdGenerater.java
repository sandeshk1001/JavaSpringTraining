package hibernateBasic.day8;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.factory.spi.StandardGenerator;

import java.util.Random;

public class CustumIdGenerater implements StandardGenerator {
    private final String DEFAULT_SEQUENCE_NAME="my_seq";

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return 10000 + new Random().nextInt(90000);
        //return 2;
    }
}
