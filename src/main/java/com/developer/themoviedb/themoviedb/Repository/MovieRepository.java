package com.developer.themoviedb.themoviedb.Repository;

import okhttp3.*;


import java.io.IOException;

public class MovieRepository {
    private OkHttpClient client;

    public String makeGetRequest(String apiUrl){
        client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(apiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMzY2MGU4ZDNmNWM0OTdjMDgzZGRmYjc4ZWRlODdhZCIsInN1YiI6IjY1Nzc3ZGU5NTY0ZWM3MDEzOGJjYmMxYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.0YkQj9DxXmPDjgQtyT7HBY6IfP5WiupweuuouuijQzY")
                .build();
        try{
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected response: " + response.code());
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
