package org.izv.dam.newarchitecture;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.izv.dam.newarchitecture.model.data.Category;
import org.izv.dam.newarchitecture.util.LogUtil;
import org.izv.dam.newarchitecture.view.CategoryAdapter;
import org.izv.dam.newarchitecture.view.MainActivityModel;

import java.util.List;

import static org.izv.dam.newarchitecture.MainActivity.TAG;

public class FirstFragment extends Fragment {

    private MainActivityModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Log.v(LogUtil.getTag(TAG), "onCreateView");
        //así no
        //viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel = new ViewModelProvider(getActivity()).get(MainActivityModel.class);
        Log.v(LogUtil.getTag(TAG), "viewModel: " + viewModel.getPrueba());
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Log.v(LogUtil.getTag(TAG), "onViewCreated");
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvList = view.findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        final CategoryAdapter adapter = new CategoryAdapter(getActivity());
        rvList.setAdapter(adapter);

        viewModel.getLiveGetCategories().observe(getActivity(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                Log.v(LogUtil.getTag(TAG), "onChanged Live Get All");
                adapter.setCategories(categories);
            }
        });

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}
