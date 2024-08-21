package com.toyproject.toyproject.order;

import com.toyproject.toyproject.member.Member;

public interface OrderService {
    Order createOrder(Long memberId , String itemName , int itemPrice);
}
