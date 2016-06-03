package com.example.marcos.appbird;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.marcos.appbird.Activity.SecondActivity;
import com.example.marcos.appbird.Adapter.AveAdapter;
import com.example.marcos.appbird.DataBase.Conexion;

import java.util.ArrayList;


public class OneFragment extends Fragment{

    public OneFragment() {
        // Required empty public constructor
    }
    private ViewPager mViewPager;
    private ArrayList<Ave> avelist;
    private AveAdapter adapter;
    private GridView mView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_main2,container,false);
        mView = (GridView) view.findViewById(R.id.gridview);
        Conexion databaseHelper = new Conexion(getContext());

        avelist = new ArrayList<Ave>();
        avelist = databaseHelper.getAllAves();

        adapter = new AveAdapter(getActivity().getBaseContext(), avelist);

        mView.setAdapter(adapter);
        mView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), SecondActivity.class);
                i.putExtra("id", position);
                startActivity(i);
            }
        });
        return view;
    }

}
