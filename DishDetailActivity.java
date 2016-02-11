package com.example.helloandroid;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.helloandroid.model.Dish;
import com.example.helloandroid.model.FoodMenu;

import java.util.ArrayList;

public class DishDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);

        Intent i = getIntent();
        int itemPosition = i.getIntExtra(DishListActivity.KEY_POSITION, 0);

        FoodMenu foodMenu = FoodMenu.getInstance(this);
        ArrayList<Dish> dishList = foodMenu.getDishList();
        Dish dish = dishList.get(itemPosition);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(dish.name);

        //สร้าง fragment (อ็อบเจ็ค DishFragment)
        DishFragment fragment = new DishFragment();

        // บอกให้ fragment รู้ว่าต้องแสดงข้อมูลรายการอาหารอะไร
        fragment.setPosition(itemPosition);

        // ใส่ fragment ลงใน FrameLayout ภายใน layout ของ Activity
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}
