package br.com.tt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.model.Cliente;
import br.com.tt.model.Endereco;
import br.com.tt.model.Estado;

public class Main05ConsultaJoin {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_tt").createEntityManager();

		Cliente cliente = new Cliente();
		cliente.setNome("Ricardo Mauro");

		Endereco endereco1 = new Endereco("rua Sao Francisco da California, 23", "Sao Joao", "Poa", Estado.RS);
		Endereco endereco2 = new Endereco("rua dr barcelos, 2434", "Tristeza", "Poa", Estado.RS);
		Endereco endereco3 = new Endereco("rua Senador Atilio Vivacua, 395",
		"Populares", "Sao Gabriel da Palha", Estado.ES);
		Endereco endereco4 = new Endereco("Av Diário de Notícias, 4532", "Cristal",
		"Poa", Estado.RS);

		endereco1.setCliente(cliente); // esse bloco foi feito dentro do metodo
		endereco2.setCliente(cliente);
		endereco3.setCliente(cliente);
		endereco4.setCliente(cliente);

		cliente.addEndereco(endereco1);
		cliente.addEndereco(endereco2);
		// os enderecos podem ser adicionados diretamente
		cliente.addEndereco(
				new Endereco("rua Senador Atilio Vivacua, 395", "Populares", "Sao Gabriel da Palha", Estado.ES));
		cliente.addEndereco(new Endereco("Av Diário de Notícias, 4532", "Cristal", "Poa", Estado.RS));

		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		//********************************************************************************************
		
		// JPQL ->
		String consulta = "SELECT e FROM Endereco e where UPPER(e.cliente.nome) = UPPER(:nome)";
		TypedQuery<Endereco> query = em.createQuery(consulta, Endereco.class);

		query.setParameter("nome", "ricardo mauro");
		List<Endereco> enderecos = query.getResultList();

		enderecos.forEach(e -> System.out.println(e.getRua() + " " + e.getBairro() + " " + e.getCidade()));
	}
}
