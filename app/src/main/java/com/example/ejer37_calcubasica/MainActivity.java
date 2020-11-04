package com.example.ejer37_calcubasica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvMarcador;
    private long operando1;
    private String operacion;  //+ , - , *, /
    private long operando2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operando1 = 0;
        operando2 = 0;


        //Enlazar con los elementos del interfaz:
        tvMarcador = findViewById(R.id.tvMarcador);
        Button btnNum0 = findViewById(R.id.btnNum0);
        Button btnNum1 = findViewById(R.id.btnNum1);
        Button btnNum2 = findViewById(R.id.btnNum2);
        Button btnNum3 = findViewById(R.id.btnNum3);
        Button btnNum4 = findViewById(R.id.btnNum4);
        Button btnNum5 = findViewById(R.id.btnNum5);
        Button btnNum6 = findViewById(R.id.btnNum6);
        Button btnNum7 = findViewById(R.id.btnNum7);
        Button btnNum8 = findViewById(R.id.btnNum8);
        Button btnNum9 = findViewById(R.id.btnNum9);

        Button btnOpSumar = findViewById(R.id.btnOpSumar);
        Button btnOpResta = findViewById(R.id.btnOpResta);
        Button btnOpMulti = findViewById(R.id.btnOpMulti);
        Button btnOpDiv = findViewById(R.id.btnOpDiv);

        Button btnOpIgual = findViewById(R.id.btnOpIgual);
        Button btnOpReset = findViewById(R.id.btnOpReset);

        //Registro el evento click, de forma global:
        btnNum0.setOnClickListener(MainActivity.this);
        btnNum1.setOnClickListener(MainActivity.this);
        btnNum2.setOnClickListener(MainActivity.this);
        btnNum3.setOnClickListener(MainActivity.this);
        btnNum4.setOnClickListener(MainActivity.this);
        btnNum5.setOnClickListener(MainActivity.this);
        btnNum6.setOnClickListener(MainActivity.this);
        btnNum7.setOnClickListener(MainActivity.this);
        btnNum8.setOnClickListener(MainActivity.this);
        btnNum9.setOnClickListener(MainActivity.this);

        btnOpSumar.setOnClickListener(MainActivity.this);
        btnOpResta.setOnClickListener(MainActivity.this);
        btnOpMulti.setOnClickListener(MainActivity.this);
        btnOpDiv.setOnClickListener(MainActivity.this);

        btnOpIgual.setOnClickListener(MainActivity.this);
        btnOpReset.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {
        //Voy a distinguir de que grupo es el elemento que ha recibido el click:
        String grupo = view.getTag().toString();
        //Se que ha sido un botón:
        Button boton_clickado = (Button)view;
        String etiqueta = boton_clickado.getText().toString();

        if (grupo.compareTo("tipo_numero") == 0) {
            //Ha sido un botón numérico
            //Comprobar si en el marcador solo estaba el 0:
            if (tvMarcador.getText().toString().compareTo("0") == 0) {
                tvMarcador.setText(etiqueta);
            } else {
                String marcador = tvMarcador.getText().toString() + etiqueta;
                tvMarcador.setText(marcador);
            }
        }

        if (grupo.compareTo("tipo_operacion") == 0) {
            //Ha sido un botón de operacion:
            if (etiqueta.compareTo("=") == 0) {
                //Puedo recoger ya el operando1:
                operando2 = Long.valueOf(tvMarcador.getText().toString());
                //Ya tengo los dos operandos, puedo realizar la operación prevista
                long resultado = 0;
                switch (operacion) {
                    case "+": //Suma
                        resultado = operando1 + operando2;
                        break;
                    case "-": //Suma
                        resultado = operando1 - operando2;
                        break;
                    case "*": //Suma
                        resultado = operando1 * operando2;
                        break;
                    case "/": //Suma
                        resultado = operando1 / operando2;
                        break;
                }
                //Pinto en pantalla:
                tvMarcador.setText(String.valueOf(resultado));
            } else if (etiqueta.compareTo("CE") == 0) {
                //Reseteo la operacion en marcha:
                operando1 = 0;
                operando2 = 0;
                tvMarcador.setText("0");
            } else {
                //Ha sido una operación aritmética:
                //Puedo recoger ya el operando1:
                operando1 = Long.valueOf(tvMarcador.getText().toString());
                //Guardamos en el atributo la operación a realizar:
                operacion = etiqueta;      //Probamos con la suma
                tvMarcador.setText("0");
            }

        }
    }
}