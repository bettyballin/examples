
   $secret_token = 'YOUR_SECRET_TOKEN';
   if (empty($_POST['token']) || $_POST['token'] !== $secret_token) {
       exit('Unauthorized access.');
   }
   
