<?php

// This PHP code attempts to replicate the functionality of the provided JavaScript code
// Note that PHP is a server-side language and does not have direct access to the DOM

class ButtonIdHandler {
  private static $idMap = [];

  public static function onClickAction($target) {
    // Exit if it's not a button
    if (!isset($target['nodeName']) || $target['nodeName'] !== 'BUTTON') return;

    // Exit if there is no ID stored
    if (!isset(self::$idMap[spl_object_hash($target)])) return;

    // Retrieve and log ID
    $id = self::$idMap[spl_object_hash($target)];
    echo $id . "\n";
  }

  public static function init() {
    // Get all buttons (Note: This is a simplified example and does not actually retrieve buttons from the DOM)
    $btns = [
      ['nodeName' => 'BUTTON', 'dataset' => ['id' => 1]],
      ['nodeName' => 'BUTTON', 'dataset' => ['id' => 2]],
      ['nodeName' => 'BUTTON', 'dataset' => []],
    ];

    foreach ($btns as $btn) {
      // Skip if it doesn't have an ID
      if (!isset($btn['dataset']['id'])) continue;

      // Store and hide `data-id` attribute
      self::$idMap[spl_object_hash($btn)] = $btn['dataset']['id'];
      unset($btn['dataset']['id']);
    }
  }
}

// Initialize the ButtonIdHandler
ButtonIdHandler::init();

// Simulate a button click
$button = ['nodeName' => 'BUTTON', 'dataset' => ['id' => 1]];
ButtonIdHandler::onClickAction($button);

?>