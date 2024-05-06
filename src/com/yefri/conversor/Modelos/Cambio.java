package com.yefri.conversor.Modelos;

public record Cambio(String baseCode,
                     String targetCode,
                     double conversionRate,
                     double conversionResult) {
}
