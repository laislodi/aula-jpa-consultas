package br.com.tt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.model.Cliente;

public class Main01ConsultaSimples {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_tt").createEntityManager();

		String consulta = "SELECT C FROM Cliente C ";
		TypedQuery<Cliente> query = em.createQuery(consulta, Cliente.class);

		List<Cliente> clientes = query.getResultList();

		clientes.forEach(c -> System.out.println(c.getNome()));
	}
}
