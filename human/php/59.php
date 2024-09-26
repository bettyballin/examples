<?php

$password = 'SomePassword';
$salt = 'saltHashFromDB';
$sitekey = 'siteKeyFromConfig';

function pwcrypt($password, $salt, $sitekey) {
  $digest = $sitekey;
  $i = 0;
  while ($i < 10) {
    $digest = sha1($digest.'--'.$salt.'--'.$password.'--'.$sitekey);
    $i++;
  }
  return $digest;
}

echo pwcrypt($password,$salt,$sitekey);

?>