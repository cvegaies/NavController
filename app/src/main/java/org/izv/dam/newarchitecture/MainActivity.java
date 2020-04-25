package org.izv.dam.newarchitecture;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.izv.dam.newarchitecture.model.data.Category;
import org.izv.dam.newarchitecture.util.LogUtil;
import org.izv.dam.newarchitecture.view.MainActivityModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = MainActivity.class.getCanonicalName();

    private MainActivityModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(LogUtil.getTag(TAG), "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewModel = new ViewModelProvider(this).get(MainActivityModel.class);

        //comprobar uso del mismo ViewModel con los fragmentos
        viewModel.setPrueba("new");
        Log.v(LogUtil.getTag(TAG), "viewModel: " + viewModel.getPrueba());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(LogUtil.getTag(TAG), "onClick");
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //sólo de prueba
        defineObservers();
        pruebas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.v(LogUtil.getTag(TAG), "onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v(LogUtil.getTag(TAG), "onOptionsItemSelected");
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void defineObservers() {
        viewModel.getLiveAddCategory().observe(this, new Observer<Long>() {
            //aquí es cuando realmente me entero si se ha ejecutado correctamente la operación
            @Override
            public void onChanged(Long aLong) {
                Log.v(LogUtil.getTag(TAG), "onChanged Live Add");
            }
        });
        viewModel.getLiveDeleteCategory().observe(this, new Observer<Integer>() {
            //aquí es cuando realmente me entero si se ha ejecutado correctamente la operación
            @Override
            public void onChanged(Integer integer) {
                Log.v(LogUtil.getTag(TAG), "onChanged Live Delete");
            }
        });
        viewModel.getLiveEditCategory().observe(this, new Observer<Boolean>() {
            //aquí es cuando realmente me entero si se ha ejecutado correctamente la operación
            @Override
            public void onChanged(Boolean bool) {
                Log.v(LogUtil.getTag(TAG), "onChanged Live Edit");
            }
        });
        viewModel.getLiveGetCategories().observe(this, new Observer<List<Category>>() {
            //aquí es cuando realmente me entero si se ha ejecutado correctamente la operación
            @Override
            public void onChanged(List<Category> categories) {
                Log.v(LogUtil.getTag(TAG), "onChanged Live Get All");
            }
        });
        viewModel.getLiveGetCategory().observe(this, new Observer<Category>() {
            //aquí es cuando realmente me entero si se ha ejecutado correctamente la operación
            @Override
            public void onChanged(Category category) {
                Log.v(LogUtil.getTag(TAG), "onChanged Live Get");
            }
        });
    }

    private void pruebas() {
        //inserta a mano 2 categorías en la tabla category (Phpmyadmin)
        //1ª prueba: getAll
        viewModel.getCategories();

        //2ª prueba: get(id)
        //viewModel.getCategory(1);
        //viewModel.getCategory(2);
        //viewModel.getCategory(3); //no existe, qu'e resultado se obtiene?

        //3ª prueba: add
        //viewModel.addCategory(new Category(0, "new category"));

        //4ª prueba: edit
        //para que funcione tiene que existir un elemento con id 3
        //la forma correcta de ejecutar esta prueba, sería obtener el elemento con el id 3
        //y una vez obtenido, modificarlo y ejecutar el edit
        //Category category = new Category(3, "new category");
        //category.setCategory("newest catergory");
        //viewModel.editCategory(category);

        //5ª prueba: delete
        //viewModel.deleteCategory(3);
    }
}