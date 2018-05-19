package com.example.root.alat_hitung;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tinggi)
    EditText iTinggi;
    @BindView(R.id.alas)
    EditText iAlas;
    @BindView(R.id.cari)
    Button cari;
    @BindView(R.id.clear)
    Button clear;

    @BindView(R.id.hasilKeliling)
    TextView hasilKeliling;
    @BindView(R.id.hasilLuas)
    TextView hasilLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.cari, R.id.clear})
    public void onViewClicked(View view) {
        String textTinggi = iTinggi.getText().toString();
        String textAlas = iAlas.getText().toString();


            switch (view.getId()) {
                case R.id.cari:
                    if (!TextUtils.isEmpty(textTinggi) && !TextUtils.isEmpty(textAlas)) {

                        int dTinggi = Integer.parseInt(textTinggi);
                        int dAlas = Integer.parseInt(textAlas);
                        double luas = (dAlas * dTinggi )/2;
                        double sisimiring = (dAlas/2)*(dAlas/2)+(dTinggi+dTinggi);
                        double hasilsisimiring = Math.sqrt(sisimiring);
                        double keliling = hasilsisimiring + hasilsisimiring + dAlas;

                        hasilKeliling.setText(String.valueOf("Keliling :\n"+keliling));
                        hasilLuas.setText(String.valueOf("Luas :\n"+luas));

                        iAlas.setText("");
                        iTinggi.setText("");
                    }
                        else {
                        Toast.makeText(this, "Nggak boleh kosong", Toast.LENGTH_SHORT).show();
                    }

                    break;
                case R.id.clear:
                    hasilKeliling.setText("");
                    hasilLuas.setText("");
                    break;
            }
    }

    @Override
    public void onBackPressed(){

        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Keluar");
        alert.setMessage("Keluar Sekarang");

        alert.setNegativeButton("Keluar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                finish();
            }
        });

        alert.setPositiveButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        alert.show();
    }

}
