package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;

    private String[] itens = {
            "Angra dos Reis", "Caldas Novas",
            "Campos do Jordão", "Florianópolis",
            "São Paulo", "Rio de Janeiro", "Gramado",
            "Canela", "Bonito", "Foz do Iguaçu", "Salvador", "Porto Alegre",
            "Porto Seguro", "Maceió", "Cascavel", "Toledo"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listLocais);


        //criar adaptador para a lista -

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1, //layout da lista - pode ser customizada
                android.R.id.text1, //id do layout - xml ctrl + clical no layout
                itens
        );

        //adicionar adaptador na lista
        listLocais.setAdapter(adaptador);


        //adicionar clic na lista
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = listLocais.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG).show();
            }
        });
    }

}