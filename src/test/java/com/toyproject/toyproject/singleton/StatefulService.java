package com.toyproject.toyproject.singleton;

public class StatefulService {

    // 상태를 가지지 않도록 메서드의 인자로 가격을 받도록 변경
    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }

    public static void main(String[] args) {
        StatefulService service = new StatefulService();

        // 각 주문마다 가격을 명시적으로 전달
        int price1 = service.order("jojo", 2000);
        int price2 = service.order("jojo2", 3000);

        System.out.println("Price1: " + price1);
        System.out.println("Price2: " + price2);
    }
}
