<?php

function containsPHP($input) {
    $tokens = token_get_all('<?php ' . $input);

    foreach ($tokens as $token) {
        if (is_array($token)) {
            // Check for known PHP keywords or functions
            switch ($token[0]) {
                case T_EVAL:
                case T_INCLUDE:
                case T_INCLUDE_ONCE:
                case T_REQUIRE:
                case T_REQUIRE_ONCE:
                case T_FUNCTION:
                case T_CLASS:
                case T_INTERFACE:
                case T_TRAIT:
                case T_IF:
                case T_ELSEIF:
                case T_ELSE:
                case T_WHILE:
                case T_DO:
                case T_FOR:
                case T_FOREACH:
                case T_SWITCH:
                case T_CASE:
                case T_DEFAULT:
                case T_BREAK:
                case T_CONTINUE:
                case T_RETURN:
                case T_THROW:
                case T_TRY:
                case T_CATCH:
                case T_FINALLY:
                    return true;

                default:
                    break;
            }
        }
    }

    return false;
}

// Test the function
$input = 'echo "Hello World!";';
if (containsPHP($input)) {
    echo 'Input contains PHP code.';
} else {
    echo 'Input does not contain PHP code.';
}

?>