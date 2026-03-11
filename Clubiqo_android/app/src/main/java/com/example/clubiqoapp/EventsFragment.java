package com.example.clubiqoapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragment extends Fragment {
    public EventsFragment() {
        // Required empty public constructor
    }
    public static EventsFragment newInstance() {
        EventsFragment fragment = new EventsFragment();
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView rv=view.findViewById(R.id.events_recycler_view);
        TextView appTitle=requireActivity().findViewById(R.id.app_title);
        appTitle.setText("Events");


        EventAdapter adapter=new EventAdapter(getParentFragmentManager(),DataController.getEvents());
        RecyclerView.LayoutManager rvManager=new LinearLayoutManager(getContext());
        rv.setHasFixedSize(true);
        rv.setLayoutManager(rvManager);
        rv.setAdapter(adapter);

    }
}