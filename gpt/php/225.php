
try {
    $randomInt = random_int($min, $max);
} catch (Exception $e) {
    // Handle the exception if a random number could not be generated
    error_log($e->getMessage());
    // You should have a fallback mechanism or exit the process if randomness is critical
}

