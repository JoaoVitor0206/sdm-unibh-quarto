package br.unibh.sdm.backend_quarto.rest;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unibh.sdm.backend_quarto.entidades.Quarto;
import br.unibh.sdm.backend_quarto.negocio.QuartoService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "quarto")
public class QuartoController {

  private final QuartoService quartoService;

  public QuartoController(QuartoService quartoService) {
    this.quartoService = quartoService;
  }

  @GetMapping(value = "")
  public List<Quarto> getClientes() {
    return quartoService.getQuartos();
  }

  @GetMapping(value = "{id}")
  public Quarto getQuartoById(@PathVariable Long id) throws Exception {
    if (!ObjectUtils.isEmpty(id)) {
      return quartoService.getQuartoById(id);
    }
    throw new Exception("Quarto com codigo " + id + " nao encontrado");
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Quarto createQuarto(@RequestBody @NotNull Quarto quarto) throws Exception {
    return quartoService.saveQuarto(quarto);
  }

  @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Quarto updateQuarto(@PathVariable String id,
      @RequestBody @NotNull Quarto quarto) throws Exception {
    return quartoService.saveQuarto(quarto);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping(value = "{id}")
  public boolean updateQuarto(@PathVariable Long id) throws Exception {
    quartoService.deleteQuarto(id);
    return true;
  }
}