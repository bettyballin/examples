<?php
exec('openssl genrsa -out private.pem 1024');
exec('openssl rsa -in private.pem -out public.pem -outform PEM -pubout');
?>