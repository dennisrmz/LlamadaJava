package com.example.llamadajava;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View;

import java.security.cert.Extension;

public class MyKeyboard extends LinearLayout implements View.OnClickListener {

    private Button boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8,boton9, boton0, botonC;
    private SparseArray<String> keyValues = new SparseArray<>();
    private InputConnection inputConnection;
    public MyKeyboard(Context context){
        this(context, null, 0);
    }

    public MyKeyboard(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }
    public MyKeyboard(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
    private void init(Context context, AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.keyboard,this, true);
        boton1 = (Button) findViewById(R.id.boton1);
        boton1.setOnClickListener(this);
        boton2 = (Button) findViewById(R.id.boton2);
        boton2.setOnClickListener(this);
        boton3 = (Button) findViewById(R.id.boton3);
        boton3.setOnClickListener(this);
        boton4 = (Button) findViewById(R.id.boton4);
        boton4.setOnClickListener(this);
        boton5 = (Button) findViewById(R.id.boton5);
        boton5.setOnClickListener(this);
        boton6 = (Button) findViewById(R.id.boton6);
        boton6.setOnClickListener(this);
        boton7 = (Button) findViewById(R.id.boton7);
        boton7.setOnClickListener(this);
        boton8 = (Button) findViewById(R.id.boton8);
        boton8.setOnClickListener(this);
        boton9 = (Button) findViewById(R.id.boton9);
        boton9.setOnClickListener(this);
        boton0 = (Button) findViewById(R.id.boton0);
        boton0.setOnClickListener(this);
        botonC = (Button) findViewById(R.id.botonC);
        botonC.setOnClickListener(this);

        keyValues.put(R.id.boton1, "1");
        keyValues.put(R.id.boton2, "2");
        keyValues.put(R.id.boton3, "3");
        keyValues.put(R.id.boton4, "4");
        keyValues.put(R.id.boton5, "5");
        keyValues.put(R.id.boton6, "6");
        keyValues.put(R.id.boton7, "7");
        keyValues.put(R.id.boton8, "8");
        keyValues.put(R.id.boton9, "9");
        keyValues.put(R.id.boton0, "0");
    }


    @Override
    public void onClick(View view) {
        if (inputConnection == null)
            return;
        if (view.getId() == R.id.botonC){
            CharSequence selectedText = inputConnection.getSelectedText(0);
            if (TextUtils.isEmpty(selectedText)){
                inputConnection.deleteSurroundingText(1,0);
            }else{
                inputConnection.commitText("",1);
            }
        }else {
            String value = keyValues.get(view.getId());
            inputConnection.commitText(value,1);
        }
    }


    public void setInputConnection(InputConnection ic){
        inputConnection = ic;
    }
}
