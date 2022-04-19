package com.example.aplikasisistempenjualan;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText editnamapel,editnamabrg,editjumlahbeli,editharga,edituangbayar;
    private Button btnproses,btnexit,btnreset;
    private TextView txtnamapel,txtnamabrg,txtjumlahbeli,txtharga,txtuangbayar,txttotalbelanja,txtuangkembali,txtbonus,txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("ANGGA  FIRNANDA  ADIDAS  STORE");

        editnamapel = (EditText) findViewById(R.id.namapembeli);
        editnamabrg = (EditText) findViewById(R.id.namabrg);
        editjumlahbeli = (EditText) findViewById(R.id.jumlahbeli);
        editharga = (EditText) findViewById(R.id.harga);
        edituangbayar = (EditText) findViewById(R.id.uangbayar);
        btnproses = (Button) findViewById(R.id.tombol1);
        btnreset = (Button) findViewById(R.id.tombol2);
        btnexit = (Button) findViewById(R.id.tombol3);

        txtnamapel = (TextView) findViewById(R.id.namapembeli);
        txtnamabrg = (TextView) findViewById(R.id.namabrg);
        txtjumlahbeli = (TextView) findViewById(R.id.jumlahbeli);
        txtharga = (TextView) findViewById(R.id.harga);
        txtuangbayar = (TextView) findViewById(R.id.uangbayar);
        txttotalbelanja = (TextView) findViewById(R.id.totalbelanja);
        txtuangkembali = (TextView) findViewById(R.id.uangkembali);
        txtbonus = (TextView) findViewById(R.id.bonus);
        txtketerangan = (TextView) findViewById(R.id.keterangan);

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namapelanggan = editnamapel.getText().toString().trim();
                String namabrg = editnamabrg.getText().toString().trim();
                String jumlahbeli = editjumlahbeli.getText().toString().trim();
                String harga = editharga.getText().toString().trim();
                String uangbayar = edituangbayar.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = jb*h;
                txttotalbelanja.setText("Total Belanja : "+total);

                if (total>=200000){
                    txtbonus.setText("Bonus : SEPATU");
                }else if (total>=50000){
                    txtbonus.setText("Bonus : KAOS");
                }else if (total>=40000){
                    txtbonus.setText("Bonus : CELANA JEANS");
                }else{
                    txtbonus.setText("Bonus : TOPI");
                }
                double uangkembali = (ub-total);
                if (ub<total){
                    txtketerangan.setText("Keterangan : Uang bayar kurang Rp. "+ (-uangkembali));
                    txtuangkembali.setText("Uang Kembali : Rp. 0");
                }else{
                    txtketerangan.setText("Keterangan : Tunggu Kembalian");
                    txtuangkembali.setText("Uang Kembali : Rp. "+uangkembali);
                }

                btnreset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtnamapel.setText("");
                        txtnamabrg.setText("");
                        txtjumlahbeli.setText("");
                        txtharga.setText("");
                        txtuangbayar.setText("");
                        txtuangkembali.setText("Uang Kembali : Rp.0");
                        txttotalbelanja.setText("Total Belanja : Rp.0");
                        txtbonus.setText("Bonus : -");
                        txtketerangan.setText("Keterangan : ");

                        Toast.makeText(getApplicationContext(), "Data sudah direset",Toast.LENGTH_LONG).show();
                    }
                });

                btnexit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        moveTaskToBack(true);
                    }
                });
            }
        });
    }
}