<?php

$characters = [
    $_POST['first_character'],
    $_POST['second_character'],
    $_POST['third_character'],
    // ...
    $_POST['nth_character']
];

// Example usage
echo '<form method="post">';
echo 'First Character: <input type="text" name="first_character"><br>';
echo 'Second Character: <input type="text" name="second_character"><br>';
echo 'Third Character: <input type="text" name="third_character"><br>';
// ...
echo 'Nth Character: <input type="text" name="nth_character"><br>';
echo '<input type="submit">';
echo '</form>';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $characters = [
        $_POST['first_character'],
        $_POST['second_character'],
        $_POST['third_character'],
        // ...
        $_POST['nth_character']
    ];

    print_r($characters);
}