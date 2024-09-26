<?php
if (isset($_GET['page'])) {
    if (!ctype_digit($_GET['page'])){
       die('Invalid page value !!');
    }
    else{
     // continue with the query...
     echo "Page number is valid.";
    }
} else {
    die('Page value not set !!');
}
?>