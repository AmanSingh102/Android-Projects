package com.example.api;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<MyData> call = apiInterface.getProductData();

        call.enqueue(new Callback<MyData>() {
            @Override
            public void onResponse(@NonNull Call<MyData> call, @NonNull Response<MyData> response) {

                if (response.isSuccessful() && response.body() != null) {

                    List<Product> productList = response.body().getProducts();

                    myAdapter = new MyAdapter(MainActivity.this, productList);
                    recyclerView.setAdapter(myAdapter);

                } else {
                    Log.d("MainActivity", "Response failed");
                }
            }

            @Override
            public void onFailure(@NonNull Call<MyData> call, @NonNull Throwable t) {
                Log.d("MainActivity", "Error: " + t.getMessage());
            }
        });
    }
}