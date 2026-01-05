package com.guardians.guardiansfin.infrastructure.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.math.BigDecimal

interface SpringDataInvestimentoRepository : JpaRepository<InvestimentoEntity, String> {
    @Query("SELECT COALESCE(SUM(i.valorAporte), 0) FROM InvestimentoEntity i WHERE i.cpfCliente = :cpf AND i.cnpjEmissor = :cnpj")
    fun calcularSaldoTotal(cpf: String, cnpj: String): BigDecimal
}