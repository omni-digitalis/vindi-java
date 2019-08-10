package br.com.vindi.config;

import br.com.vindi.exceptions.KeyNotFoundException;

import java.io.IOException;
import java.util.Properties;

/**
 * Vindi Environment Configuration
 */
public final class VindiConfig {

    private static final String PRIVATE_KEY_ENV = "VINDI_PRIVATE_KEY";
    private static final String PUBLIC_KEY_ENV = "VINDI_PUBLIC_KEY";
    private static final String PROPERTIES = "app.properties";
    private static String privateKey;
    private static String publicKey;
    private static String apiUrl;

    private VindiConfig() {
    }

    public static void init(String privKey, String pubKey) throws KeyNotFoundException, IOException {
        if (privKey == null) {
            throw new KeyNotFoundException("Private key cannot be null");
        }
        privateKey = privKey;
        publicKey = pubKey;
        loadUrl();
    }

    /**
     * Tries to load the Vindi private key from a environment variable VINDI_PRIVATE_KEY
     */
    public static void init() throws KeyNotFoundException, IOException {
        privateKey = System.getenv(PRIVATE_KEY_ENV);
        publicKey = System.getenv(PUBLIC_KEY_ENV);

        if (privateKey == null || publicKey == null) {
            throw new KeyNotFoundException("Vindi private or public key not found in: " + PRIVATE_KEY_ENV + " | " + PUBLIC_KEY_ENV);
        }

        loadUrl();
    }

    /**
     * @return The Vindi private key
     */
    public static String getPrivKey() {
        return privateKey;
    }

    /**
     * @return The Vindi public key
     */
    public static String getPublicKey() {
        return publicKey;
    }

    /**
     * @return The Vindi Api Url
     */
    public static String getApiUrl() {
        return apiUrl;
    }

    /**
     * Loads the Vindi Api Url from a .properties file
     */
    private static void loadUrl() throws IOException {
        var properties = new Properties();
        var propertiesStream = VindiConfig.class.getResourceAsStream("/" + PROPERTIES);

        properties.load(propertiesStream);
        propertiesStream.close();

        apiUrl = properties.getProperty(EnvironmentKey.VINDI_API_URL.string());
    }

}
