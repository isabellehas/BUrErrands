package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.DeliveryAdapter;
import com.example.myapplication.Helper.ManagementCart;
import com.example.myapplication.Helper.ManagementOrder;
import com.example.myapplication.Interface.ChangeNumberItemsListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.os.Bundle;

import com.example.myapplication.Helper.ManagementOrder;
import com.example.myapplication.R;
import com.example.myapplication.DeliveryAdapter;
import com.example.myapplication.Order;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private SmartRefreshLayout smartRefreshLayout;
    private DeliveryAdapter deliveryAdapter;

    private ManagementOrder managementOrder;

    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        managementOrder = new ManagementOrder(this);

        recyclerView = findViewById(R.id.recyclerView);
        smartRefreshLayout = findViewById(R.id.smartRefreshLayout);

        deliveryAdapter = new DeliveryAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(deliveryAdapter);

        // Populate the adapter with sample data
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("#202301", "Restaurant name 1 ", "1075 CommonWealth Ave", "455 CommonWealth Ave"));
        orders.add(new Order("#202302", "Restaurant name 2 ", "1075 CommonWealth Ave", "455 CommonWealth Ave"));
        orders.add(new Order("#202303","KFC","1100 Commonwealth Ave","585 Commonwealth Ave"));
        orders.add(new Order("#202304", "Restaurant name 3 ", "1075 CommonWealth Ave", "455 CommonWealth Ave"));
        orders.add(new Order("#202305", "Restaurant name 4 ", "1075 CommonWealth Ave", "455 CommonWealth Ave"));
        orders.add(new Order("#202306", "Restaurant name 5 ", "1075 CommonWealth Ave", "455 CommonWealth Ave"));
        orders.add(new Order("#202307", "Restaurant name 6 ", "1075 CommonWealth Ave", "455 CommonWealth Ave"));


        deliveryAdapter.setNewInstance(orders); //将新的数据列表设置为适配器的数据源

        // Set up refresh listener
        smartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            // Perform actions when the layout is refreshed, 下拉刷新
            refreshLayout.finishRefresh(2000); // Set the refresh duration to 2 seconds
        });
    }

    /*
    private void initView() {
        //recyclerViewList = findViewById(R.id.recyclerView);
        //taxTxt = findViewById(R.id.taxTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView3);
        recyclerViewList = findViewById(R.id.cartView);
    }

     */

}
