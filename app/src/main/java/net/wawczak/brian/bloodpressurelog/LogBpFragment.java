package net.wawczak.brian.bloodpressurelog;

import android.content.Context;
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
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class LogBpFragment extends Fragment {

    double sys;
    double dia;
    double bpm;
    String note;
    String time;

    Context thisContext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_log_bp, container, false);
        thisContext = container.getContext();


        final EditText systolic = v.findViewById(R.id.idSystolicInput);
        final EditText diastolic = v.findViewById(R.id.idDiastolicInput);
        final EditText pulse = v.findViewById(R.id.idPulseInput);
        final EditText notes = v.findViewById(R.id.idNotesInput);
        final TextView timeDisplay = v.findViewById(R.id.idTimeDisplay);
        final TextView logDisplay = v.findViewById(R.id.idLogDisplay);
        Button logBp = v.findViewById(R.id.btnLogBP);

        timeDisplay.setText(dateTimeStamp());

        logBp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                time = dateTimeStamp();
                timeDisplay.setText(time);
                String holdSys = systolic.getText().toString();
                String holdDia = diastolic.getText().toString();
                String holdPulse = pulse.getText().toString();
                note = notes.getText().toString();

                try {
                    sys = Double.parseDouble(holdSys);
                    dia = Double.parseDouble(holdDia);
                    bpm = Double.parseDouble(holdPulse);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    sys = 0;
                    dia = 0;
                    bpm = 0;
                }

                if(validateData(sys, dia, bpm)) {
                    int warningLabel = calculateBpWarning(sys, dia);

                    switch (warningLabel) {
                        case 1:
                            logDisplay.setText(getString(R.string.caseOneWarning));
                            logDisplay.setBackgroundColor(getResources().getColor(R.color.bpGreen));
                            break;
                        case 2:
                            logDisplay.setText(getString(R.string.caseTwoWarning));
                            logDisplay.setBackgroundColor(getResources().getColor(R.color.bpYellow));
                            break;
                        case 3:
                            logDisplay.setText(getString(R.string.caseThreeWarning));
                            logDisplay.setBackgroundColor(getResources().getColor(R.color.bpLightOrange));
                            break;
                        case 4:
                            logDisplay.setText(getString(R.string.caseFourWarning));
                            logDisplay.setBackgroundColor(getResources().getColor(R.color.bpDarkOrange));
                            break;
                        case 5:
                            logDisplay.setText(getString(R.string.caseFiveWarning));
                            logDisplay.setBackgroundColor(getResources().getColor(R.color.bpYellow));
                            break;
                        case 6:
                            logDisplay.setText(getString(R.string.caseSixWarning));
                            logDisplay.setBackgroundColor(getResources().getColor(R.color.bpRed));
                            break;
                    }
                }else {
                    toastMessage("The information you entered is not valid. Please try again");
//                    logDisplay.setText(getString(R.string.errorMsg));
                    logDisplay.setBackgroundColor(getResources().getColor(R.color.bpSlate));
                }


            }
        });


        return v;
    }

    public  int calculateBpWarning(double s, double d) {
        int bpWarningLevel = 0;
        if (s < 120 && d < 80 && s >= 100 && d >= 60){
            bpWarningLevel = 1;  // "Your Blood Pressure is Normal"
        }else if (s >= 120 && s < 130 && d <= 80 || s < 120 && d <= 80){
            bpWarningLevel = 2; // "Your Blood Pressure is Elevated
        }else if (s >= 130 && s < 140 && d < 89 || d > 80 && d < 89){
            bpWarningLevel = 3; // "Stage 1 hypertension"
        } else if (s >= 140 && s < 180 && d < 120 || d >= 90 && d < 120) {
            bpWarningLevel = 4;  // "Stage 2 hypertension"
        }else if (s < 100 || d < 60){
            bpWarningLevel = 5; // "Low Blood Pressure"
        }else if (s >= 180 || d >= 120)
            bpWarningLevel = 6; // "Hypertensive Crisis"
        return bpWarningLevel;
    }

    public String dateTimeStamp() {
        Date myDate = new Date();
        return DateFormat.getDateTimeInstance().format(myDate);
    }

    public boolean validateData(double s, double d, double p) {
        if (s <= 0 || d <= 0 || p <= 0) {
            return false;
        }else if (s <= d){
            return false;
        }else return !(s >= 500) && !(d >= 300) && !(p >= 300);

    }
    private void toastMessage(String message){
        Toast.makeText(thisContext,message, Toast.LENGTH_SHORT).show();
    }


}
