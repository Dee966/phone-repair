package tech.yxing.phone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.yxing.phone.dao.PhoneDao;

@SpringBootTest
class PhoneApplicationTests {
    @Autowired
    private PhoneDao phoneDao;

    @Test
    void addConditionPrice() {
        long l = System.currentTimeMillis();
        System.out.println(l);
        Integer conditionId = 0;
        for (int i = 1;i < 29;i++){
            conditionId = i;
            System.out.println(conditionId);
            phoneDao.addConditionPrice(null,7, conditionId);
        }

    }

}
