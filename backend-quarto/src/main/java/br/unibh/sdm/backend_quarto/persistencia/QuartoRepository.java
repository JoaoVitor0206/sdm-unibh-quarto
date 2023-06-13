package br.unibh.sdm.backend_quarto.persistencia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.backend_quarto.entidades.Quarto;

public interface QuartoRepository extends CrudRepository<Quarto, Long> {
	List<Quarto> findByNome(String nome);

	Quarto findById(long id);
}