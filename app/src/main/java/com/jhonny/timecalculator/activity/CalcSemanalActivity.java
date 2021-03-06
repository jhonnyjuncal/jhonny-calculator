package com.jhonny.timecalculator.activity;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jhonny.timecalculator.component.DrawerNavigationControl;
import com.jhonny.timecalculator.timecalculator.R;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;

public class CalcSemanalActivity extends DrawerNavigationControl {

    private int idBotonSeleccionado;
    private final static String FICHERO = "data";

    private String l1_h1;
    private String l1_m1;
    private String l1_h2;
    private String l1_m2;
    private String l1_h3;
    private String l1_m3;
    private String l2_h1;
    private String l2_m1;
    private String l2_h2;
    private String l2_m2;
    private String l2_h3;
    private String l2_m3;
    private String l3_h1;
    private String l3_m1;
    private String l3_h2;
    private String l3_m2;
    private String l3_h3;
    private String l3_m3;
    private String l4_h1;
    private String l4_m1;
    private String l4_h2;
    private String l4_m2;
    private String l4_h3;
    private String l4_m3;
    private String l5_h1;
    private String l5_m1;
    private String l5_h2;
    private String l5_m2;
    private String l5_h3;
    private String l5_m3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_semanal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        leeYMuestraDatosDesdeFichero();
        calculaTiempo();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora_semanal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_reiniciar) {
            reiniciaTiempos();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showTimePickerDialog(View view) {
        idBotonSeleccionado = view.getId();
        showDialog(idBotonSeleccionado);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        return new TimePickerDialog(this, timePickerListener, 0, 0, true);
    }

    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
            insertarHora(idBotonSeleccionado, selectedHour, selectedMinute);
        }
    };

    private void insertarHora(int id, int hours, int minutes) {
        String horas = formateaTiempo(hours);
        String minutos = formateaTiempo(minutes);

        switch(id) {
            case R.id.imageView2:
                l1_h1 = horas;
                insertaValorTexto(R.id.tv11, l1_h1);
                l1_m1 = minutos;
                insertaValorTexto(R.id.tv12, l1_m1);
                break;
            case R.id.imageView3:
                l1_h2 = horas;
                insertaValorTexto(R.id.tv13, l1_h2);
                l1_m2 = minutos;
                insertaValorTexto(R.id.tv14, l1_m2);
                break;
            case R.id.imageView4:
                l1_h3 = horas;
                insertaValorTexto(R.id.tv15, l1_h3);
                l1_m3 = minutos;
                insertaValorTexto(R.id.tv16, l1_m3);
                break;
            case R.id.imageView5:
                l2_h1 = horas;
                insertaValorTexto(R.id.tv21, l2_h1);
                l2_m1 = minutos;
                insertaValorTexto(R.id.tv22, l2_m1);
                break;
            case R.id.imageView6:
                l2_h2 = horas;
                insertaValorTexto(R.id.tv23, l2_h2);
                l2_m2 = minutos;
                insertaValorTexto(R.id.tv24, l2_m2);
                break;
            case R.id.imageView7:
                l2_h3 = horas;
                insertaValorTexto(R.id.tv25, l2_h3);
                l2_m3 = minutos;
                insertaValorTexto(R.id.tv26, l2_m3);
                break;
            case R.id.imageView8:
                l3_h1 = horas;
                insertaValorTexto(R.id.tv31, l3_h1);
                l3_m1 = minutos;
                insertaValorTexto(R.id.tv32, l3_m1);
                break;
            case R.id.imageView9:
                l3_h2 = horas;
                insertaValorTexto(R.id.tv33, l3_h2);
                l3_m2 = minutos;
                insertaValorTexto(R.id.tv34, l3_m2);
                break;
            case R.id.imageView10:
                l3_h3 = horas;
                insertaValorTexto(R.id.tv35, l3_h3);
                l3_m3 = minutos;
                insertaValorTexto(R.id.tv36, l3_m3);
                break;
            case R.id.imageView11:
                l4_h1 = horas;
                insertaValorTexto(R.id.tv41, l4_h1);
                l4_m1 = minutos;
                insertaValorTexto(R.id.tv42, l4_m1);
                break;
            case R.id.imageView12:
                l4_h2 = horas;
                insertaValorTexto(R.id.tv43, l4_h2);
                l4_m2 = minutos;
                insertaValorTexto(R.id.tv44, l4_m2);
                break;
            case R.id.imageView13:
                l4_h3 = horas;
                insertaValorTexto(R.id.tv45, l4_h3);
                l4_m3 = minutos;
                insertaValorTexto(R.id.tv46, l4_m3);
                break;
            case R.id.imageView14:
                l5_h1 = horas;
                insertaValorTexto(R.id.tv51, l5_h1);
                l5_m1 = minutos;
                insertaValorTexto(R.id.tv52, l5_m1);
                break;
            case R.id.imageView15:
                l5_h2 = horas;
                insertaValorTexto(R.id.tv53, l5_h2);
                l5_m2 = minutos;
                insertaValorTexto(R.id.tv54, l5_m2);
                break;
            case R.id.imageView16:
                l5_h3 = horas;
                insertaValorTexto(R.id.tv55, l5_h3);
                l5_m3 = minutos;
                insertaValorTexto(R.id.tv56, l5_m3);
                break;
        }

        calculaTiempo();
        guardaDatosEnFichero();
    }

    private void calculaTiempo() {
        int hora11 = extraeValorTexto(R.id.tv11);
        int minuto11 = extraeValorTexto(R.id.tv12);
        int hora12 = extraeValorTexto(R.id.tv13);
        int minuto12 = extraeValorTexto(R.id.tv14);
        int hora13 = extraeValorTexto(R.id.tv15);
        int minuto13 = extraeValorTexto(R.id.tv16);
        int hora21 = extraeValorTexto(R.id.tv21);
        int minuto21 = extraeValorTexto(R.id.tv22);
        int hora22 = extraeValorTexto(R.id.tv23);
        int minuto22 = extraeValorTexto(R.id.tv24);
        int hora23 = extraeValorTexto(R.id.tv25);
        int minuto23 = extraeValorTexto(R.id.tv26);
        int hora31 = extraeValorTexto(R.id.tv31);
        int minuto31 = extraeValorTexto(R.id.tv32);
        int hora32 = extraeValorTexto(R.id.tv33);
        int minuto32 = extraeValorTexto(R.id.tv34);
        int hora33 = extraeValorTexto(R.id.tv35);
        int minuto33 = extraeValorTexto(R.id.tv36);
        int hora41 = extraeValorTexto(R.id.tv41);
        int minuto41 = extraeValorTexto(R.id.tv42);
        int hora42 = extraeValorTexto(R.id.tv43);
        int minuto42 = extraeValorTexto(R.id.tv44);
        int hora43 = extraeValorTexto(R.id.tv45);
        int minuto43 = extraeValorTexto(R.id.tv46);
        int hora51 = extraeValorTexto(R.id.tv51);
        int minuto51 = extraeValorTexto(R.id.tv52);
        int hora52 = extraeValorTexto(R.id.tv53);
        int minuto52 = extraeValorTexto(R.id.tv54);
        int hora53 = extraeValorTexto(R.id.tv55);
        int minuto53 = extraeValorTexto(R.id.tv56);

        DateTime horaComidaCero = new DateTime(2016, 1, 1, 0, 0, 0, 0);

        DateTime horaInicio1 = new DateTime(2016, 1, 1, hora11, minuto11, 0, 0);
        DateTime horaFin1 = new DateTime(2016, 1, 1, hora12, minuto12, 0, 0);
        DateTime horaComida1 = new DateTime(2016, 1, 1, hora13, minuto13, 0, 0);
        DateTime horaInicio2 = new DateTime(2016, 1, 1, hora21, minuto21, 0, 0);
        DateTime horaFin2 = new DateTime(2016, 1, 1, hora22, minuto22, 0, 0);
        DateTime horaComida2 = new DateTime(2016, 1, 1, hora23, minuto23, 0, 0);
        DateTime horaInicio3 = new DateTime(2016, 1, 1, hora31, minuto31, 0, 0);
        DateTime horaFin3 = new DateTime(2016, 1, 1, hora32, minuto32, 0, 0);
        DateTime horaComida3 = new DateTime(2016, 1, 1, hora33, minuto33, 0, 0);
        DateTime horaInicio4 = new DateTime(2016, 1, 1, hora41, minuto41, 0, 0);
        DateTime horaFin4 = new DateTime(2016, 1, 1, hora42, minuto42, 0, 0);
        DateTime horaComida4 = new DateTime(2016, 1, 1, hora43, minuto43, 0, 0);
        DateTime horaInicio5 = new DateTime(2016, 1, 1, hora51, minuto51, 0, 0);
        DateTime horaFin5 = new DateTime(2016, 1, 1, hora52, minuto52, 0, 0);
        DateTime horaComida5 = new DateTime(2016, 1, 1, hora53, minuto53, 0, 0);

        DateTime finMenosComida1 = horaFin1.minus(new Period(horaComidaCero, horaComida1));
        Duration duration1 = new Duration(horaInicio1, finMenosComida1);
        DateTime finMenosComida2 = horaFin2.minus(new Period(horaComidaCero, horaComida2));
        Duration duration2 = new Duration(horaInicio2, finMenosComida2);
        DateTime finMenosComida3 = horaFin3.minus(new Period(horaComidaCero, horaComida3));
        Duration duration3 = new Duration(horaInicio3, finMenosComida3);
        DateTime finMenosComida4 = horaFin4.minus(new Period(horaComidaCero, horaComida4));
        Duration duration4 = new Duration(horaInicio4, finMenosComida4);
        DateTime finMenosComida5 = horaFin5.minus(new Period(horaComidaCero, horaComida5));
        Duration duration5 = new Duration(horaInicio5, finMenosComida5);

        Duration t = duration1.plus(duration2).plus(duration3).plus(duration4).plus(duration5);
        muestaTiempoTotal(formateaTiempo(t.toPeriod().getHours()), formateaTiempo(t.toPeriod().getMinutes()));
    }

    private Integer extraeValorTexto(int id) {
        TextView textView = (TextView)findViewById(id);
        return new Integer(textView.getText().toString());
    }

    private void insertaValorTexto(int id, String valor) {
        TextView textView = (TextView)findViewById(id);
        textView.setText(valor);
    }

    private String formateaTiempo(int valor) {
        String val = String.valueOf(valor);
        if (val.length() == 1) {
           val = "0" + val;
        }
        return val;
    }

    private void muestaTiempoTotal(String horas, String minutos) {
        TextView textViewTotalHoras = (TextView)findViewById(R.id.textViewTotalHora);
        textViewTotalHoras.setText(horas);
        TextView textViewTotalMinutos = (TextView)findViewById(R.id.textViewTotalMinutos);
        textViewTotalMinutos.setText(minutos);
    }

    private void leeYMuestraDatosDesdeFichero() {
        SharedPreferences sp  = getSharedPreferences(FICHERO, Context.MODE_PRIVATE);
        l1_h1 = sp.getString("l1_h1", "00");
        insertaValorTexto(R.id.tv11, l1_h1);
        l1_m1 = sp.getString("l1_m1", "00");
        insertaValorTexto(R.id.tv12, l1_m1);
        l1_h2 = sp.getString("l1_h2", "00");
        insertaValorTexto(R.id.tv13, l1_h2);
        l1_m2 = sp.getString("l1_m2", "00");
        insertaValorTexto(R.id.tv14, l1_m2);
        l1_h3 = sp.getString("l1_h3", "00");
        insertaValorTexto(R.id.tv15, l1_h3);
        l1_m3 = sp.getString("l1_m3", "00");
        insertaValorTexto(R.id.tv16, l1_m3);

        l2_h1 = sp.getString("l2_h1", "00");
        insertaValorTexto(R.id.tv21, l2_h1);
        l2_m1 = sp.getString("l2_m1", "00");
        insertaValorTexto(R.id.tv22, l2_m1);
        l2_h2 = sp.getString("l2_h2", "00");
        insertaValorTexto(R.id.tv23, l2_h2);
        l2_m2 = sp.getString("l2_m2", "00");
        insertaValorTexto(R.id.tv24, l2_m2);
        l2_h3 = sp.getString("l2_h3", "00");
        insertaValorTexto(R.id.tv25, l2_h3);
        l2_m3 = sp.getString("l2_m3", "00");
        insertaValorTexto(R.id.tv26, l2_m3);

        l3_h1 = sp.getString("l3_h1", "00");
        insertaValorTexto(R.id.tv31, l3_h1);
        l3_m1 = sp.getString("l3_m1", "00");
        insertaValorTexto(R.id.tv32, l3_m1);
        l3_h2 = sp.getString("l3_h2", "00");
        insertaValorTexto(R.id.tv33, l3_h2);
        l3_m2 = sp.getString("l3_m2", "00");
        insertaValorTexto(R.id.tv34, l3_m2);
        l3_h3 = sp.getString("l3_h3", "00");
        insertaValorTexto(R.id.tv35, l3_h3);
        l3_m3 = sp.getString("l3_m3", "00");
        insertaValorTexto(R.id.tv36, l3_m3);

        l4_h1 = sp.getString("l4_h1", "00");
        insertaValorTexto(R.id.tv41, l4_h1);
        l4_m1 = sp.getString("l4_m1", "00");
        insertaValorTexto(R.id.tv42, l4_m1);
        l4_h2 = sp.getString("l4_h2", "00");
        insertaValorTexto(R.id.tv43, l4_h2);
        l4_m2 = sp.getString("l4_m2", "00");
        insertaValorTexto(R.id.tv44, l4_m2);
        l4_h3 = sp.getString("l4_h3", "00");
        insertaValorTexto(R.id.tv45, l4_h3);
        l4_m3 = sp.getString("l4_m3", "00");
        insertaValorTexto(R.id.tv46, l4_m3);

        l5_h1 = sp.getString("l5_h1", "00");
        insertaValorTexto(R.id.tv51, l5_h1);
        l5_m1 = sp.getString("l5_m1", "00");
        insertaValorTexto(R.id.tv52, l5_m1);
        l5_h2 = sp.getString("l5_h2", "00");
        insertaValorTexto(R.id.tv53, l5_h2);
        l5_m2 = sp.getString("l5_m2", "00");
        insertaValorTexto(R.id.tv54, l5_m2);
        l5_h3 = sp.getString("l5_h3", "00");
        insertaValorTexto(R.id.tv55, l5_h3);
        l5_m3 = sp.getString("l5_m3", "00");
        insertaValorTexto(R.id.tv56, l5_m3);
    }

    private void guardaDatosEnFichero() {
        SharedPreferences sp  = getSharedPreferences(FICHERO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("l1_h1", l1_h1);
        editor.putString("l1_m1", l1_m1);
        editor.putString("l1_h2", l1_h2);
        editor.putString("l1_m2", l1_m2);
        editor.putString("l1_h3", l1_h3);
        editor.putString("l1_m3", l1_m3);
        editor.putString("l2_h1", l2_h1);
        editor.putString("l2_m1", l2_m1);
        editor.putString("l2_h2", l2_h2);
        editor.putString("l2_m2", l2_m2);
        editor.putString("l2_h3", l2_h3);
        editor.putString("l2_m3", l2_m3);
        editor.putString("l3_h1", l3_h1);
        editor.putString("l3_m1", l3_m1);
        editor.putString("l3_h2", l3_h2);
        editor.putString("l3_m2", l3_m2);
        editor.putString("l3_h3", l3_h3);
        editor.putString("l3_m3", l3_m3);
        editor.putString("l4_h1", l4_h1);
        editor.putString("l4_m1", l4_m1);
        editor.putString("l4_h2", l4_h2);
        editor.putString("l4_m2", l4_m2);
        editor.putString("l4_h3", l4_h3);
        editor.putString("l4_m3", l4_m3);
        editor.putString("l5_h1", l5_h1);
        editor.putString("l5_m1", l5_m1);
        editor.putString("l5_h2", l5_h2);
        editor.putString("l5_m2", l5_m2);
        editor.putString("l5_h3", l5_h3);
        editor.putString("l5_m3", l5_m3);

        editor.commit();
    }

    private void reiniciaTiempos() {
        SharedPreferences sp  = getSharedPreferences(FICHERO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        l1_h1 = "00";
        insertaValorTexto(R.id.tv11, l1_h1);
        editor.putString("l1_h1", l1_h1);
        l1_m1 = "00";
        insertaValorTexto(R.id.tv12, l1_m1);
        editor.putString("l1_m1", l1_m1);
        l1_h2 = "00";
        insertaValorTexto(R.id.tv13, l1_h2);
        editor.putString("l1_h2", l1_h2);
        l1_m2 = "00";
        insertaValorTexto(R.id.tv14, l1_m2);
        editor.putString("l1_m2", l1_m2);
        l1_h3 = "00";
        insertaValorTexto(R.id.tv15, l1_h3);
        editor.putString("l1_h3", l1_h3);
        l1_m3 = "00";
        insertaValorTexto(R.id.tv16, l1_m3);
        editor.putString("l1_m3", l1_m3);
        l2_h1 = "00";
        insertaValorTexto(R.id.tv21, l2_h1);
        editor.putString("l2_h1", l2_h1);
        l2_m1 = "00";
        insertaValorTexto(R.id.tv22, l2_m1);
        editor.putString("l2_m1", l2_m1);
        l2_h2 = "00";
        insertaValorTexto(R.id.tv23, l2_h2);
        editor.putString("l2_h2", l2_h2);
        l2_m2 = "00";
        insertaValorTexto(R.id.tv24, l2_m2);
        editor.putString("l2_m2", l2_m2);
        l2_h3 = "00";
        insertaValorTexto(R.id.tv25, l2_h3);
        editor.putString("l2_h3", l2_h3);
        l2_m3 = "00";
        insertaValorTexto(R.id.tv26, l2_m3);
        editor.putString("l2_m3", l2_m3);
        l3_h1 = "00";
        insertaValorTexto(R.id.tv31, l3_h1);
        editor.putString("l3_h1", l3_h1);
        l3_m1 = "00";
        insertaValorTexto(R.id.tv32, l3_m1);
        editor.putString("l3_m1", l3_m1);
        l3_h2 = "00";
        insertaValorTexto(R.id.tv33, l3_h2);
        editor.putString("l3_h2", l3_h2);
        l3_m2 = "00";
        insertaValorTexto(R.id.tv34, l3_m2);
        editor.putString("l3_m2", l3_m2);
        l3_h3 = "00";
        insertaValorTexto(R.id.tv35, l3_h3);
        editor.putString("l3_h3", l3_h3);
        l3_m3 = "00";
        insertaValorTexto(R.id.tv36, l3_m3);
        editor.putString("l3_m3", l3_m3);
        l4_h1 = "00";
        insertaValorTexto(R.id.tv41, l4_h1);
        editor.putString("l4_h1", l4_h1);
        l4_m1 = "00";
        insertaValorTexto(R.id.tv42, l4_m1);
        editor.putString("l4_m1", l4_m1);
        l4_h2 = "00";
        insertaValorTexto(R.id.tv43, l4_h2);
        editor.putString("l4_h2", l4_h2);
        l4_m2 = "00";
        insertaValorTexto(R.id.tv44, l4_m2);
        editor.putString("l4_m2", l4_m2);
        l4_h3 = "00";
        insertaValorTexto(R.id.tv45, l4_h3);
        editor.putString("l4_h3", l4_h3);
        l4_m3 = "00";
        insertaValorTexto(R.id.tv46, l4_m3);
        editor.putString("l4_m3", l4_m3);
        l5_h1 = "00";
        insertaValorTexto(R.id.tv51, l5_h1);
        editor.putString("l5_h1", l5_h1);
        l5_m1 = "00";
        insertaValorTexto(R.id.tv52, l5_m1);
        editor.putString("l5_m1", l5_m1);
        l5_h2 = "00";
        insertaValorTexto(R.id.tv53, l5_h2);
        editor.putString("l5_h2", l5_h2);
        l5_m2 = "00";
        insertaValorTexto(R.id.tv54, l5_m2);
        editor.putString("l5_m2", l5_m2);
        l5_h3 = "00";
        insertaValorTexto(R.id.tv55, l5_h3);
        editor.putString("l5_h3", l5_h3);
        l5_m3 = "00";
        insertaValorTexto(R.id.tv56, l5_m3);
        editor.putString("l5_m3", l5_m3);

        editor.commit();
        calculaTiempo();
    }
}
