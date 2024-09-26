<?php
function scanForInsecureCode($code) {
  $insecure = array("javascript", "vbscript", "expression", "applet", "meta", "xmlhttp");
  foreach ($insecure as $value) {
    if (strpos(strtolower($code), $value) !== false) {
      return true;
    }
  }
  return false;
}

// Test the function
$code = "<script>alert('XSS')</script>";
echo scanForInsecureCode($code) ? "Insecure code detected" : "No insecure code detected";
?>