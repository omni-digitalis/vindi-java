package br.com.vindi.services;

import br.com.vindi.config.VindiConfig;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * The main communication class, it tries to initialize the VindiConfig
 */
public final class Vindi {

    private Retrofit retrofit;

    public Vindi(String privateKey) throws Exception {
        VindiConfig.init(privateKey);
        setup();
    }

    public Vindi() throws Exception {
        VindiConfig.init();
        setup();
    }

    private void setup() {
        final var credentials = Credentials.basic(VindiConfig.getApiUser(), VindiConfig.getPrivKey());

        final var okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    final var authRequest = chain.request()
                            .newBuilder()
                            .addHeader("Authorization", credentials)
                            .build();

                    return chain.proceed(authRequest);
                })
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(VindiConfig.getApiUrl())
                .build();
    }

}
