<?php
$ctx = stream_context_create(['ssl' => [
    'verify_peer' => true,
    'cafile' => 'd:/sandbox/mycerts.pem',
    'CN_match' => 'ftp-12345678.mywebhoster.com'
]]);
$dirHandle = opendir('ftps://username:password@ftp-12345678.mywebhoster.com/', $ctx);
while (($file = readdir($dirHandle)) !== false) {
    echo "filename: $file\n";
}
closedir($dirHandle);
?>