package com.example.clubiqoapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailedEventFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailedEventFragment extends Fragment {

    private static final String ARG_EVENTID = "event id";
    private static final String ARG_EVENTTITLE = "event title";
    private static final String ARG_EVENTDESC = "event description";
    private static final String ARG_EVENTIMG = "event image";
    private static final String ARG_EVENTCOVER = "event cover image";
    private static final String ARG_EVENTLOC = "event location";
    private static final String ARG_EVENTLOCLINK = "event location link";
    private static final String ARG_EVENTDATE = "event date";
    private static final String ARG_EVENTFEES = "event fees";
    private static final String ARG_EVENTMAX= "event max participations";

    private String eventTitle;

    private String eventId;
    private String eventDesc ;
    private int eventImg;
    private int eventCover;
    private String eventLoc ;
    private String eventLocLink;
    private LocalDateTime eventDate;
    private float eventFees;
    private int eventMax;

    public DetailedEventFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DetailedEventFragment newInstance(String eventId,String eventTitle,
                                                    String eventDesc ,int eventImg,
                                                    int eventCover, String eventLoc ,
                                                    String eventLocLink, LocalDateTime eventDate,
                                                    float eventFees, int eventMax) {

        DetailedEventFragment fragment = new DetailedEventFragment();
        Bundle args = new Bundle();;
        args.putString(ARG_EVENTID,eventId);
        args.putString(ARG_EVENTTITLE, eventTitle);
        args.putString(ARG_EVENTDESC, eventDesc);
        args.putInt(ARG_EVENTIMG , eventImg);
        args.putInt(ARG_EVENTCOVER, eventCover);
        args.putString(ARG_EVENTLOC , eventLoc);
        args.putString(ARG_EVENTLOCLINK , eventLocLink);
        args.putString(ARG_EVENTDATE, eventDate.toString());
        args.putFloat(ARG_EVENTFEES, eventFees);
        args.putInt(ARG_EVENTMAX, eventMax);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle args = getArguments();

            this.eventTitle = args.getString(ARG_EVENTTITLE);
            this.eventDesc = args.getString(ARG_EVENTDESC);
            this.eventCover = args.getInt(ARG_EVENTCOVER);
            this.eventLoc = args.getString(ARG_EVENTLOC);
            this.eventLocLink = args.getString(ARG_EVENTLOCLINK);

            this.eventImg = args.getInt(ARG_EVENTIMG);
            this.eventMax = args.getInt(ARG_EVENTMAX);
            this.eventFees = args.getFloat(ARG_EVENTFEES);

            this.eventDate = LocalDateTime.parse(args.getString(ARG_EVENTDATE));
            this.eventId=args.getString(ARG_EVENTID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed_event, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView img=view.findViewById(R.id.devent_image);
        img.setImageResource(eventImg);
        ImageView coverImg=view.findViewById(R.id.devent_cover);
        coverImg.setImageResource(eventCover);
        TextView title=view.findViewById(R.id.devent_title);
        title.setText(eventTitle);
        TextView desc=view.findViewById(R.id.devent_description);
        desc.setText(eventDesc);
        TextView date=view.findViewById(R.id.devent_date);
        date.setText(eventDate.toString());
        TextView loc=view.findViewById(R.id.devent_location);
        loc.setText(eventLoc);
        TextView fees=view.findViewById(R.id.dfees);
        fees.setText(Float.toString(eventFees)+" TND");
        TextView max=view.findViewById(R.id.dmax_part);
        max.setText(Integer.toString(eventMax));

        ImageButton back=view.findViewById(R.id.dvback_button);
        Button register=view.findViewById(R.id.register_button);
        Button confirm=view.findViewById(R.id.confirm_button);
        Button cancel=view.findViewById(R.id.cancel_button);



        if(((MainActivity) requireActivity()).getUserRole().equals("visitor")){
            confirm.setVisibility(View.GONE);
            register.setVisibility(View.GONE);
            cancel.setVisibility(View.GONE);

        }else{
            Participation part=DataController.getParticipationInfo(TokenManager.readToken(requireContext()).getToken(),this.eventId);
            if(part==null){
                confirm.setVisibility(View.GONE);
                register.setVisibility(View.VISIBLE);
                cancel.setVisibility(View.GONE);
            }else if(part.getAttendanceStatus().equals("registered")){
                confirm.setVisibility(View.VISIBLE);
                register.setVisibility(View.GONE);
                cancel.setVisibility(View.VISIBLE);
            }else if(part.getAttendanceStatus().equals("confirmed")){
                confirm.setVisibility(View.VISIBLE);
                register.setVisibility(View.GONE);
                confirm.setText("Confirmed");
                confirm.setEnabled(false);
                cancel.setVisibility(View.GONE);
            }else if(part.getAttendanceStatus().equals("present")){
                confirm.setVisibility(View.VISIBLE);
                register.setVisibility(View.GONE);
                cancel.setVisibility(View.GONE);
                confirm.setText("Present");
                confirm.setEnabled(false);
            }else{
                confirm.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                cancel.setVisibility(View.GONE);
            }
        }

        register.setOnClickListener(v->{
            register.setVisibility(View.GONE);
            confirm.setVisibility(View.VISIBLE);
            cancel.setVisibility(View.VISIBLE);

            if(DataController.registerInEvent(TokenManager.readToken(requireContext()).getToken(),this.eventId)){
                Snackbar.make(v, "Regsitered succecfully!",Snackbar.LENGTH_LONG).show();
            }else{
                Snackbar.make(v, "Something went wrong.",Snackbar.LENGTH_LONG).show();
            }


        });

        confirm.setOnClickListener(v->{
            register.setVisibility(View.GONE);
            confirm.setVisibility(View.VISIBLE);
            confirm.setText("Confirmed");
            confirm.setEnabled(false);
            cancel.setVisibility(View.GONE);

            if(DataController.confirmRegistration(TokenManager.readToken(requireContext()).getToken(),this.eventId)){
                Snackbar.make(v, "Confirmed succecfully!",Snackbar.LENGTH_LONG).show();
            }else{
                Snackbar.make(v, "Something went wrong.",Snackbar.LENGTH_LONG).show();
            }

        });

        cancel.setOnClickListener(v->{
            register.setVisibility(View.VISIBLE);
            confirm.setVisibility(View.GONE);
            cancel.setVisibility(View.GONE);

            if(DataController.cancelRegistration(TokenManager.readToken(requireContext()).getToken(),this.eventId)){
                Snackbar.make(v, "Canceled succecfully!",Snackbar.LENGTH_LONG).show();
            }else{
                Snackbar.make(v, "Something went wrong.",Snackbar.LENGTH_LONG).show();
            }
        });



        back.setOnClickListener(v -> {
            Fragment homePageFragment=HomePageFragment.newInstance(
                    "events"
            );
            ((MainActivity) requireActivity()).replaceFrag(homePageFragment);
        });
    }
}