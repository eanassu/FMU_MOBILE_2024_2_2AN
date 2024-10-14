package br.fmu.exemplo2an;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class FuncionarioAdapter extends RecyclerView.Adapter {

    private List<Funcionario> funcionarios;
    private Context context;

    public FuncionarioAdapter(List<Funcionario> funcionarios, Context context) {
        this.funcionarios = funcionarios;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_funcionario,parent,false);
        return new FuncionarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        FuncionarioViewHolder funcionarioViewHolder = (FuncionarioViewHolder) holder;
        Funcionario f = funcionarios.get(position);
        funcionarioViewHolder.re.setText(Integer.toString(f.getRe()));
        funcionarioViewHolder.nome.setText(f.getNome());
        funcionarioViewHolder.dataAdmissao.setText(dateFormat.format(f.getDataAdmissao()));
        funcionarioViewHolder.salario.setText(numberFormat.format(f.getSalario()));
    }

    @Override
    public int getItemCount() {
        return funcionarios.size();
    }
}