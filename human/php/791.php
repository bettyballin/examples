<?php
$allowed_pages = array(
    'home' => 'main.php',
    'contacts' => 'contacts.php',
    'foo' => './demo_folder/foo.php',
);

if (isset($_GET['page']) && array_key_exists($_GET['page'], $allowed_pages)) {
    $p = $_GET['page'];
    $file_to_include = $allowed_pages[$_GET['page']];

    include $file_to_include;
} else {
    //fallback for when redirect does not work properly
    echo 'Page not found. Return to <a href="./">main page</a>';

    //redirect to main page
    header('Location: ./');
    exit();
}
?>