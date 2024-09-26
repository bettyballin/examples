
use MathPHP\Algebra;

// Assuming $formula is a string like '(A + 5) * 3'
// and $value is the value to substitute in place of 'A'
$formula = str_replace('A', $value, $formula);

// Use the expression parser from the library
$result = Algebra::evaluate($formula);

