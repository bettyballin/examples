<?php
$chroot = '/var/www/site/userdata/';
$basefolder = '/var/www/site/userdata/mine/';

$param = '../../../../etc/password';
$fullpath = realpath($basefolder . $param);

if (strpos($fullpath, $chroot) !== 0) {
  echo "GOTCHA";
} else {
  echo "Path is within chroot";
}
?>