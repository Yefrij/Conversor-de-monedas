package com.yefri.conversor.Calculos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yefri.conversor.Modelos.Cambio;
import com.yefri.conversor.Modelos.Moneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedas {
    public Moneda calculaDivisa(String baseCode, String targetCode, double monto){
        String apiKey = "c5a91eb1761368102e2a6b03";
        String direccion = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+baseCode+"/"+targetCode+"/"+monto;
        Gson gson= new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            //hacer un response ********************
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            //System.out.println(json);
            Cambio cambioMoneda = gson.fromJson(json, Cambio.class);
            Moneda divisaConvertida = new Moneda(cambioMoneda);
            return divisaConvertida;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
