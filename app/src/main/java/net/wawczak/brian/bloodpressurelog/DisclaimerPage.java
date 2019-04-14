package net.wawczak.brian.bloodpressurelog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class DisclaimerPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer_page);

        Button enter = findViewById(R.id.btnEnter);
        final CheckBox agree = findViewById(R.id.idCheckBox);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (agree.isChecked()) {
                    startActivity(new Intent(DisclaimerPage.this, MainActivity.class));
                }else{

                    agree.setTextColor(getResources().getColor(R.color.bpRed));
                }

            }
        });
    }
}
