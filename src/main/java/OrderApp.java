import com.toyproject.toyproject.config.AppConfig;
import com.toyproject.toyproject.member.Grade;
import com.toyproject.toyproject.member.Member;
import com.toyproject.toyproject.order.Order;
import com.toyproject.toyproject.order.OrderService;
import com.toyproject.toyproject.order.OrderServiceImpl;
import com.toyproject.toyproject.service.MemberService;
import com.toyproject.toyproject.service.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {


       // AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();
        //Spring 컨테이너 쓰는 이유
        //
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =
                applicationContext.getBean("memberService" , MemberService.class);
        OrderService orderService =
                applicationContext.getBean("orderService" , OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId , "Mama" , Grade.VIP);
        memberService.join(member);
        Order order  = orderService.createOrder(memberId, "itemA" , 20000);
        System.out.println("order : " + order);
        System.out.println("order :" + order.calculatePrice());
    }

}
