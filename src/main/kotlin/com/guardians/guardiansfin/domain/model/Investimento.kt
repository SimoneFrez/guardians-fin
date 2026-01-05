package com.guardians.guardiansfin.domain.model

import java.math.BigDecimal
import java.math.RoundingMode

data class Investimento(
    val id: String?,
    val cpfCliente: String,
    val cnpjEmissor: String,
    val valorAporte: BigDecimal,
    val tipoProduto: String
)

data class ExposicaoConsolidada(
    val cpfCliente: String,
    val cnpjEmissor: String,
    val saldoTotal: BigDecimal
) {
    private val TETO_FGC = BigDecimal("250000.00")

    fun ultrapassouLimiteFgc(): Boolean = saldoTotal > TETO_FGC

    fun calcularPercentualUso(): BigDecimal {
        if (saldoTotal == BigDecimal.ZERO) return BigDecimal.ZERO
        return saldoTotal.divide(TETO_FGC, 4, RoundingMode.HALF_UP)
            .multiply(BigDecimal("100"))
    }

    // Renomeado para evitar o erro de 'Conflicting overloads'
    fun calcularPercentualUsoFormatado(): String {
        return "${calcularPercentualUso().setScale(2, RoundingMode.HALF_UP)}%"
    }
}