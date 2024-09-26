
   $fileName = $_FILES["file"]["name"];
   if (!preg_match('/^[a-zA-Z0-9_-]+$/', pathinfo($fileName, PATHINFO_FILENAME))) {
       die("Invalid file name.");
   }
   
