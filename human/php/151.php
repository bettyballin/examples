<?php
include "everything.php";

// do some work

// Bounce the browser to a "view" url or display an error.
if ($success) {
    header('Location: view.php');
    exit;
} else {
    echo 'An error occurred!';
}