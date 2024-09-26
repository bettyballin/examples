<?php

define('SECRET_KEY', 'abc123');

function receive_from_api($url, $params) {
  // retrieve the hash
  list($url_without_hash, $received_hash) = retrieve_and_remove_hash($url);

  // check the hash
  $expected_hash = md5(SECRET_KEY . $url_without_hash . serialize($params));

  if ($expected_hash !== $received_hash) {
    throw new Exception('Hash mismatch');
  }

  // now do the usual stuff
}

function retrieve_and_remove_hash($url) {
  $parts = explode('#', $url);
  return array($parts[0], $parts[1]);
}

.receive_from_api('https://example.com/api/data#hash123', array('param1' => 'value1', 'param2' => 'value2'));