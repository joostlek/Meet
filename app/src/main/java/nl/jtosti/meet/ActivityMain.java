package nl.jtosti.meet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;



public class ActivityMain extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();
    Person user;
    private static final int RC_SIGN_IN = 123;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.nav_scan:
                    FragmentScan fragmentScan = new FragmentScan();
                    fragmentTransaction.replace(R.id.fragment, fragmentScan).commit();
                    return true;
                case R.id.nav_connected:
                    Bundle arguments = new Bundle();
                    Gson gson = new Gson();
                    arguments.putString("connected", gson.toJson(user));
                    FragmentConnected fragmentConnected = new FragmentConnected();
                    fragmentConnected.setArguments(arguments);
                    fragmentTransaction.replace(R.id.fragment, fragmentConnected).commit();
                    return true;
                case R.id.nav_profile:
                    FragmentProfile fragmentProfile = new FragmentProfile();
                    fragmentTransaction.replace(R.id.fragment, fragmentProfile).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivity(new Intent(this, ActivityLaunch.class));
        }
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("user")
                .add(new Person(user.getDisplayName(), user.getEmail()))
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        TextView textView = findViewById(R.id.textView);
                        textView.setText("added");
                    }
                });
    }


}
