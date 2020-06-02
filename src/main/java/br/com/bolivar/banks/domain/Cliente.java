package br.com.bolivar.banks.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"cpf"}, exclude = {"nome", "idade"})
public class Cliente {

    private Integer cpf;
    private String nome;
    private Integer idade;
}
