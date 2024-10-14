package br.fmu.exemplo2an;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDao dao = db.funcionarioDao();
        List<Funcionario> lista = dao.getFuncionarios();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new FuncionarioAdapter(lista, this));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }
}