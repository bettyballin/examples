<?php
exec('openssl smime -sign -signer mycert.pem -inkey mycert.key < input > output');
?>