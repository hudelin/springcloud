package com.hu;

import com.google.common.collect.Lists;
import com.hu.mapper.PaymentMapper;
import com.hu.pojo.po.Payment;
import com.hu.service.PaymentService;
import com.hu.util.IdFactorySnowFlakeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class DemonPaymentApplicationTests {

	@Resource
	PaymentMapper paymentMapper;

	@Autowired
	private PaymentService paymentService;

	@Test
	public void test() throws Exception {

		Example paymentExample = new Example(Payment.class);
//		paymentExample.createCriteria().andLike("paymentId","13085868898%");
//		List<Payment> payments = paymentMapper.selectByExample(paymentExample);
//		List<Payment> payments = paymentMapper.selectAll();
		Random r = new Random();
		List<Payment> paymentList= Lists.newArrayList();
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		for (int i = 0; i < 500000; i++) {
			Payment build = Payment.builder()
					.serial("")
					.paymentId(IdFactorySnowFlakeUtil.snowflakeId())
					.price(BigDecimal.valueOf(r.nextInt(100)))
					.discount(BigDecimal.valueOf(r.nextInt(50)))
					.createTime(new Date())
					.updateTime(new Date())
					.deleted("0")
					.build();
			paymentMapper.insert(build);
		}
		System.out.println("耗时1");
		System.out.println(System.currentTimeMillis() - startTime);
		startTime=System.currentTimeMillis();
//		paymentMapper.insertList(paymentList);
		System.out.println("耗时2");
		System.out.println(System.currentTimeMillis()-startTime);
		System.out.println(1);

	}




}
