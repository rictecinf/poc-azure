package br.com.demo.demo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DomainExemplo {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @Builder.Default
    private Situacao situacao = Situacao.ATIVO;

    public enum Situacao {
        ATIVO,
        INATIVO
    }

    public boolean is(Situacao situacao){
        return this.situacao.equals(situacao);
    }

}
