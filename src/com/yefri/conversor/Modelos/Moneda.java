package com.yefri.conversor.Modelos;

public class Moneda {
    String monedaBase;
    String monedaCambio;
    double tipoDeCambio;
    double cambioResultante;

    public Moneda(Cambio cambioMoneda){
        this.monedaBase = cambioMoneda.baseCode();
        this.monedaCambio = cambioMoneda.targetCode();
        this.tipoDeCambio = cambioMoneda.conversionRate();
        this.cambioResultante = cambioMoneda.conversionResult();
    }

    @Override
    public String toString() {
        return "Moneda Base= " + "["+ monedaBase + "]" + " | moneda Cambio= " + "[" + monedaCambio + "]" +
                " | tipo de Cambio 1 "+monedaBase+" = " + tipoDeCambio +
                " | Total convertido= " +cambioResultante;

    }
}
