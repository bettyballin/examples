<?php
session_start();

/******************************
 * PERFORM AUTHORIZATION HERE *
 *   The following is added   *
 ******************************/
if(!isset($_SESSION['validated']) || $_SESSION['validated'] !== true) {
    //Not authorized to download, send header and exit
    header("HTTP/1.0 401 Unauthorized");
    exit;
}
?>