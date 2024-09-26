
   function sanitizeData($data) {
       if (is_string($data)) {
           return htmlspecialchars($data, ENT_QUOTES, 'UTF-8');
       } elseif (is_array($data)) {
           return array
