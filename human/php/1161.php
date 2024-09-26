class Encrypter {
    protected $key;
    protected $cipher;

    public function __construct($key, $cipher = 'AES-256-CBC') {
        $this->key = $key;
        $this->cipher = $cipher;
    }

    /**
     * Encrypt the given value.
     *
     * @param  string  $value
     * @return string
     *
     * @throws \Illuminate\Contracts\Encryption\EncryptException
     */
    public function encrypt($value)
    {
        $iv = random_bytes($this->getIvSize());
        $value = openssl_encrypt(serialize($value), $this->cipher, $this->key, 0, $iv);
        if ($value === false) {
            throw new EncryptException('Could not encrypt the data.');
        }
        $mac = $this->hash($iv = base64_encode($iv), $value);
        $json = json_encode(compact('iv', 'value', 'mac'));
        if (! is_string($json)) {
            throw new EncryptException('Could not encrypt the data.');
        }
        return base64_encode($json);
    }

    /**
     * Decrypt the given value.
     *
     * @param  string  $payload
     * @return string
     *
     * @throws \Illuminate\Contracts\Encryption\DecryptException
     */
    public function decrypt($payload)
    {
        $payload = $this->getJsonPayload($payload);
        $iv = base64_decode($payload['iv']);
        $decrypted = openssl_decrypt($payload['value'], $this->cipher, $this->key, 0, $iv);
        if ($decrypted === false) {
            throw new DecryptException('Could not decrypt the data.');
        }
        return unserialize($decrypted);
    }

    /**
     * Get the IV size for the cipher.
     *
     * @return int
     */
    protected function getIvSize()
    {
        return 16;
    }

    /**
     * Get the JSON payload for the given value.
     *
     * @param  string  $payload
     * @return array
     *
     * @throws \Illuminate\Contracts\Encryption\DecryptException
     */
    protected function getJsonPayload($payload)
    {
        $payload = json_decode(base64_decode($payload), true);
        if (! $payload || ! is_array($payload) || ! array_key_exists('iv', $payload) || ! array_key_exists('value', $payload) || ! array_key_exists('mac', $payload)) {
            throw new DecryptException('Invalid payload.');
        }
        return $payload;
    }

    /**
     * Create a MAC for the given value.
     *
     * @param  string  $iv
     * @param  string  $value
     * @return string
     */
    protected function hash($iv, $value)
    {
        return hash_hmac('sha256', $iv.$value, $this->key);
    }
}

class EncryptException extends Exception {}
class DecryptException extends Exception {}

$key = 'your_secret_key_here';
$encrypter = new Encrypter($key);

$value = 'Hello, World!';
$encrypted = $encrypter->encrypt($value);
echo "Encrypted: $encrypted\n";

$decrypted = $encrypter->decrypt($encrypted);
echo "Decrypted: $decrypted\n";