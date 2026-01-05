package com.guardians.guardiansfin.application.web.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationError(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val errors = ex.bindingResult.fieldErrors.joinToString(", ") {
            "${it.field}: ${it.defaultMessage}"
        }

        val errorResponse = ErrorResponse(
            title = "Dados Inválidos",
            status = HttpStatus.BAD_REQUEST.value(),
            details = "Um ou mais campos estão incorretos",
            fields = errors
        )

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericError(ex: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            title = "Erro Interno no Servidor",
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            details = ex.message ?: "Ocorreu um erro inesperado"
        )
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}