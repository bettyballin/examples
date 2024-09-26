<?php
$fp = fsockopen("gmail-smtp-in.l.google.com", 25, $errno, $errstr, 30);
if (!$fp) {
    echo "$errstr ($errno)\n";
} else {
    $out = "EHLO mail.example.com\r\n";
    fwrite($fp, $out);
    while (!feof($fp)) {
        echo fgets($fp, 128);
    }
    fclose($fp);
}
?>