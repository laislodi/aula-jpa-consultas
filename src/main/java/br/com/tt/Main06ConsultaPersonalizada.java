package br.com.tt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.vo.ClienteVO;

public class Main06ConsultaPersonalizada {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_tt").createEntityManager();
		
		// JPQL ->
		String consulta = " SELECT											  ";
		consulta += 	  " NEW br.com.tt.vo.ClienteVO(e.cliente.nome, e.rua) ";
		consulta += 	  " FROM Endereco e                                   ";
		consulta += 	  " WHERE UPPER(e.cliente.nome) = UPPER(:nome)        ";
		TypedQuery<ClienteVO> query = em.createQuery(consulta, ClienteVO.class);

		query.setParameter("nome", "Ricardo Mauro");
		List<ClienteVO> enderecos = query.getResultList();

		enderecos.forEach(e -> System.out.println(e));
	}
}
