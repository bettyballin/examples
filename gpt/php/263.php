
   $finfo = finfo_open(FILEINFO_MIME_TYPE);
   $mimeType = finfo_file($finfo, $_FILES['uploaded_file']['tmp_name']);
   finfo_close($finfo);
   
