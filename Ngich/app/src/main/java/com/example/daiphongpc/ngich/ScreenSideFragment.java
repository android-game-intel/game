package com.example.daiphongpc.ngich;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSideFragment extends Fragment {

    ViewGroup rootView;
    ProgressBar progressBar;
    int count=10;
    public ScreenSideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_side, container, false);

        return rootView;
    }
//    private void addControls() {
//        progressBar = rootView.findViewById(R.id.progressBar);
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @RequiresApi(api = Build.VERSION_CODES.N)
//                    @Override
//                    public void run() {
//                        count--;
//                        progressBar.setProgress(count);
//                        if (count == 0) {
//                            Toast.makeText(getActivity(), "hết thời gian", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        };
//        Timer timer = new Timer();
//        timer.schedule(timerTask, 0, 150);
//    }


}
