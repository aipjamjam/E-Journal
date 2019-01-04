package com.example.journalUIN.recycleviewAPI;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView judul_det, nama_det, url_det, last_det;
    String jdl, nm, urll, lastt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        judul_det = findViewById(R.id.judul_det);
        nama_det = findViewById(R.id.nama_det);
        url_det = findViewById(R.id.url_det);
        last_det = findViewById(R.id.last_det);

        Intent terima = getIntent();

        //get
        nm = getIntent().getStringExtra("path");
        jdl = getIntent().getStringExtra("set_val");
        urll = getIntent().getStringExtra("url");
        lastt = getIntent().getStringExtra("lastissue");


        //set
        judul_det.setText(jdl);
        nama_det.setText(nm);
        url_det.setText(urll);
        last_det.setText(lastt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings1) {
            Intent intent = new Intent(DetailActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.action_settings2) {
            String nomor = "087828170177";
            Intent i = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",nomor,null));
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void open_jurnal(View view) {
        String alamat = urll;
        Uri webpage = Uri.parse(alamat);
        Intent i = new Intent(Intent.ACTION_VIEW,webpage);
        startActivity(i);
    }
}
