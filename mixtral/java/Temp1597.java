import javax.crypto.*;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class Temp1597 {
    public static void main(String[] args) throws Exception {

        // Sample public and private keys (Base64 encoded for demonstration)
        String pubKeyString = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0VZ3+VZJzGZmfjJ2t3t4yN8uJ5mXQJ1qH2/0oSb/g2cY8X/8/2tW3Mtb6vG2C9HdG2b8n4a5FQ5jeD9FQ5wl8t5Z8Xw2k9zJ2Ht9J9j8u5kvs5k2m1KJ5v/0JvI1fFz5t9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ5gT9Z9xjv2Z9Gp9mZ5X8zJ5x2mFQ==";
        String privKeyString = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDRVnf