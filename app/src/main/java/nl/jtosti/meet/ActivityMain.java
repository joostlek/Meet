package nl.jtosti.meet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Objects;

import nl.jtosti.meet.socialMedia.Facebook;

public class ActivityMain extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();
    final Fragment fragmentScan = new FragmentScan();
    final Fragment fragmentProfile = new FragmentProfile();
    final Fragment fragmentConnected = new FragmentConnected();
    Person user;
    private static final int RC_SIGN_IN = 123;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.nav_scan:
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
                    fragmentTransaction.replace(R.id.fragment, fragmentProfile).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            Log.e("signed", "in");
        } else {
            Log.e("signed", "out");
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(Arrays.asList(new AuthUI.IdpConfig.GoogleBuilder().build())).build(), RC_SIGN_IN);
        }
        TextView textView = findViewById(R.id.textView);
        textView.setText(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName());
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}
