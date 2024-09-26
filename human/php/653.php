<?php
/*
  Order deny,allow
  Deny from all
  Allow from .*domain1\.com.*
  Allow from .*domain2\.com.*
*/

$allowed_domains = array('domain1.com', 'domain2.com');
$referer = $_SERVER['HTTP_REFERER'];

if($referer) {
  $referer_domain = parse_url($referer, PHP_URL_HOST);
  if(in_array($referer_domain, $allowed_domains)) {
    // Access granted
  } else {
    header('HTTP/1.0 403 Forbidden');
    exit('Access denied');
  }
} else {
  header('HTTP/1.0 403 Forbidden');
  exit('Access denied');
}
?>