package br.unibh.sdm.backend_quarto.negocio;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.unibh.sdm.backend_quarto.entidades.Quarto;
import br.unibh.sdm.backend_quarto.persistencia.QuartoRepository;

@Service
public class QuartoService {

  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private final QuartoRepository quartoRepo;

  public QuartoService(QuartoRepository quartoRepository) {
    this.quartoRepo = quartoRepository;
  }

  public List<Quarto> getQuartos() {
    if (logger.isInfoEnabled()) {
      logger.info("Buscando todos os objetos");
    }
    Iterable<Quarto> lista = this.quartoRepo.findAll();
    if (lista == null) {
      return new ArrayList<Quarto>();
    }
    return IteratorUtils.toList(lista.iterator());
  }

  public Quarto getQuartoById(Long id) {
    if (logger.isInfoEnabled()) {
      logger.info("Buscando Quarto com o codigo {}", id);
    }
    Optional<Quarto> retorno = this.quartoRepo.findById(id);
    if (!retorno.isPresent()) {
      throw new RuntimeException("Quarto com o id " + id + " nao encontrada");
    }
    return retorno.get();
  }

  public Quarto saveQuarto(Quarto quarto) {
    if (logger.isInfoEnabled()) {
      logger.info("Salvando Quarto com os detalhes {}", quarto.toString());
    }
    return this.quartoRepo.save(quarto);
  }

  public void deleteQuarto(Long id) {
    if (logger.isInfoEnabled()) {
      logger.info("Excluindo Quarto com id {}", id);
    }
    this.quartoRepo.deleteById(id);
  }

  public List<Quarto> getQuartoByNome(String nome) {
    if (logger.isInfoEnabled()) {
      logger.info("Buscando todos os objetos");
    }
    Iterable<Quarto> lista = this.quartoRepo.findByNome(nome);
    if (lista == null) {
      return new ArrayList<Quarto>();
    }
    return IteratorUtils.toList(lista.iterator());
  }

  public boolean isQuartoExists(Quarto quarto) {
    Optional<Quarto> retorno = this.quartoRepo.findById(quarto.getId());
    return retorno.isPresent() ? true : false;
  }

}