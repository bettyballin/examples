<?php
function sanitize_text_field($input) {
    $input = trim($input);
    $input = stripslashes($input);
    $input = htmlspecialchars($input);
    return $input;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $user_id = sanitize_text_field($_POST['user_id']);
    echo $user_id;
}
?>

<form action="" method="post">
    <input type="text" name="user_id">
    <input type="submit">
</form>