package org.izv.dam.newarchitecture.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import org.izv.dam.newarchitecture.model.data.Category;
import org.izv.dam.newarchitecture.model.rest.CategoryClient;
import org.izv.dam.newarchitecture.model.rest.RestClient;
import org.izv.dam.newarchitecture.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.izv.dam.newarchitecture.MainActivity.TAG;

public class Repository {

    private CategoryClient categoryClient;

    private MutableLiveData<Long> liveAddCategory = new MutableLiveData();
    private MutableLiveData<Integer> liveDeleteCategory = new MutableLiveData();
    private MutableLiveData<Boolean> liveEditCategory = new MutableLiveData();
    private MutableLiveData<List<Category>> liveGetCategories = new MutableLiveData();
    private MutableLiveData<Category> liveGetCategory = new MutableLiveData();

    public Repository() {
        RestClient restClient = new RestClient();
        categoryClient = restClient.getCategoryClient();
    }

    public void addCategory(Category category) {
        Log.v(LogUtil.getTag(TAG), "addCategory");
        Call<Long> call = categoryClient.post(category);
        call.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Log.v(LogUtil.getTag(TAG), "add: " + response.body().toString());
                liveAddCategory.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                Log.v(LogUtil.getTag(TAG), "add: " + t.getLocalizedMessage());
            }
        });
    }

    public void deleteCategory(Category category) {
        deleteCategory(category.getId());
    }

    public void deleteCategory(long id) {
        Log.v(LogUtil.getTag(TAG), "deleteCategory");
        Call<Integer> call = categoryClient.delete(id);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Log.v(LogUtil.getTag(TAG), "delete: " + response.body().toString());
                liveDeleteCategory.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.v(LogUtil.getTag(TAG), "delete: " + t.getLocalizedMessage());
            }
        });
    }

    public void editCategory(Category category) {
        Log.v(LogUtil.getTag(TAG), "editCategory");
        Call<Boolean> call = categoryClient.put(category.getId(), category);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Log.v(LogUtil.getTag(TAG), "edit: " + response.body().toString());
                liveEditCategory.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.v(LogUtil.getTag(TAG), "edit: " + t.getLocalizedMessage());
            }
        });
    }

    public void getCategories() {
        Log.v(LogUtil.getTag(TAG), "getCategories");
        Call<ArrayList<Category>> call = categoryClient.getAll();
        call.enqueue(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                Log.v(LogUtil.getTag(TAG), "getAll: " + response.body().toString());
                liveGetCategories.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                Log.v(LogUtil.getTag(TAG), "getAll: " + t.getLocalizedMessage());
            }
        });
    }

    public void getCategory(int id) {
        Log.v(LogUtil.getTag(TAG), "getCategory");
        Call<Category> call = categoryClient.get(id);
        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                Log.v(LogUtil.getTag(TAG), "get: " + response.body().toString());
                liveGetCategory.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Log.v(LogUtil.getTag(TAG), "get: " + t.getLocalizedMessage());
            }
        });
    }

    public MutableLiveData<Long> getLiveAddCategory() {
        return liveAddCategory;
    }

    public MutableLiveData<Integer> getLiveDeleteCategory() {
        return liveDeleteCategory;
    }

    public MutableLiveData<Boolean> getLiveEditCategory() {
        return liveEditCategory;
    }

    public MutableLiveData<List<Category>> getLiveGetCategories() {
        return liveGetCategories;
    }

    public MutableLiveData<Category> getLiveGetCategory() {
        return liveGetCategory;
    }
}