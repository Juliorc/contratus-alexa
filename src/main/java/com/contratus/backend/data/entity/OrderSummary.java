package com.contratus.backend.data.entity;

import java.time.LocalDate;
import java.util.List;

import com.contratus.backend.data.OrderState;

public interface OrderSummary {
	Long getId();

	OrderState getState();

	Customer getCustomer();

	List<OrderItem> getItems();

	LocalDate getDueDate();
	
	LocalDate getStartDate();

	Integer getTotalPrice();
}
