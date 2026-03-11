package com.example.clubiqoapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {
    public NewsFragment() {
        // Required empty public constructor
    }
    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rv=view.findViewById(R.id.news_recycler_view);
        TextView appTitle=requireActivity().findViewById(R.id.app_title);
        appTitle.setText("News");

        NewsAdapter adapter=new NewsAdapter(DataController.getNews());
        RecyclerView.LayoutManager rv_manager=new LinearLayoutManager(getContext());

        rv.setHasFixedSize(true);
        rv.setLayoutManager(rv_manager);
        rv.setAdapter(adapter);
    }
}