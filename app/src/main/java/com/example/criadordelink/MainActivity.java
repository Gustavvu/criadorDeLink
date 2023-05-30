package com.example.criadordelink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editnumero, editMensagemZap;
    TextView textViewLinkEmail, textViewLinkZap;
    Button buttonGerarLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editTextEmail);

        editnumero = findViewById(R.id.editTextNumero);
        editMensagemZap = findViewById(R.id.editTextMensagem);

        textViewLinkEmail = findViewById(R.id.textViewLinkEmailId);
        textViewLinkZap = findViewById(R.id.textViewLinkZapId);

        buttonGerarLink = findViewById(R.id.buttonOk);
        ClipData clipData;

        ClipboardManager clipboard = (ClipboardManager)
                getSystemService(Context.CLIPBOARD_SERVICE);


//        String linkzap = "https://api.whatsapp.com/send?phone="+ (editnumero.getText().toString()) + "&text="+editMensagemZap.getText().toString().replaceAll("\\s+", "%20");
//        String linkemail = "mailto:"+(editEmail.getText().toString());

        buttonGerarLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //WhatsApp
                String linkzap = "https://api.whatsapp.com/send?phone=" + (editnumero.getText().toString()) + "&text=" + editMensagemZap.getText().toString().replaceAll("\\s+", "%20");
                textViewLinkZap.setText(linkzap);

                //Email
                String linkemail = "mailto:" + (editEmail.getText().toString());
                textViewLinkEmail.setText(linkemail);
            }
        });
        textViewLinkEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linkemail = "mailto:" + (editEmail.getText().toString());
                ClipData clip = ClipData.newPlainText("simple text", linkemail);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity.this, "Link copiado!", Toast.LENGTH_SHORT).show();
            }
        });
        textViewLinkZap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linkzap = "https://api.whatsapp.com/send?phone=" + (editnumero.getText().toString()) + "&text=" + editMensagemZap.getText().toString().replaceAll("\\s+", "%20");
                ClipData clip = ClipData.newPlainText("simple text", linkzap);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity.this, "Link copiado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}