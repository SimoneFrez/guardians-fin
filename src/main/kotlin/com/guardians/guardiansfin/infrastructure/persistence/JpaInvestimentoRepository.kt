package com.guardians.guardiansfin.infrastructure.persistence

import com.guardians.guardiansfin.domain.repository.InvestimentoRepository // Importa a interface do domínio
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface JpaInvestimentoRepository : JpaRepository<InvestimentoEntity, String>, InvestimentoRepository {

    @Query("SELECT SUM(i.valorAporte) FROM InvestimentoEntity i WHERE i.cpfCliente = :cpf AND i.cnpjEmissor = :cnpj")
    override fun buscarSaldoTotalPorCpfECnpj(cpf: String, cnpj: String): BigDecimal?
}