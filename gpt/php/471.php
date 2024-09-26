
function evaluate_expression($expr) {
    // Define callbacks for each operation
    $operations = [
        'and' => function ($a, $b) { return $a && $b; },
        'or' => function ($a, $b) { return $a || $
