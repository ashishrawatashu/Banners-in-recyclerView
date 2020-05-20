package com.example.cynoteck;

import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home extends Fragment {

    DrawerLayout dl;
    View view;

    RecyclerView listRV;

    public Home(DrawerLayout drawer) {
        this.dl = drawer;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        listRV = view.findViewById(R.id.listRV);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        listRV.setLayoutManager(linearLayoutManager2);
        listRV.setAdapter(new BannerAdapter(listItems(),getContext()));

        return view;
    }

    private List<RecyclerViewItems> listItems() {
        List<RecyclerViewItems> recyclerViewItems = new ArrayList<>();

        int[] images = {
                R.drawable.first,
                R.drawable.sec,
                R.drawable.third,
                R.drawable.fourth,
                R.drawable.fifth,
                R.drawable.sixth,
                R.drawable.seventh
        };
        String[] name = {"Ashish Rawat",
                "Rohit Bisht",
                "Shikhar Chahan",
                "Anshuman Gaur",
                "Sudesh Bhatt",
                "Namrata Kaur",
                "Deepak Bisht"};

        String[] id = {"CYN001",
                "CYN002",
                "CYN003",
                "CYN004",
                "CYN005",
                "CYN006",
                "CYN007"};

        String[] descriptions = {
                "this first 1st Employee",
                "this first 2nd Employee",
                "this first 3th Employee",
                "this first 4th Employee",
                "this first 5th Employee",
                "this first 6th Employee",
                "this first 7th Employee"};


        for (int i = 0; i < name.length; i++) {
            ListItems listItems = new ListItems(name[i], id[i], descriptions[i],images[i]);
            recyclerViewItems.add(listItems);
            if (i==2||i==4) {
                Header header = new Header("CYNOTECK");
                recyclerViewItems.add(header);
            }
        }
        return recyclerViewItems;
    }

}
