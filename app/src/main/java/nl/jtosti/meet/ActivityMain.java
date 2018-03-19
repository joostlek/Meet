package nl.jtosti.meet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class ActivityMain extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();
    final Fragment fragmentScan = new FragmentScan();
    final Fragment fragmentProfile = new FragmentProfile();
    final Fragment fragmentConnected = new FragmentConnected();

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

        Person person = new Person("Joost", "Lekkerkerker");
        Facebook facebook = new Facebook();
        person.addSocialMedia(facebook);
    }

}
