package com.example.dam2a16.examenandroid_josemartin;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void countNumber(View view){
        contador++;
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("" + contador);
    }

    public void showToast(View view){
        TextView tv = (TextView)findViewById(R.id.textView);
        Toast.makeText(this, "Count: " + tv.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void resetNumber(View view){
        contador = 0;
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("" + contador);
    }


    public void onPause() {

        super.onPause();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("clave",contador);
        editor.apply();
    }


    public void onResume(){
        super.onResume();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        contador = sp.getInt("clave", 0);

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("" + contador);
    }
}
