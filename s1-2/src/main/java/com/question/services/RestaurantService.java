package com.question.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.dao.RestaurantOrderDAO;
import com.question.dto.OrderResponseDTO;

@Service
public class RestaurantService 
{
	@Autowired
    private RestaurantOrderDAO orderDAO;

    public String greeting() {
        return "Welcome to Swiggy Restaurant service";
    }

    public OrderResponseDTO getOrder(String orderId) {
    	
        return orderDAO.getOrders(orderId);
    }
}
