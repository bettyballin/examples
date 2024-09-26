$allowed_values = ['value1', 'value2'];
if(in_array($_GET['major'], $allowed_values)) {
    // ...
}

// or

$pathParts = explode('/', $_SERVER['REQUEST_URI']);

if (count($pathParts) > 3 && in_array($pathParts[3], ['value1', 'value2'])){
   header("HTTP/1.1 301 Moved Permanently");
   // ...
}