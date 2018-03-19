package nl.jtosti.meet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by joost on 19-3-18.
 */

public class FragmentConnected extends Fragment {
    private ArrayList<Person> people;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_connected, container, false);
        Gson gson = new Gson();
        Person person = gson.fromJson(this.getArguments().getString("connected"), Person.class);
        people = new ArrayList<>();
        people.add(person);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
