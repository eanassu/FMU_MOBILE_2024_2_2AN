package br.fmu.exemplo2an;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class FuncionarioViewHolder extends RecyclerView.ViewHolder {
    final TextView re;
    final TextView nome;
    final TextView dataAdmissao;
    final TextView salario;

    public FuncionarioViewHolder(View view) {
        super(view);
        re = view.findViewById(R.id.item_re);
        nome = view.findViewById(R.id.item_nome);
        dataAdmissao = view.findViewById(R.id.item_data);
        salario = view.findViewById(R.id.item_salario);
    }
}