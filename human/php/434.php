<?php
$site = 'siteA'; // or 'siteB'

$sites = array(
  'siteA',
  'siteB'
);
if (in_array($site, $sites)) {
  include "configs/$site/config.php";
} else {
  throw new Exception("Unknown site");
}
?>