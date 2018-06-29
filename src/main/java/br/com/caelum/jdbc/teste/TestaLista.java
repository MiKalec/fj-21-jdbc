package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

import java.util.List;

public class TestaLista {
    public static void main(String[] args){
        ContatoDao dao = new ContatoDao();
        List<Contato> contatos = dao.getLista();

        for(Contato contato:contatos){
            System.out.println("Id: " + contato.getId() + "\n" +
                    "Nome: "+ contato.getNome() + "\n" +
                    "Email: "+ contato.getEmail() + "\n" +
                    "Endereço: "+ contato.getEndereco() + "\n" +
                    "Data de Nascimento: "+ contato.getDataNascimento().getTime());
        }
    }
}
