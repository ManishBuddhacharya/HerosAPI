package com.example.herosapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.HeroAdapter;
import heroesapi.HeroesAPI;
import model.Heroes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class HeroesActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    List<Heroes> heroList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);

        rvHeroes= findViewById(R.id.rvHeroes);

        HeroesAPI heroAPI = Url.getInstance().create(HeroesAPI.class);

        Call<List<Heroes>> listCall = heroAPI.getAllHeroes();

        listCall.enqueue(new Callback<List<Heroes>>() {
            @Override
            public void onResponse(Call<List<Heroes>> call, Response<List<Heroes>> response) {

                generateList(response.body());

            }

            @Override
            public void onFailure(Call<List<Heroes>> call, Throwable t) {
                Toast.makeText(HeroesActivity.this, "Error : "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }

    private void generateList(List<Heroes> body) {
        List<Heroes> heroList = body;

        for (Heroes hero: heroList){
            heroList.add(new Heroes(hero.getName(), hero.getDesc(), hero.getImage()));
        }
        HeroAdapter heroAdapter = new HeroAdapter(this, heroList);
        rvHeroes.setAdapter(heroAdapter);
        rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void getHeroes() {

    }
}
