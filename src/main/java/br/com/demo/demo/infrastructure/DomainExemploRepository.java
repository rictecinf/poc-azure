package br.com.demo.demo.infrastructure;

import br.com.demo.demo.domain.DomainExemplo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DomainExemploRepository extends PagingAndSortingRepository<DomainExemplo,Integer> {
}
