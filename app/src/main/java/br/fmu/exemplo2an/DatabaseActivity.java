package br.fmu.exemplo2an;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseActivity extends AppCompatActivity {

    private EditText editTextRe;
    private EditText editTextNome;
    private EditText editTextDataAdmissao;
    private EditText editTextSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        editTextNome = findViewById(R.id.editTextNome);
        editTextRe = findViewById(R.id.editTextRe);
        editTextDataAdmissao = findViewById(R.id.editTextDataAdmissao);
        editTextSalario = findViewById(R.id.editTextSalario);
    }

    public void cadastrar(View view) {
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDao dao = db.funcionarioDao();

        int re = Integer.parseInt(editTextRe.getText().toString());
        String nome = editTextNome.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAdmissao;
        try {
            dataAdmissao = dateFormat.parse(editTextDataAdmissao.getText().toString());
        } catch (ParseException e) {
            dataAdmissao = new Date();
        }
        double salario = Double.parseDouble(editTextSalario.getText().toString());
        Funcionario f = new Funcionario(re, nome, dataAdmissao, salario);
        dao.insert(f);
        limpar();
    }

    public void excluir(View view) {
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDao dao = db.funcionarioDao();

        int re = Integer.parseInt(editTextRe.getText().toString());
        String nome = editTextNome.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAdmissao;
        try {
            dataAdmissao = dateFormat.parse(editTextDataAdmissao.getText().toString());
        } catch (ParseException e) {
            dataAdmissao = new Date();
        }
        double salario = Double.parseDouble(editTextSalario.getText().toString());
        Funcionario f = new Funcionario(re, nome, dataAdmissao, salario);
        dao.delete(f);
        limpar();
    }

    public void atualizar(View view) {
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDao dao = db.funcionarioDao();

        int re = Integer.parseInt(editTextRe.getText().toString());
        String nome = editTextNome.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAdmissao;
        try {
            dataAdmissao = dateFormat.parse(editTextDataAdmissao.getText().toString());
        } catch (ParseException e) {
            dataAdmissao = new Date();
        }
        double salario = Double.parseDouble(editTextSalario.getText().toString());
        Funcionario f = new Funcionario(re, nome, dataAdmissao, salario);
        dao.update(f);
    }

    public void buscar(View view) {
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDao dao = db.funcionarioDao();
        int re = Integer.parseInt(editTextRe.getText().toString());
        Funcionario f = dao.buscarPeloRe(re);
        editTextNome.setText(f.getNome());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        editTextDataAdmissao.setText(dateFormat.format(f.getDataAdmissao()));
        editTextSalario.setText(Double.toString(f.getSalario()));
    }

    public void limparCampos(View view) {
        limpar();
    }

    private void limpar() {
        editTextRe.setText("");
        editTextNome.setText("");
        editTextDataAdmissao.setText("");
        editTextSalario.setText("");
    }
}