package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order{
    private String orderId;
    private String name;
    private int qty;
    private double price;
}