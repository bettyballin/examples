
   $ipaddress = filter_var($ipaddress, FILTER_VALIDATE_IP);
   if ($ipaddress === false) {
       // Handle the error, the IP address is not valid
       $ipaddress = 'UNKNOWN';
   }
   
