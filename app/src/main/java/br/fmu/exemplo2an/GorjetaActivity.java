package br.fmu.exemplo2an;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class GorjetaActivity extends AppCompatActivity {

    private EditText editTextValor;
    private TextView textViewValor;
    private TextView textViewPorcentagem;
    private TextView textViewGorjeta;
    private TextView textViewTotal;
    private SeekBar seekBar;
    private double porcentagem;
    private double valor;
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormat = NumberFormat.getPercentInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorjeta);
        editTextValor = findViewById(R.id.editTextValor);
        textViewValor = findViewById(R.id.textViewValor);
        textViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        textViewGorjeta = findViewById(R.id.textViewGorjeta);
        textViewTotal = findViewById(R.id.textViewTotal);
        seekBar = findViewById(R.id.seekBar);
        editTextValor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int valorInt;
                try {
                    valorInt = Integer.parseInt(editTextValor.getText().toString());
                } catch( NumberFormatException e ) {
                    valorInt = 0;
                }
                valor = valorInt/100.0;
                atualizarValores();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i/100.0;
                atualizarValores();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void atualizarValores() {
        textViewValor.setText(currencyFormat.format(valor));
        double gorjeta = valor * porcentagem;
        double total = valor + gorjeta;
        textViewPorcentagem.setText(percentFormat.format(porcentagem));
        textViewGorjeta.setText(currencyFormat.format(gorjeta));
        textViewTotal.setText(currencyFormat.format(total));
    }

    public void fechar(View view) {
        finish();
    }
}