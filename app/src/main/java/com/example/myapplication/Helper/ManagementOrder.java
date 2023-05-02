package com.example.myapplication.Helper;

import android.content.Context;
import android.widget.Toast;

//import com.example.myapplication.Domain.FoodDomain;
import com.example.myapplication.Domain.FoodDomain;
import com.example.myapplication.Order;
import com.example.myapplication.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementOrder {

    private Context context;
    private TinyDB tinyDB;

    public ManagementOrder(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public ArrayList<Order> getListOrder() {
        return tinyDB.getListObject1("Orderlist");
    }

    public void insertOrder(Order item) {
        ArrayList<Order> listOrder = getListOrder();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listOrder.size(); i++) {
            if (listOrder.get(i).getOrderName().equals(item.getOrderName())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        /*
        if (existAlready) {
            listOrder.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listOrder.add(item);
        }

         */

        tinyDB.putListObject1("Orderlist", listOrder);
        //Toast.makeText(context, "Added To your Cart", Toast.LENGTH_LONG).show();

    }



}
