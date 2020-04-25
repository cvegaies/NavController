package org.izv.dam.newarchitecture;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import org.izv.dam.newarchitecture.util.LogUtil;
import org.izv.dam.newarchitecture.view.MainActivityModel;

import static org.izv.dam.newarchitecture.MainActivity.TAG;

public class SecondFragment extends Fragment {

    private MainActivityModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Log.v(LogUtil.getTag(TAG), "onCreateView");
        viewModel = new ViewModelProvider(getActivity()).get(MainActivityModel.class);
        Log.v(LogUtil.getTag(TAG), "viewModel: " + viewModel.getPrueba());
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Log.v(LogUtil.getTag(TAG), "onViewCreated");
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}
