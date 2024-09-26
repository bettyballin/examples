<?php
$contact_id = 'your_contact_id_here'; // replace with your actual contact id
$path = '/api/contact_message_post/' . urlencode($contact_id) . "/";
echo $path;
?>