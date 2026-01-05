package com.guardians.guardiansfin.infrastructure.persistence

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "investimentos")
class InvestimentoEntity(
    @Id
    val id: String? = null,
    val cpfCliente: String,
    val cnpjEmissor: String,
    val valorAporte: BigDecimal,
    val tipoProduto: String
)