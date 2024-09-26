
   use Cake\Utility\Security;

   // To encrypt
   $value = "Hello World";
   $key = Configure::read('Security.salt');
   $encrypted = base64_encode(Security::encrypt($value, $key));

   // To decrypt
   $decrypted = Security::decrypt(base64_decode($encrypted), $key);
   
