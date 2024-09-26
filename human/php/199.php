<?php
exec("openssl smime -decrypt -inkey mycert.key -certfile mycert.pem < input > output");
?>