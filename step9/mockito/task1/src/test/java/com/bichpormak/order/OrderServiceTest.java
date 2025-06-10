package com.bichpormak.order;


import com.bichpormak.Order;
import com.bichpormak.repository.OrderRepository;
import com.bichpormak.service.InventoryService;
import com.bichpormak.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private OrderService orderService;

    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order("abobus", 1, 1000);
    }


    @Test
    @DisplayName("Process available order")
    public void givenOrderInStock_whenProcessOrder_thenSaveOrder() {

        when(inventoryService.isProductAvailable(order.getProductId(), order.getQuantity())).thenReturn(true);

        assertTrue(orderService.processOrder(order));

        verify(orderRepository).saveOrder(order);
        verify(inventoryService).isProductAvailable(order.getProductId(), order.getQuantity());

    }

    @Test
    @DisplayName("Process don't available order")
    public void givenOrderIsOutOfStock_whenProcessOrder_thenDontSaveOrder() {

        when(inventoryService.isProductAvailable(order.getProductId(), order.getQuantity())).thenReturn(false);

        assertFalse(orderService.processOrder(order));

        verify(inventoryService).isProductAvailable(order.getProductId(), order.getQuantity());
        verify(orderRepository, times(0)).saveOrder(order);

    }

}
