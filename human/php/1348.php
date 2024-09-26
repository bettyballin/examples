<?php
exec('openssl rsa -in private.pem -pubout -outform DER -out public.der');
?>