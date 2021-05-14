package com.example.deleteitagam.service;

import com.example.deleteitagam.entity.SushiItem;
import com.example.deleteitagam.entity.SushiOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SushiOrderManager {

    private int currentSeat;
    private int totalSeats;
    private ArrayList<Queue<SushiItem>> seats; // filled with current request always.
    private Queue<ArrayList<SushiOrder>> requestQueue;
//    private ArrayList<SushiOrder> currentRequest;

    public SushiOrderManager() {
        currentSeat = 0;
        totalSeats = 16;
        seats = new ArrayList<>();
        requestQueue = new LinkedList<>();

        for (int i = 0; i < totalSeats; i++) {
            seats.add(new LinkedList<>());
        }
    }

    /**
     * request add kardi bas.
     * @param request
     */
    public void addOrder(ArrayList<SushiOrder> request) {
        requestQueue.offer(request);
    }

    /**
     * return the next order to process.
     * @return
     */
    public SushiItem nextItem() {
        // we don't have any order in current request but we've future request to process
        if(!currentRequestHasOrder() && !requestQueue.isEmpty()){
            fillSeatsWithNextRequest();
            return nextItem();
        }
        else
            // current request mai hai order, simple.
            for(Queue<SushiItem> items: seats)
                if(!items.isEmpty())
                    return items.poll();

        throw new RuntimeException("No Order to Process.");  // fire custom exception
    }

    public boolean hasNextOrder(){
        if(currentRequestHasOrder())
            return true;
        if(!requestQueue.isEmpty())
            return true;
        return false;
    }
    /**
     * this will keeps track of current request. agar current request khali ho gai to usko null kar dege.
     * @return
     */
    private boolean currentRequestHasOrder() {
        for(Queue<SushiItem> order : seats){
            if(!order.isEmpty())
                return true;
        }
        return false;
    }

    private boolean fillSeatsWithNextRequest() {
        if(requestQueue.isEmpty())
            return false;
        addSushiOrder(requestQueue.poll());
        return true;
    }

    private void addSushiOrder(ArrayList<SushiOrder> currentRequest) {
        for (SushiOrder order : currentRequest) {
            for (String roll : order.getMenuItemIds()) {
                seats.get(order.getSeatId() - 1).offer(
                        new SushiItem(order.getSeatId(), roll)
                );
            }
        }
    }

}
