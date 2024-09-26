<?php
if(isset($_SERVER['HTTP_X_REQUESTED_WITH']) && $_SERVER['HTTP_X_REQUESTED_WITH'] == 'XMLHttpRequest') {
    // AJAX request
    echo "This is an AJAX request.";
}
else{
   header('Location: /');
   exit();
}
?>