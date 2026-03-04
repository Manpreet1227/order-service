package com.restroapp.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemsDTO {

    private Integer id;
    private String itemName;
    private String itemDescription;
    private Boolean isVeg;
    private Long price;
    private Integer restaurantId;
    private Integer quantity;
}
