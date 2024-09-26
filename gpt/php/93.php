
   use Cake\Utility\Security;

   $key = 'YOUR-SECRET-KEY'; // Store this key securely
   $dataToEncrypt = 'Sensitive data';

   // Encrypt the data
   $encryptedData = Security::encrypt($dataToEncrypt, $key);
   
   // Now you can store $encryptedData in the database
   
