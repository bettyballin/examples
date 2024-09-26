
$allowedClasses = [
    'SafeClass' => ['safeMethod1', 'safeMethod2'],
    // ... other allowed classes and methods
];

$class = trim($_GET['c']);
$method = trim($_GET['m']);

if (isset($allowedClasses[$class]) && in_array($method, $allowedClasses[$class], true)) {
    $class::$method();
} else {
    // Handle the error appropriately
}

