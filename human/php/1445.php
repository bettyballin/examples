<?php
session_start();

function csrf_token() {
    return bin2hex(random_bytes(35));
}

function create_csrf_token() {
    if (isset($_SESSION['csrf_token'])) {
        return $_SESSION['csrf_token'];
    }
    $token = csrf_token();
    $_SESSION['csrf_token'] = $token;
    $_SESSION['csrf_token_time'] = time();
    return $token;
}

function csrf_token_tag() {
    $token = create_csrf_token();
    return '<input type="hidden" name="csrf_token" value="' . $token . '">';
}

$csrf_token = csrf_token_tag();
?>

<form action="" method="post">
    ...
    <?= $csrf_token; ?>
</form>

<form action="" method="post">
    ...
    <?= create_csrf_token(); ?>
</form>