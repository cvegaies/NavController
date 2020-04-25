package org.izv.dam.newarchitecture.view;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.izv.dam.newarchitecture.model.Repository;
import org.izv.dam.newarchitecture.model.data.Category;
import org.izv.dam.newarchitecture.util.LogUtil;

import java.util.List;

import static org.izv.dam.newarchitecture.MainActivity.TAG;

public class MainActivityModel extends AndroidViewModel {

    private Repository repository;
    private String prueba = "prueba";

    public MainActivityModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public void addCategory(Category category) {
        Log.v(LogUtil.getTag(TAG), "addCategory");
        repository.addCategory(category);
    }

    public void deleteCategory(Category category) {
        Log.v(LogUtil.getTag(TAG), "deleteCategory");
        repository.deleteCategory(category);
    }

    public void deleteCategory(long id) {
        Log.v(LogUtil.getTag(TAG), "deleteCategory");
        repository.deleteCategory(id);
    }

    public void editCategory(Category category) {
        Log.v(LogUtil.getTag(TAG), "editCategory");
        repository.editCategory(category);
    }

    public void getCategories() {
        Log.v(LogUtil.getTag(TAG), "getCategories");
        repository.getCategories();
    }

    public void getCategory(int id) {
        Log.v(LogUtil.getTag(TAG), "getCategory");
        repository.getCategory(id);
    }

    public MutableLiveData<Long> getLiveAddCategory() {
        return repository.getLiveAddCategory();
    }

    public MutableLiveData<Integer> getLiveDeleteCategory() {
        return repository.getLiveDeleteCategory();
    }

    public MutableLiveData<Boolean> getLiveEditCategory() {
        return repository.getLiveEditCategory();
    }

    public MutableLiveData<List<Category>> getLiveGetCategories() {
        return repository.getLiveGetCategories();
    }

    public MutableLiveData<Category> getLiveGetCategory() {
        return repository.getLiveGetCategory();
    }
}