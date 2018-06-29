package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.FuncionarioDao;

public class TestaCriaTabelaFuncionario {
    public static void main(String[] args){
        FuncionarioDao dao = new FuncionarioDao();
        dao.criaTabelaFuncionario();
    }
}
