<?php
function checkIPAddress()
{
   // Get IP Address using $_SERVER['REMOTE_ADDR'];
   $ipaddress = (isset($_SERVER['REMOTE_ADDR'])) ? $_SERVER['REMOTE_ADDR'] : '';

   if (filter_var($ipaddress, FILTER_VALIDATE_IP) == false)
   {
      $ipaddress = '';
      die();
   }
}

checkIPAddress();
?>