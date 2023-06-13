package br.unibh.sdm.backend_quarto.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.unibh.sdm.backend_quarto.entidades.Quarto;
import br.unibh.sdm.backend_quarto.persistencia.QuartoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuartoTest {

	private static Logger LOGGER = LoggerFactory.getLogger(QuartoTest.class);
	private SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");

	@Autowired
	private QuartoRepository repository;

	@Test
	public void teste1Criacao() throws ParseException {
		LOGGER.info("Criando objetos...");
		Quarto q1 = new Quarto(null, "0000000001", "Quarto 1");
		repository.save(q1);

		Quarto q2 = new Quarto(null, "0000000002", "Quarto 2");
		repository.save(q2);

		Quarto q3 = new Quarto(null, "0000000003", "Quarto 3");
		repository.save(q3);

		LOGGER.info("Pesquisado todos");
		Iterable<Quarto> lista = repository.findAll();
		assertNotNull(lista.iterator());
		for (Quarto quarto : lista) {
			LOGGER.info(quarto.toString());
		}
		LOGGER.info("Pesquisado um objeto");
		List<Quarto> result = repository.findByNome("Quarto 1");
		assertEquals(result.size(), 1);
	}

	@Test
	public void teste2Exclusao() throws ParseException {
		LOGGER.info("Excluindo objetos...");
		List<Quarto> result = repository.findByNome("Quarto 1");
		for (Quarto quarto : result) {
			LOGGER.info("Excluindo Quarto id = " + quarto.getId());
			repository.delete(quarto);
		}
		result = repository.findByNome("Quarto 2");
		for (Quarto quarto : result) {
			LOGGER.info("Excluindo Quarto id = " + quarto.getId());
			repository.delete(quarto);
		}
		result = repository.findByNome("Quarto 3");
		for (Quarto quarto : result) {
			LOGGER.info("Excluindo Quarto id = " + quarto.getId());
			repository.delete(quarto);
		}
		result = repository.findByNome("Quarto 1");
		assertEquals(result.size(), 0);
		LOGGER.info("Exclusão feita com sucesso");
	}
}