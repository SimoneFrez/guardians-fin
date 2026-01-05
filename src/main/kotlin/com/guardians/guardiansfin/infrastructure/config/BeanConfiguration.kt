package com.guardians.guardiansfin.infrastructure.config

import com.guardians.guardiansfin.domain.repository.InvestimentoRepository
import com.guardians.guardiansfin.domain.service.ValidadorRiscoFgc
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun validadorRiscoFgc(investimentoRepository: InvestimentoRepository): ValidadorRiscoFgc {
        return ValidadorRiscoFgc(investimentoRepository)
    }
}


