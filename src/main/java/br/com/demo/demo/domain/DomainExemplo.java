package br.com.demo.demo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity( name = "DomainExemplo")
@ToString
public class DomainExemplo {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @Builder.Default
    private Situacao situacao = Situacao.ATIVO;
    @Builder.Default
    @Transient
    private List<String> properties = new ArrayList<>();

    public enum Situacao {
        ATIVO,
        INATIVO
    }

    public boolean is(Situacao situacao){
        return this.situacao.equals(situacao);
    }

    public void properties(String p){
        this.properties.add(p);
    }

}
