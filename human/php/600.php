<?php
if (isset($_GET['page'])) {
    $page = basename($_GET['page']);
    if (file_exists($page . ".php")) {
        include($page . ".php");
    } else {
        echo "Page not found.";
    }
} else {
    echo "No page specified.";
}
?>