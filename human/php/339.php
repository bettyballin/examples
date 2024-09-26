<?php
session_start();

$page_section = 'example_section'; // replace with your current page section

if(isset($_SESSION['last_visited_section']) && $_SESSION['last_visited_section'] != $page_section){
    //New section visited, you could reset $_SESSION['last_visited_section'] or anything relative to your security mechanism here
    $_SESSION['last_visited_section'] = $page_section;
}

// don't forget to set the initial value
if(!isset($_SESSION['last_visited_section'])){
    $_SESSION['last_visited_section'] = $page_section;
}
?>