package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button calc;
    EditText pa;
    SeekBar year;
    Spinner roi;
    TextView result;
    int n;
    double p,r,amount=0;
    String[] rates={"1.5","2.0","2.5","3.0","5.0","6.0","7.0","14.0"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roi= (Spinner) findViewById(R.id.spin);
        year= (SeekBar) findViewById(R.id.bar);
        pa=(EditText)findViewById(R.id.amt);

        result=(TextView)findViewById(R.id.res);
        calc=(Button) findViewById(R.id.b1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, rates);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roi.setAdapter(adapter);
        year.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                n=progress;

                Toast.makeText(MainActivity.this, String.valueOf(n),
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void dispEvent(View view) {
        p=Double.parseDouble(pa.getText().toString());
        r=Double.parseDouble(roi.getSelectedItem().toString());
        r=r/12/100;
        n=n*12;

        amount =p*r* Math.pow((1+r),n )/(Math.pow((1+r),n)-1);

        result.setText("Amount to be paid\r\n"+ String.format("%.2f", amount));
    }
}