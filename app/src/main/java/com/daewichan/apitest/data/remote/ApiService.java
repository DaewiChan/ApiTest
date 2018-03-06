package com.daewichan.apitest.data.remote;

import com.daewichan.apitest.data.vo.StackOverModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by daewichan on 3/2/18.
 */

public interface ApiService {

    @GET("answers?order=desc&sort=activity&site=stackoverflow")
    Call<StackOverModel> getAnswers();
//
//    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
//    Call<SOAnswersResponse> getAnswers(@Query("tagged") String tags);
}
