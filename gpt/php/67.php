
   $safe_url = escapeshellarg($imageurl);
   exec("convert $safe_url -thumbnail 80x500 images/out.jpg");
   
