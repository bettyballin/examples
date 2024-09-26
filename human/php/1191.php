<?php
$allowable_tags = array(
  '<p>',
  '<h1>',
  '<h2>',
  '<h3>',
  '<strong>',
  '<em>',
);

// assuming $db is a database connection object
$db = new mysqli('localhost', 'username', 'password', 'database');

$page_id = 1; // replace with actual page id

$content =  $db->get($page_id);

echo strip_tags($content,implode('',$allowable_tags));

$db->close();
?>