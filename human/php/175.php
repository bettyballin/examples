<?php
$license = 'your_license_here'; // replace with your license input

if(preg_match('/^[a-z0-9]+$/', $license)) {
   // Ok to proceed with database interaction...
   echo 'License is valid!';
} else {
   die('NO USAGE FOR YOU!');
}
?>