<?php 
    session_start();
    
    function generateString($len = 15) {
        $string = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
        $stringLength = strlen($string);
        $key = '';
        for ($i = 0; $i < $len; $i++) {
            $key .= $string[rand(0, $stringLength - 1)];
        }
        return $key;
    }
    
    $_SESSION['token'] = generateString(15);
    
?>