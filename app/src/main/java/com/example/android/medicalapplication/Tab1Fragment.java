package com.example.android.medicalapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tab1Fragment extends Fragment {
    int[] myImageList = new int[]{R.drawable.apple, R.drawable.mango,R.drawable.straw, R.drawable.pineapple,R.drawable.orange,R.drawable.blue,R.drawable.water};
    String[] myImageNameList = new String[]{"Apple","Mango" ,"Strawberry","Pineapple","Orange","Blueberry","Watermelon"};
    ArrayList<FruitModel> imageModelArrayList;
     FruitAdapter adapter;
     RecyclerView recyclerView,recyclerView2,recyclerView3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.layout,container,false);

        final FragmentActivity c = getActivity();
          recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recycler2);
        recyclerView3 = (RecyclerView) view.findViewById(R.id.recycler3);

     //   LinearLayoutManager layoutManager = new LinearLayoutManager(c);

        recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL, false));
        recyclerView3.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL, false));

        new Thread(new Runnable() {
            @Override
            public void run() {
                imageModelArrayList = eatFruits();
                adapter = new FruitAdapter(c, imageModelArrayList);
                //final FruitAdapter adapter = new FruitAdapter(c);
                c.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(adapter);
                        recyclerView2.setAdapter(adapter);
                        recyclerView3.setAdapter(adapter);

                    }
                });
            }
        }).start();

        return view;
    }
    private ArrayList<FruitModel> eatFruits(){

        ArrayList<FruitModel> list = new ArrayList<>();

        for(int i = 0; i < 7; i++){
            FruitModel fruitModel = new FruitModel();
            fruitModel.setName(myImageNameList[i]);
            fruitModel.setImage_drawable(myImageList[i]);
            list.add(fruitModel);
        }

        return list;
    }
}
