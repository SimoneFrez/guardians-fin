package com.guardians.guardiansfin.domain.service

import com.guardians.guardiansfin.domain.model.ExposicaoConsolidada
import com.guardians.guardiansfin.domain.repository.InvestimentoRepository
import java.math.BigDecimal

class ValidadorRiscoFgc(private val repository: InvestimentoRepository) {

    fun analisarRisco(cpf: String, cnpj: String, novoValor: BigDecimal): ExposicaoConsolidada {
        // Agora o método será reconhecido pelo compilador
        val saldoAtual = repository.buscarSaldoTotalPorCpfECnpj(cpf, cnpj) ?: BigDecimal.ZERO
        val saldoPosAporte = saldoAtual.add(novoValor)

        return ExposicaoConsolidada(cpf, cnpj, saldoPosAporte)
    }
}