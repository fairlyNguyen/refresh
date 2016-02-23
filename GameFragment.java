package com.example.fairlynguyen.demoproject.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fairlynguyen.demoproject.AppDemoApplication;
import com.example.fairlynguyen.demoproject.BaseAppObserver;
import com.example.fairlynguyen.demoproject.R;
import com.example.fairlynguyen.demoproject.widget.PullToRefreshListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment implements Observer {

    private PullToRefreshListView listview;
    private List<String> mListItems;
    TextView textView;

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDemoApplication.getInstance().getObserver().addObserver(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("GameFragment", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        textView = (TextView) view.findViewById(R.id.gameTitle);
        listview = (PullToRefreshListView) view.findViewById(R.id.listview);

        mListItems = new ArrayList<String>();
        mListItems.addAll(Arrays.asList(mStrings));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, mListItems);

        listview.setAdapter(adapter);
        listview.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new GetDataTask().execute();
            }
        });
        return view;
    }

    @Override
    public void update(Observable observable, Object data) {
        Log.d("GameFragment", "update" + AppDemoApplication.getInstance().getObserver().getMeesage());
        if (AppDemoApplication.getInstance().getObserver().getMeesage().equalsIgnoreCase(BaseAppObserver.MESSAGE_UPDATE_KEY)
                || AppDemoApplication.getInstance().getObserver().getMeesage().equalsIgnoreCase(BaseAppObserver.MESSAGE_RELOAD_ALL)) {
            textView.setText(AppDemoApplication.getInstance().getObserver().getValue());
        }
    }

    private String[] mStrings = {"Andaman and Nicobar Islands",
            "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar",
            "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh",
            "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala",
            "Madhya Pradesh", "Maharashtra", "Manipur"};

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            return mStrings;
        }

        @Override
        protected void onPostExecute(String[] result) {
            mListItems.add(0, "Added new item after refresh...");
            // Call onRefreshComplete when the list has been refreshed.
            listview.onRefreshComplete();
            super.onPostExecute(result);
        }
    }
}
