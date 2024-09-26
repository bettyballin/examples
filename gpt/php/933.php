
<?php
include('Crypt/TripleDES.php');
include('Crypt/Hash.php');

$password = 'eKhfdPKO54OddrfgghuBGHsA5BGTYHon';
$salt = pack("c*", -87, -101, -56, 50, 86, 52, -29, 3);
$iterations = 19;
$text = "foobar";

// Derive the key and
