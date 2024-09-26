
   $jsonString = $_POST['jsonData'];
   $data = json_decode($jsonString, true);
   
   if (json_last_error() !== JSON_ERROR_NONE) {
       // Handle the error - the JSON is not valid
       die("Invalid JSON");
   }
   
