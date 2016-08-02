package com.softserve.example.warehouse.tests;

import com.softserve.example.warehouse.Order;
import com.softserve.example.warehouse.Warehouse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderTesterMockito {
    private static String TALISKER = "Talisker";
    private static String HIGHLAND_PARK = "Highland Park";

    @InjectMocks
    Order order = new Order(TALISKER, 50);

    @Mock
    private Warehouse mockedWarehouse;

    @Test
    public void testOrderIsFilled_IfEnoughInWarehouse() {
        Order order = new Order(TALISKER, 50);
        when(mockedWarehouse.getInventory(TALISKER)).thenReturn(50);
        order.fill(mockedWarehouse);
        Mockito.verify(mockedWarehouse).removeInventory(TALISKER, 50);
        assertTrue(order.isFilled());
    }

    @Test
    public void testOrderIsNotFilled_IfNotEnoughInWarehouse() {
        Order order = new Order(TALISKER, 100);
        when(mockedWarehouse.getInventory(TALISKER)).thenReturn(50);
        order.fill(mockedWarehouse);
        Mockito.verify(mockedWarehouse, never()).removeInventory(anyString(), anyInt());
        assertFalse(order.isFilled());
    }
}

