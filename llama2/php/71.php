<?php

function csrf_token() {
    // Generate a CSRF token
    $token = bin2hex(random_bytes(32));
    return $token;
}

function nonce() {
    // Generate a nonce
    $nonce = bin2hex(random_bytes(32));
    return $nonce;
}

?>

<form>
    <input type="hidden" name="_token" value="<?php echo csrf_token(); ?>">
    <input type="hidden" name="nonce" value="<?php echo nonce(); ?>">
    <!-- other form fields -->
</form>