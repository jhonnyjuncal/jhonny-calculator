package com.jhonny.timecalculator.component;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.jhonny.timecalculator.activity.AcercaActivity;
import com.jhonny.timecalculator.activity.CalcSemanalActivity;
import com.jhonny.timecalculator.activity.PrincipalActivity;
import com.jhonny.timecalculator.timecalculator.R;

public class DrawerNavigationControl extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = null;

        switch(id) {
            case R.id.nav_principal:
                intent = new Intent(this, PrincipalActivity.class);
                break;
//            case R.id.nav_por_dia:
//                intent = new Intent(this, CalcDiaActivity.class);
//                break;
            case R.id.nav_por_semana:
                intent = new Intent(this, CalcSemanalActivity.class);
                break;
            case R.id.nav_acerca:
                intent = new Intent(this, AcercaActivity.class);
                break;
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.closeDrawer(GravityCompat.START);

        startActivity(intent);
        return true;
    }
}
