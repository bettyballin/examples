
   try {
       $content = gnupg_decrypt($gpg, $file);
   } catch (Exception $e) {
       echo 'Decryption failed: ',  $e->getMessage(), "\n";
   }
   
