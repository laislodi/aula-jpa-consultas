package br.com.tt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main04ConsultaParametroComOrderBy {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_tt").createEntityManager();
		
		// JPQL -> 
		String consulta = "SELECT C.nome FROM Cliente C where nome LIKE :nome ORDER BY C.nome DESC";
		TypedQuery<String> query = em.createQuery(consulta, String.class);

		query.setParameter("nome", "%%");
		List<String> ListaClientes = query.getResultList();

		ListaClientes.forEach(c -> System.out.println(c));
	}
}
