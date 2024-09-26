<?php

if (!function_exists('is_logged_in')){

    function is_logged_in(){
        // Get current CI instance
        $CI =& get_instance();
        // use $CI->session instead of $this->session
        $user = $CI->session->userdata('is_logged_in');
        if (!isset($user)) { return false; } else { return true; }
    } 

}

// Test the function
if (is_logged_in()) {
    echo "You are logged in.";
} else {
    echo "You are not logged in.";
}