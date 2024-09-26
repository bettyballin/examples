<?php
class Utils {
    public static function isAjax() {
        return (isset($_SERVER['HTTP_X_REQUESTED_WITH']) && $_SERVER['HTTP_X_REQUESTED_WITH']=="XMLHttpRequest");
    }
}

// Test the function
if(Utils::isAjax()) {
    echo "This is an AJAX request.";
} else {
    echo "This is not an AJAX request.";
}
?>