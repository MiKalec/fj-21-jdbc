package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

import java.util.List;

public class TesteRemove {
    public static void main(String[] args){
        ContatoDao dao = new ContatoDao();
        List<Contato> contatos = dao.getLista();

        for(Contato contato:contatos){
            dao.remove(contato);
        }
    }
}
