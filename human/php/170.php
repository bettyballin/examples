<?php
if(isset($_SERVER['HTTP_X_REQUESTED_WITH'])) {
    $requestedwith = strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) ;
    if($requestedwith === "xmlhttprequest") {
        echo "Requested by Ajax";
    } else {
        echo "Not requested by Ajax";
    }
} else {
    echo "HTTP_X_REQUESTED_WITH is not set";
}
?>