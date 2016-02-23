package com.example.fairlynguyen.demoproject.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fairlynguyen.demoproject.AppDemoApplication;
import com.example.fairlynguyen.demoproject.BaseAppObserver;
import com.example.fairlynguyen.demoproject.R;

import java.util.Observable;
import java.util.Observer;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {


    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("MovieFragment", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        getViews(view);
        return view;
    }

    private void getViews(View view) {
        Button btn = (Button) view.findViewById(R.id.btnSetName);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDemoApplication.getInstance().getObserver().setMeesage(BaseAppObserver.MESSAGE_RELOAD_KEY);
                AppDemoApplication.getInstance().getObserver().setValue("hahahah");
            }
        });
        Button btn1 = (Button) view.findViewById(R.id.btnSetName1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDemoApplication.getInstance().getObserver().setMeesage(BaseAppObserver.MESSAGE_UPDATE_KEY);
                AppDemoApplication.getInstance().getObserver().setValue("Phong");
            }
        });
        Button btn2 = (Button) view.findViewById(R.id.btnSetName2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDemoApplication.getInstance().getObserver().setMeesage(BaseAppObserver.MESSAGE_RELOAD_ALL);
                AppDemoApplication.getInstance().getObserver().setValue("Hello world");
            }
        });
    }
}
