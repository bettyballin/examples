class AuthValidator {
    private $auth_key;

    public function __construct($auth_key) {
        $this->auth_key = $auth_key;
    }

    public function validateAuthKey($authKey) {
        return $this->auth_key === $authKey;
    }
}

$validator = new AuthValidator('your_auth_key_here');
echo var_export($validator->validateAuthKey('your_auth_key_here'), true) . "\n";