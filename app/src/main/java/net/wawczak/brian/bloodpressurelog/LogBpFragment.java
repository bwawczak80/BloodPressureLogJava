package net.wawczak.brian.bloodpressurelog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class LogBpFragment extends Fragment {

    double sys;
    double dia;
    double bpm;
    String note;
    String time;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_log_bp, container, false);
        final EditText systolic = v.findViewById(R.id.idSystolicInput);
        final EditText diastolic = v.findViewById(R.id.idDiastolicInput);
        final EditText pulse = v.findViewById(R.id.idPulseInput);
        final EditText notes = v.findViewById(R.id.idNotesInput);
        TextView timeDisplay = v.findViewById(R.id.idTimeDisplay);
        TextView logDisplay = v.findViewById(R.id.idLogDisplay);
        Button logBp = v.findViewById(R.id.btnLogBP);

        timeDisplay.setText(dateTimeStamp());

        logBp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = dateTimeStamp();
                String holdSys = systolic.getText().toString();
                String holdDia = diastolic.getText().toString();
                String holdPulse = pulse.getText().toString();
                note = notes.getText().toString();

                try {
                    sys = Double.parseDouble(holdSys);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }


            }
        });




        return v;
    }


    public String dateTimeStamp() {
        Date myDate = new Date();
        return DateFormat.getDateTimeInstance().format(myDate);
    }

}
