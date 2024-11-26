package com.alura.conversor;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PedidoMoneda {

    public Monedas pedirMoneda(int opcion, int valor) {
        String parMonedas = "";



        if (opcion == 1) {
            parMonedas = Moneda.USD.name() + "/" + Moneda.ARS.name() + "/" + valor;
        } else if (opcion == 2) {
            parMonedas = Moneda.ARS.name() + "/" + Moneda.USD.name() + "/" + valor;

        } else if (opcion == 3) {
            parMonedas = Moneda.USD.name() + "/" + Moneda.BRL.name() + "/" + valor;

        } else if (opcion == 4) {
            parMonedas = Moneda.BRL.name() + "/" + Moneda.USD.name() + "/" + valor;

        } else if (opcion == 5) {
            parMonedas = Moneda.USD.name() + "/" + Moneda.COP.name() + "/" + valor;

        } else if (opcion == 6) {
            parMonedas = Moneda.COP.name() + "/" + Moneda.USD.name() + "/" + valor;

        } else {
            System.out.println("opción no valida");

        }


        String url = "https://v6.exchangerate-api.com/v6/f5ebdf769b752b677d510416/pair/" + parMonedas;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), Monedas.class);
    }
}
