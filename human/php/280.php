<?php
$allowed = array("admin_index", "page1", "page2");

if(isset($_GET['page']) && in_array($_GET['page'], $allowed)){
    include("admin/" . $_GET['page'] . ".php");
}
else{
    echo "Error: Page not found.";
}
?>