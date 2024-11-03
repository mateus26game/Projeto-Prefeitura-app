package com.example.agoravai;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ButtonGarrafa extends AppCompatActivity {

    private Button ButtonVoltar,buttLocais,buttSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.button_garrafa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getWindow().setStatusBarColor(ContextCompat.getColor(ButtonGarrafa.this,R.color.colorAccent));


        ButtonVoltar = findViewById(R.id.ButtVoltar);
        buttLocais = findViewById(R.id.buttLocais);
        buttSite = findViewById(R.id.buttSite);

        ButtonVoltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }

        });

        Button button = findViewById(R.id.buttLocais);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://recife-pe.maps.arcgis.com/apps/instant/interactivelegend/index.html?appid=b5baaf977ed64b788a74dd476b3e7c29";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        Button buttSite = findViewById(R.id.buttSite);
        buttSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://recifelimpa.recife.pe.gov.br/encontre-o-ponto-mais-perto-de-voce/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}