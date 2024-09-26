<?php
$user_input = "Hello, 'world' & foo < bar";
echo htmlspecialchars($user_input, ENT_QUOTES | ENT_SUBSTITUTE);
?>