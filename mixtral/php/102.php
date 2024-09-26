<?php

if ($_SERVER['REQUEST_METHOD'] != 'POST') {
    header('Location: error-page.html');
    exit();
}

// Your POST processing code here

?>
<form action="" method="post">
    <input type="text" name="example">
    <button type="submit">Submit</button>
</form>