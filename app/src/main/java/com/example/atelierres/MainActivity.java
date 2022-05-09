package com.example.atelierres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText e;
    Button b1, b2;
    RadioGroup grp;
    TextView tres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        e = findViewById(R.id.eval);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        grp = findViewById(R.id.grp);
        tres = findViewById(R.id.tres);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Valeur vide", Toast.LENGTH_SHORT).show();
                    return;
                }
                double val= Double.parseDouble(e.getText().toString());
                int taux = 0;
                if(grp.getCheckedRadioButtonId()==R.id.rd1){
                    taux = getResources().getInteger(R.integer.dollar_taux);
                    tres.setText(String.format(getString(R.string.texte_res1),val/taux));
                }else {
                    taux = getResources().getInteger(R.integer.euro_taux);
                    tres.setText(String.format(getString(R.string.texte_res2),val/taux));
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.getText().clear();
                grp.check(R.id.rd2);
                tres.setText(getString(R.string.default_res));
                e.requestFocus();
            }
        });
    }
}