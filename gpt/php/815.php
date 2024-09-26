
class SeededCSPRNG {
    private $seed;
    private $counter;

    public function __construct($seed) {
        $this->seed = $seed;
        $this->counter = 0;
    }

    private function hmac($key, $data) {
        return hash_hmac('sha256', $data, $key, true);
    }

    public
