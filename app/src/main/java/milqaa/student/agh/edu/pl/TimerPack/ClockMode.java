package milqaa.student.agh.edu.pl.TimerPack;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import milqaa.student.agh.edu.pl.TimerPack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClockMode extends Fragment {
    private int clockID;

    public ClockMode() {
        // Required empty public constructor
    }
    public void setClockID(int id){
        clockID = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clock_mode, container, false);
    }

}
