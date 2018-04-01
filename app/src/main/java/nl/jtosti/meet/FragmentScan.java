package nl.jtosti.meet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;

public class FragmentScan extends Fragment {
    private ArrayList<Person> people;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_connected, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Gson gson = new Gson();
        Person person = gson.fromJson(this.getArguments().getString("connected"), Person.class);
        people = new ArrayList<>();
        people.add(person);
        super.onViewCreated(view, savedInstanceState);
    }
}
