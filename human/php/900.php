function pdia_dismiss() {
    // pdia.dismiss() equivalent code in PHP
}

$result = null; // assuming result is a variable

$tokenInterface = new class {
    public function onTaskCompleteString($code, $message) {
        // tokenInterface.onTaskCompleteString equivalent code in PHP
    }
};

if ($result !== null) {
    $tokenInterface->onTaskCompleteString(1, $result);
} else {
    $tokenInterface->onTaskCompleteString(2, "");
}