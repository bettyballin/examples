
   $url = "http://externalwebsite.com/page.html";
   $ch = curl_init();
   curl_setopt($ch, CURLOPT_URL, $url);
   curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
   $content = curl_exec($ch);
   curl_close($ch);
   
   echo $content;
   
