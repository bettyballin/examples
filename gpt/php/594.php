
class CoreAccess {
    private static $instance = null;
    private static $allowedClasses = [
        'DataBase' => true,
        // Other core classes
    ];

    private function __construct() {
        // Private to prevent direct instantiation.
    }

    public static function getInstance() {
        if (self::$instance === null) {
            $backtrace = debug_backtrace();
