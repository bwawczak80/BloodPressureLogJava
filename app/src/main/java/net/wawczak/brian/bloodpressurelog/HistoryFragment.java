package net.wawczak.brian.bloodpressurelog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class HistoryFragment extends Fragment {

    TextView logDisplay;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_history, container, false);

        logDisplay = v.findViewById(R.id.idHistoryText);
        readFile();

        return v;
    }

    public void readFile() {

        try {


            FileInputStream fileInputStream = getActivity().openFileInput("bloodPressureLog.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuffer = new StringBuilder();

            String lineItem;
            while ((lineItem = bufferedReader.readLine()) !=null) {
                stringBuffer.append(lineItem).append("\n");
            }

            logDisplay.setText(stringBuffer.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
