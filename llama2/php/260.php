class Session {
    const SESSION_VALIDATOR = 'is_valid';

    private $id;
    private $data = array();

    public function __construct() {
        // Initialize the session
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }

        // Set the session ID
        $this->id = session_id();

        // Validate the session
        if (!$this->validateSession()) {
            $this->destroy();
            session_start();
            $this->setId(session_id());
        }
    }

    private function validateSession() {
        return isset($_SESSION[self::SESSION_VALIDATOR]) && $_SESSION[self::SESSION_VALIDATOR];
    }

    private function destroy() {
        session_unset();
        session_destroy();
    }

    private function setId($id) {
        $this->id = $id;
    }

    public function set($key, $value) {
        $_SESSION[$key] = $value;
        $this->data[$key] = $value;
    }

    public function get($key) {
        return isset($this->data[$key]) ? $this->data[$key] : null;
    }

    public function getAll() {
        return $this->data;
    }
}

// Example usage
$session = new Session();
$session->set('test', 'Hello, World!');
echo $session->get('test'); // Output: Hello, World!