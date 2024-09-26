<?php
    error_reporting(0);
    $indexes = 'indexes-file.txt';
    $index_array = file($indexes, FILE_IGNORE_NEW_LINES);

    $l_arr = array();

    foreach($index_array as $st) {
        $section = explode('*', $st);
        $k = $section[0];
        $kklink = $section[1];
        $l_arr[] = array($k => $kklink);
    }

    //Get the search term from "string" POST variable.
    $var1 = isset($_POST['string']) ? trim($_POST['string']) : '';

    $webresults = array();

    //Loop through our lookup array.

    foreach($l_arr as $kk){
        //If the search term is present.
         if(stristr(key($kk), $var1)){
             //Add it to the results array.
            foreach($kk as $key => $value) {
                 $webresults[] = array($key => $value);
            }
        }
     }

    //Display the results in JSON format so to parse it with JavaScript.
   echo json_encode($webresults);
?>