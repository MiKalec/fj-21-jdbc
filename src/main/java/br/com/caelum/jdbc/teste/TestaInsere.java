package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

import java.util.Calendar;

public class TestaInsere {
    public static void main(String[]args){
        Contato contato = new Contato();
        contato.setNome("Caelum");
        contato.setEmail("contato@caelum.com.br");
        contato.setEndereco("R. Vergueiro 3185 cj59");
        contato.setDataNascimento(Calendar.getInstance());

        ContatoDao dao = new ContatoDao();

        dao.adiciona(contato);

        System.out.println("Gravado!");
    }
}
