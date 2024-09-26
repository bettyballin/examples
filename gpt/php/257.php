
   // Set header to application/json for correct content-type
   header('Content-Type: application/json');

   if ($login_successful) {
       echo json_encode(['success' => true, 'message' => 'Login successful.']);
   } else {
       echo json_encode(['success' => false, 'message' => 'Invalid credentials.']);
   }
   
