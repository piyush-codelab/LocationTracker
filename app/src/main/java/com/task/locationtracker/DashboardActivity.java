package com.task.locationtracker;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.task.locationtracker.fragments.FragmentMore;
import com.task.locationtracker.fragments.FragmentProfile;
import com.task.locationtracker.fragments.HomeFragment;
import com.task.locationtracker.fragments.OfflineFragment;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    HomeFragment firstFragment = new HomeFragment();
    FragmentProfile forthFragment = new FragmentProfile();
    OfflineFragment secondFragment = new OfflineFragment();
    FragmentMore thirdFragment = new FragmentMore();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_dash_board);
        BottomNavigationView bottomNavigationView2 = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
      bottomNavigationView = bottomNavigationView2;
        bottomNavigationView2.setOnNavigationItemSelectedListener(this);
      bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, this.firstFragment).commit();
            return true;
        } else if (itemId == R.id.nav_offline) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, this.secondFragment).commit();
            return true;
        } else if (itemId == R.id.nav_more) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, this.thirdFragment).commit();
            return true;
        } else if (itemId != R.id.nav_profile) {
            return false;
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, this.forthFragment).commit();
            return true;
        }
    }
}
