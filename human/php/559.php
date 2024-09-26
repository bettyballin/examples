<?php

function user_files($file_name = "")
{
    // Check user is logged in
    if (isset($user) && method_exists($user, 'logged_in') && $user->logged_in())
    {
        // Check file_name is valid and only contains valid chars
        if (preg_match('/^[A-Za-z0-9]{1,32}\.[A-Za-z]{3,4}$/', $file_name))
        {
            // Now check file belongs to user
            if (property_exists($user, 'records') && $file_name == $user->records)
            {
                $path = '/path/to/your/files/'; // replace with your actual path
                header('Content-Type: '.get_mime_by_extension($path.$file_name));
                readfile($path.$file_name);
            } else {
                echo 'You do not have access to this file';
            }
        } else {
            echo 'Invalid file name';
        }
    } else {
        echo 'You are not logged in';
    }
}

// usage
$user = new stdClass();
$user->logged_in = function() { return true; };
$user->records = 'example.txt';
user_files('example.txt');

?>