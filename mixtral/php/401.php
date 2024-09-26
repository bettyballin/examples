class Encryption {
    protected static $ivMessage = 'your_iv_message';
    protected static $apiSecret = 'your_api_secret';

    protected static function hex_string_to_ascii($hex_string) {
        return hex2bin($hex_string);
    }

    protected static function encrypt($stringData) {
        $encrypted = false;

        // Specify AES-256 encryption with CBC mode and PKCS#7 padding
        $cipher_method = 'AES-256-CBC';

        $iv = substr(hash('sha256', static::$ivMessage), 0, 16);

        // Convert the secret key to a binary string
        $apiSecretBinaryString = static::hex_string_to_ascii(static::$apiSecret);

        $encrypted = openssl_encrypt($stringData, $cipher_method, $apiSecretBinaryString, OPENSSL_RAW_DATA | OPENSSL_ZERO_PADDING, $iv);

        return base64_encode($encrypted);
    }

    public static function main() {
        $stringData = 'your_string_data';
        echo static::encrypt($stringData);
    }
}

Encryption::main();