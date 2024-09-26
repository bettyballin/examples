<?php
// /www/application/root/index.php

// Autoload components
spl_autoload_register(function ($class) {
    $file = '../includes/' . $class . '.php';
    if (file_exists($file)) {
        require $file;
    }
});

// Initialize the application
$app = new Application();

// Run the application
$app->run();



<?php
// /www/application/includes/Application.php

class Application {
    public function run() {
        // Your application logic here
        echo "Hello, World!";
    }
}