

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.algorithms.modal.ListNode;
import com.common.algorithms.service.OfferAlgorithmsService;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-dubbo-consume.xml"});
        context.start();
        OfferAlgorithmsService algorithmsService=(OfferAlgorithmsService) context.getBean("algorithmsService");
        ArrayList list=algorithmsService.printListFromTailToHead(new ListNode("1"));
        System.out.println("远程调用的结果："+"ppp");
        String l=(String) list.get(0);
        System.out.println(l);
        try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        context.close();
	}
}
