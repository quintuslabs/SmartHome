package com.quintus.labs.smarthome.ui.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.quintus.labs.smarthome.R;
import com.quintus.labs.smarthome.adapter.RoomAdapter;
import com.quintus.labs.smarthome.model.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Smart Home
 * https://github.com/quintuslabs/SmartHome
 * Created on 27-OCT-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */
public class MainActivity extends AppCompatActivity {
    private List<Room> roomList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RoomAdapter mAdapter;

    RelativeLayout home_rl, time_rl, setting_rl, scene_rl;

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {

        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        home_rl = findViewById(R.id.home_rl);
        time_rl = findViewById(R.id.time_rl);
        scene_rl = findViewById(R.id.scene_rl);
        setting_rl = findViewById(R.id.setting_rl);

        recyclerView = findViewById(R.id.recycler_view);

        home_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_rl.setBackgroundResource(0);
            }
        });

        mAdapter = new RoomAdapter(roomList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareRoomData();
    }

    private void prepareRoomData() {
        Room room = new Room("1", "BedRoom");
        roomList.add(room);
        room = new Room("2", "Kitchen");
        roomList.add(room);
        room = new Room("1", "Bathroom");
        roomList.add(room);
        room = new Room("2", "Hall");
        roomList.add(room);
        room = new Room("1", "Dining");
        roomList.add(room);
        room = new Room("2", "Kitchen");
        roomList.add(room);
        room = new Room("1", "BedRoom");
        roomList.add(room);
        room = new Room("2", "Kitchen");
        roomList.add(room);
        room = new Room("1", "BedRoom");
        roomList.add(room);
        room = new Room("2", "Kitchen");
        roomList.add(room);
        room = new Room("1", "BedRoom");
        roomList.add(room);
        room = new Room("2", "Kitchen");
        roomList.add(room);

        mAdapter.notifyDataSetChanged();
    }
}
