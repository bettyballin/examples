<?php

// Wrap everything in an IIFE so we don't create global variables
(function() {
  $ID_MAP = [];

  $onClickAction = function($event) {
    // Exit if there is no ID stored
    if(!isset($ID_MAP[$event->currentTarget])) return;
    
    // Retrieve and log ID
    $id = $ID_MAP[$event->currentTarget];
    echo $id . "\n";
  };
  
  $btns = [];
  foreach ($btns as $btn) {
    // Skip if it doesn't have an ID
    if(!isset($btn['data-id'])) continue;

    // Store and hide `data-id` attribute
    $ID_MAP[$btn] = $btn['data-id'];
    unset($btn['data-id']);

    // Add event listener
    // Note: PHP does not support event listeners like JavaScript does.
    //       This code will not work as expected in a PHP environment.
  }
})();

?>