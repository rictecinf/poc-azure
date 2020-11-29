package br.com.demo.demo;

import br.com.demo.demo.domain.DomainExemplo;
import br.com.demo.demo.infrastructure.DomainExemploRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class DemoApplication implements ApplicationRunner {

	private  final DomainExemploRepository domainExemploRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("Metodo Run !!!");

		List<DomainExemplo> domainExemploList = new ArrayList<>();
		domainExemploList.add( DomainExemplo.builder().id(1l).nome("teste1").build());
		domainExemploList.add( DomainExemplo.builder().id(2l).nome("teste2").build());
		domainExemploList.add( DomainExemplo.builder().id(3l).situacao(DomainExemplo.Situacao.INATIVO).nome("teste3").build());

		final Iterable<DomainExemplo> domainExemplos = domainExemploRepository.saveAll(domainExemploList);

		List<DomainExemplo> result = new ArrayList<>();

		domainExemplos.forEach(result::add);

		result.stream().filter(d->  d.getSituacao().equals(DomainExemplo.Situacao.INATIVO)).forEach( d-> System.out.println(d));

	}
}
