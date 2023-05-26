package com.example.criadordelink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editEmail, editLinkEmail;
    EditText editnumero, editMensagemZap, editLinkZap;
    Button buttonGerarLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail=findViewById(R.id.editTextEmail);
        editLinkEmail=findViewById(R.id.editTextLinkEmail);

        editnumero=findViewById(R.id.editTextNumero);
        editMensagemZap=findViewById(R.id.editTextMensagem);
        editLinkZap=findViewById(R.id.editTextlinkWhatapp);

        buttonGerarLink=findViewById(R.id.buttonOk);

        buttonGerarLink.setOnClickListener(new View.OnClickListener() {
            @Override
        //email
            public void onClick(View v) {
                //Email
                String linkemail = "mailto:"+(editEmail.getText());
                editLinkEmail.setText(linkemail);

                //WhatsApp
                String linkzap = "https://api.whatsapp.com/send?phone="+ (editnumero.getText()) + "&text="+editMensagemZap;
                editLinkZap.setText(linkzap);
            }
        });
    }
}