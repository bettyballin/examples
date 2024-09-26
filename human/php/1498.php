<?php
$pass1 = trim($_POST['pass1']);

if (false !== strpos(wp_unslash($pass1), '\\')) {
    $errors->add('pass', __('<strong>Error</strong>: Passwords may not contain the character "\\".'), array('form-field' => 'pass1'));
}
?>