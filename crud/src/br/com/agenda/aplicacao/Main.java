package br.com.agenda.aplicacao;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.models.Contato;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContatoDAO dao = new ContatoDAO();

        // CREATE
        Contato contato = new Contato();
        contato.setNome("Teste CRUD");
        contato.setIdade(25);
        contato.setDataCadastro(new Date());
        dao.save(contato);

        // READ
        List<Contato> contatos = dao.getContatos();

        System.out.println("=== LISTA DE CONTATOS ===");
        for (Contato c : contatos) {
            System.out.println(
                    "ID: " + c.getId() +
                            " | Nome: " + c.getNome() +
                            " | Idade: " + c.getIdade() +
                            " | Data de cadastro: " + c.getDataCadastro()
            );
        }
    }
}