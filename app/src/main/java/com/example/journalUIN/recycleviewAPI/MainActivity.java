package com.example.journalUIN.recycleviewAPI;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView label;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Buah> contacts;
    private BuahAdapter adapter;
    private ApiInterface apiInterface;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.prograss);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchContact("users");
    }

    public void fetchContact(String type){

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Buah>> call = apiInterface.getBuah(type);
        call.enqueue(new Callback<List<Buah>>() {
            @Override
            public void onResponse(Call<List<Buah>> call, Response<List<Buah>> response) {
                progressBar.setVisibility(View.GONE);
                contacts = response.body();
                adapter = new BuahAdapter(contacts, MainActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Buah>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error\n"+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
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
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.action_settings2) {
            String nomor = "087828170177";
            Intent i = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",nomor,null));
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
