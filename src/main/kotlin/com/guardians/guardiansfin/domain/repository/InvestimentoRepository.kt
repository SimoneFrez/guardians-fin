package com.guardians.guardiansfin.domain.repository

import java.math.BigDecimal

interface InvestimentoRepository {
    fun buscarSaldoTotalPorCpfECnpj(cpf: String, cnpj: String): BigDecimal?
}