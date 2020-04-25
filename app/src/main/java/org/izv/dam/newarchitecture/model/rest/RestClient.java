package org.izv.dam.newarchitecture.model.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private final static String URL = "http://informatica.ieszaidinvergeles.org:90XX/category/api/";

    private Retrofit retrofit;

    public RestClient() {
        //ojo
        //https://github.com/square/okhttp/issues/4597
        //build.gradle (módulo)
        //compileOptions {
        //    targetCompatibility = "8"
        //    sourceCompatibility = "8"
        //}
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public CategoryClient getCategoryClient() {
        return retrofit.create(CategoryClient.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}