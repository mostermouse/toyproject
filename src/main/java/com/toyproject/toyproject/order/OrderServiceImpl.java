package com.toyproject.toyproject.order;

import com.toyproject.toyproject.Repository.MemberRepository;
import com.toyproject.toyproject.annotation.MainDiscountPolicy;
import com.toyproject.toyproject.discount.DiscountPolicy;
import com.toyproject.toyproject.member.Member;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //알아서 생성자 생성해줌
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


   public OrderServiceImpl( MemberRepository memberRepository,
                            //@Qualifier("mainDiscountPolicy")
                            @MainDiscountPolicy
                            DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
   }

  /* 잘 안씀
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice =  discountPolicy.discount(member , itemPrice );

        return new Order(memberId , itemName , itemPrice , discountPrice);
    }

    //Test
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
