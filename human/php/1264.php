<?php

$docroot = getopt("t:");

if (isset($docroot['t'])) {
    $docroot = $docroot['t'];
    $command = "php -S localhost:8000 -t $docroot";
    exec($command);
} else {
    echo "Please specify the document root using the -t option.\n";
}

?>