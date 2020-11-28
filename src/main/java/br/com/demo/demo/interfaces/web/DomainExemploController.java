package br.com.demo.demo.interfaces.web;

import br.com.demo.demo.domain.DomainException;
import br.com.demo.demo.domain.DomainExemplo;
import br.com.demo.demo.infrastructure.DomainExemploRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class DomainExemploController {

    private final DomainExemploRepository domainExemploRepository;

    @GetMapping("/{id}")
    public ResponseEntity<DomainExemplo> findById(Integer id) throws  DomainException {

        //final Optional<DomainExemplo> domainExemplo = Optional.ofNullable(domainExemploRepository.findById(id)
            //    .orElseThrow(() -> new DomainException("Dominio não encontrado")));
        final DomainExemplo domainExemplo = DomainExemplo.builder().id(1L).nome("teste").build();
        return  ResponseEntity.ok(domainExemplo);

    }
}
