<?php
function add_register_field_validate($sanitized_user_login, $user_email, $errors) {
    if (empty($_POST['user_proof'])) {
        $errors->add('proofempty', '<strong>ERROR</strong>: You did not answer the proof-of-humanship question.' );
    } elseif (strcmp('serenity', strtolower(str_replace(' ', '', trim($_POST['user_proof'])))) != 0) {
        $errors->add('prooffail', '<strong>ERROR</strong>: You did not answer the proof-of-humanship question correctly.' );
    }
    return $errors;
}
?>