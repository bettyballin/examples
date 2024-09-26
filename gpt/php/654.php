
if (isset($_POST['search'])) { 
  $search = array_map(function($input) { return htmlspecialchars($input, ENT_QUOTES, 'UTF-8'); }, $_POST);
} else {
  $search = array_map('rawurldecode', $_GET);
  $search = array_map(function($input) { return
