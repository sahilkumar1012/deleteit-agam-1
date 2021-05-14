package com.example.deleteitagam.controller;


import com.example.deleteitagam.entity.SushiItem;
import com.example.deleteitagam.entity.SushiOrder;
import com.example.deleteitagam.service.SushiOrderManager;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderManagerController {

    public static void main(String[] args) {
        SushiOrderManager manager = new SushiOrderManager();

        ArrayList<SushiOrder> request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(13, // seatId for this order
                                new ArrayList<>(Arrays.asList(
                                        new String[] {
                                                // menuItemIds for this order
                                                "tuna", "california", "avocado"
                                        }
                                ))
                        )
                )
        );

        manager.addOrder(request);

        SushiItem sushiItem = manager.nextItem(); // kuch bhi bacha current request mai.
        System.out.println(sushiItem.getSeatId() +" -  " +sushiItem.getMenuItemId());

        request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(1,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"cucumber"}
                                ))
                        )

                )
        );
        manager.addOrder(request);

        for (; manager.hasNextOrder(); ) {
            sushiItem = manager.nextItem();
            System.out.println(sushiItem.getSeatId() +" -  " +sushiItem.getMenuItemId());
        }


/*

        System.out.println(manager.nextItem().getSeatId());
        System.out.println(manager.nextItem().getSeatId());



        manager.addOrder(request);

        System.out.println(manager.nextItem().getSeatId());

        System.out.println(manager.nextItem().getSeatId());*/

    }
}
