class CustomPasswordEncoder extends MessageDigestPasswordEncoder {

    public function __construct() {
        parent::__construct("SHA-256");
    }

    protected function mergePasswordAndSalt($password, $salt, $strict) {
        if ($password === null) {
            $password = "";
        }

        if ($salt === null || $salt === "") {
            return $password;
        }

        return $salt . $password;
    }
}