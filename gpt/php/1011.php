
class Signature {
    public function hash($key, $msg) {
        return hash_hmac('sha256', $msg, $
