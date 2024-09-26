<?php

// Define the cleanInput function
function cleanInput($data) {
  $data = trim($data);
  $data = stripslashes($data);
  return htmlspecialchars($data);
}

// Define the Tools and Validate classes
class Tools {
  public static function getValue($key) {
    return isset($_REQUEST[$key]) ? $_REQUEST[$key] : '';
  }

  public static function displayError($error) {
    return $error;
  }
}

class Validate {
  public static function isGenericName($value) {
    return preg_match('/^[a-zA-Z0-9 _-]+$/', $value);
  }

  public static function isValidForDB($value, $table) {
    // Assuming a simple validation for demonstration purposes
    return true;
  }
}

// Usage
$checkboxValue = Tools::getValue('checkbox');
if (!empty($checkboxValue)) {
  // Clean the input
  $cleanCheckboxValue = cleanInput($checkboxValue);

  if (Validate::isGenericName($cleanCheckboxValue) && Validate::isValidForDB($cleanCheckboxValue, 'check_table')) {
    // Process validated and sanitized data
    echo "Validated and sanitized data: $cleanCheckboxValue";
  } else {
    $errors[] = Tools::displayError('Invalid checkbox value.');
    print_r($errors);
  }
}