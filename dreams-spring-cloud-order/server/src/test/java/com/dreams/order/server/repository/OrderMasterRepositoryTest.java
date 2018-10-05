package com.dreams.order.server.repository;

import com.dreams.order.server.dataobject.OrderMaster;
import com.dreams.order.server.enums.OrderStatusEnum;
import com.dreams.order.server.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/* todo: 两种形式
@RunWith(SpringRunner.class)
@SpringBootTest
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("老孟");
        orderMaster.setBuyerPhone("18633091759");
        orderMaster.setBuyerAddress("石家庄市长安区光华路");
        orderMaster.setBuyerOpenid("1007036");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);

    }
}