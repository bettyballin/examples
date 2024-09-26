
  $number = $_POST['number'];
  if (filter_var($number, FILTER_VALIDATE_INT) !== false) {
      // The input is
