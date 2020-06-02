package br.com.bolivar.banks.domain;

import lombok.*;
import javax.validation.constraints.*;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.*;
import static java.util.Objects.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(of = {"codigo"}, exclude = {"hasNome","hasCodigo", "nome", "contas"})
public class Banco {

    @NotNull
    private Integer codigo;
    @NotNull
    private String nome;
    private Integer hasNome;
    private Integer hasCodigo;
    private List<Conta> contas;

    public Integer getHasNome(){
        return isNotBlank(getNome()) ? 1 : 0;
    }

    public Integer getHasCodigo(){
        return nonNull(getCodigo()) ? 1 : 0;
    }
}
