<?php

function sanitize_text_field($str) {
    return trim( stripslashes( htmlspecialchars( $str, ENT_QUOTES ) ) );
}

$data = array(
    'user_password' => 'your_password_here'
);

$valid = true;

if ( sanitize_text_field( $data['user_password'] ) !== $data['user_password']  ) {
    $valid=false;
}

echo $valid ? 'Valid' : 'Not Valid';

?>