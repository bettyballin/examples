
function encrypt($plaintext, $key) {
    $iv = 'aaaaaaaaaaaaaaaa';
    $key = substr(hash('sha256', $key, true), 0, 32); // Ensure
