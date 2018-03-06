package com.daewichan.apitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.daewichan.apitest.data.remote.ApiService;
import com.daewichan.apitest.data.remote.AppUtility;
import com.daewichan.apitest.data.vo.StackOverModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiActivity extends AppCompatActivity {

 private RecyclerView recyclerView;

 private TitleAdapter titleAdapter;
 private ApiService mApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        mApiService= AppUtility.getService();

        recyclerView=findViewById(R.id.rv_title);

        titleAdapter=new TitleAdapter();
        recyclerView.setAdapter(titleAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadAnswer();
    }

    public void loadAnswer(){
//        mService.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
//            @Override
//            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {
//
//                if(response.isSuccessful()) {
//                    mAdapter.updateAnswers(response.body().getItems());
//                    Log.d("MainActivity", "posts loaded from API");
//                }else {
//                    int statusCode  = response.code();
//                    // handle request errors depending on status code
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
//                showErrorMessage();
//                Log.d("MainActivity", "error loading from API");
//
//            }
//        });

        mApiService.getAnswers().enqueue(new Callback<StackOverModel>() {
            @Override
            public void onResponse(Call<StackOverModel> call, Response<StackOverModel> response) {
                if (response.isSuccessful()){
                    titleAdapter.addAll(response.body().getItems());
                }
            }

            @Override
            public void onFailure(Call<StackOverModel> call, Throwable t) {

            }
        });
    }
}
