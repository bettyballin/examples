<?php
$paths = array(
    'D:/wwwroot/User1/' => 'D:/wwwroot/User1/',
    'D:/wwwroot/User2/' => 'D:/wwwroot/User2/'
);

foreach ($paths as $path => $open_basedir) {
    ini_set('open_basedir', $open_basedir);
    echo '[' . $path . ']' . "\n";
    echo 'open_basedir=' . ini_get('open_basedir') . "\n";
}
?>