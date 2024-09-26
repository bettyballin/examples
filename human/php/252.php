<?php

$header = "HTTP/1.1 200 OK
Date: Mon, 16 May 2011 13:54:19 GMT
Server: Apache
Accept-Ranges: bytes
Content-Length: 16457
Cache-Control: max-age=300, must-revalidate
Expires: Mon, 16 May 2011 13:59:19 GMT
Vary: Accept-Encoding,Cookie
Connection: close
Content-Type: text/html; charset=UTF-8";

$headers = explode("\n", $header);
foreach ($headers as $h) {
    header($h);
}

?>