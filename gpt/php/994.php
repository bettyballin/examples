
<?php
$key_from_python = base64_decode('yxSWeywwKBWGINr4GyJpfE29xWTnpknff+ExruiKs2o=');
$ciphertext_from_python = base64_decode('Up/mRFxf3nhDgviOmzuRx09Mb8IJL49WPkc9');
$nonce_from_python = base64_decode('x2bc4+QDPk2beZKd');

// The tag is the last 8 bytes of the ciphertext when using AES-256-CCM with a tag length of 8
$tag_length = 8;
$tag = substr($ciphertext_from_python, -$tag_length);
$ciphertext_from_python = substr($ciphertext_from_python, 0, -$
