package br.com.bolivar.banks.domain;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Conta {

    @NotNull
    private String agencia;
    @NotNull
    private String numero;
    @NotNull
    private Cliente cliente;
    private BigDecimal saldo;

}
