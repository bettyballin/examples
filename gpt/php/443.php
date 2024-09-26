
   $maxInputVars = ini_get('max_input_vars');
   $inputVarsCount = count($_POST, COUNT_RECURSIVE) + count($_GET, COUNT_RECURSIVE) + count($_COOKIE); // Add other
