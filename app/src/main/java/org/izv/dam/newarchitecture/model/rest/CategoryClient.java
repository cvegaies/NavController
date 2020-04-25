package org.izv.dam.newarchitecture.model.rest;

import org.izv.dam.newarchitecture.model.data.Category;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CategoryClient {

    @DELETE("category/{id}")
    Call<Integer> delete(@Path("id") long id);

    @GET("category/{id}")
    Call<Category> get(@Path("id") long id);

    @GET("category")
    Call<ArrayList<Category>> getAll();

    @POST("category")
    Call<Long> post(@Body Category category);

    @PUT("category/{id}")
    Call<Boolean> put(@Path("id") long id, @Body Category category);

}