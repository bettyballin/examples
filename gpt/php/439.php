
   $secret = 'your-secret-key';
   $timestamp = time();
   $token = hash_hmac('sha256', $timestamp, $secret);
   
   // Embed the token and the timestamp in your form
   echo '<input type="hidden" name="token" value="' . $token . '">';
   echo '<input type="hidden" name="timestamp" value="' . $timestamp . '">';
   
