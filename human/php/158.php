<?php
$StrongSalt = 'your_strong_salt_here';
$UserID = 'your_user_id_here';

echo hash('sha512', 'MyPassword' . $StrongSalt . $UserID);
?>