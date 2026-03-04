package com.restroapp.order.service;

import com.restroapp.order.Mapper.OrderMapper;
import com.restroapp.order.dto.OrderDTO;
import com.restroapp.order.dto.OrderDTOFromFE;
import com.restroapp.order.dto.UserDTO;
import com.restroapp.order.entity.Order;
import com.restroapp.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO SaveOrderInDb(OrderDTOFromFE orderDetails) {

        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);

    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {

        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }
}
