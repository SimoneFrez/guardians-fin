package com.guardians.guardiansfin.application.web

import com.guardians.guardiansfin.domain.service.ValidadorRiscoFgc
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/v1/investimentos")
class InvestimentoController(
    private val validador: ValidadorRiscoFgc
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun realizarAporte(@RequestBody @Valid request: InvestimentoRequest): Map<String, Any> {

        val analise = validador.analisarRisco(
            request.cpf,
            request.cnpjEmissor,
            request.valor
        )

        return mapOf(
            "status" to "Processado",
            "alerta_fgc" to analise.ultrapassouLimiteFgc(),
            "percentual_uso" to analise.calcularPercentualUsoFormatado()
        )
    }
}

/**
 * DTO colocado aqui para evitar erro de 'Unresolved reference'
 */
data class InvestimentoRequest(
    @field:NotBlank(message = "CPF é obrigatório")
    val cpf: String,

    @field:NotBlank(message = "CNPJ do emissor é obrigatório")
    val cnpjEmissor: String,

    @field:Positive(message = "O valor deve ser maior que zero")
    val valor: BigDecimal,

    @field:NotBlank(message = "Tipo de produto é obrigatório")
    val tipo: String
)