package org.keumin.orderservice;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {
    private Long id;
    private Long userId;
    private String product;
    private int quantity;
}
