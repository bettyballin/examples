
   $date = filter_input(INPUT_GET, 'date', FILTER_SANITIZE_STRING);
   // Validate the date format, for example, YYYY-MM-DD
   if (!preg_match('/^\d{4}-\d{2}-\d{2}$/', $date)) {
       // Invalid date format
       die('Invalid date format.');
   }

   // You can also validate that it's a proper date
   $dateParts = explode('-', $date);
   if (!checkdate($dateParts[1], $dateParts[2], $dateParts[0])) {
       // Not a valid date
       die('Invalid date.');
   }
   
