<?php
session_start();
if(isset($_COOKIE["LAX_SESSION"])) {
    $uuid = $_COOKIE['LAX_SESSION'];

    if(!empty($uuid) && isset($_SESSION["temp"])
        && array_key_exists($uuid, $_SESSION["temp"])){

            // Restore session data
            foreach ($_SESSION["temp"][$uuid] as $k => $v){
                $_SESSION[$k]= $v;
             }

           setcookie('LAX_SESSION', '', time() - 3600);

    }
}
?>