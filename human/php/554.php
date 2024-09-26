<?php
if ( isset($_GET['showimage']) && $_GET['showimage'] == 'yes' ) {
    header('Content-Type: image/jpeg'); 
    readfile('/path/to/file.jpg');
}