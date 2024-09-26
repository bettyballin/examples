
   try {
       $bytes = random_bytes(4);
       $randomInt = unpack("L", $bytes)[1] & 0x7FFFFFFF; // For a positive number
   } catch (Exception $e) {
       // Handle the exception
   }
   
