package com.jhonny.timecalculator.Listener;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class TextWatcherListener implements TextWatcher {

    private String horas;
    private String minutos;
    private EditText editText;

    public TextWatcherListener(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(charSequence.length() == 5) {
            if(charSequence.toString().contains(":")) {
                String[] valores = charSequence.toString().split(":");
                String horasTmp = valores[0];
                String minutosTmp = valores[1];
                validarHoras(horasTmp);
                validarMinutos(minutosTmp);
                this.editText.setText(horas + ":" + minutos);
            }
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
//        if(horas != null && minutos != null) {
//            editable.clear();
//            editable.append(horas + ":" + minutos);
//            editable.replace(0, 4, horas + ":" + minutos);
//        }
    }

    private void validarHoras(String horasTmp) {
        if(Integer.valueOf(horasTmp) > 23) {
            horas = new String("00");
        }
    }

    private void validarMinutos(String minutosTmp) {
        if(Integer.valueOf(minutosTmp) > 59) {
            minutos = new String("00");
        }
    }
}
