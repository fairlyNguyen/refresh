package com.example.fairlynguyen.demoproject.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fairlynguyen.demoproject.AppDemoApplication;
import com.example.fairlynguyen.demoproject.BaseAppObserver;
import com.example.fairlynguyen.demoproject.R;

import java.util.Observable;
import java.util.Observer;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment implements Observer {


    public StudyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDemoApplication.getInstance().getObserver().addObserver(this);
    }

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("StudyFragment", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_study, container, false);
        textView = (TextView) view.findViewById(R.id.studyTitle);
        return view;
    }

    @Override
    public void update(Observable observable, Object data) {
        Log.d("StudyFragment", "update");
        if (AppDemoApplication.getInstance().getObserver().getMeesage().equalsIgnoreCase(BaseAppObserver.MESSAGE_RELOAD_KEY)
                || AppDemoApplication.getInstance().getObserver().getMeesage().equalsIgnoreCase(BaseAppObserver.MESSAGE_RELOAD_ALL)) {
            textView.setText(AppDemoApplication.getInstance().getObserver().getValue());
        }
    }
}
