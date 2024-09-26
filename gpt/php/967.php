
function containsPHPCode($string) {
    // List of dangerous PHP functions and constructs to check for
    $phpCodePatterns = [
        'eval\(',
        'assert\(',
        'base64_decode\(',
        'gzinflate\(',
        'str_rot13\(',
        'create_function\(',
        'passthru\(',
        'exec\(',
        'system\(',
        'shell_exec\(',
        'proc_open\(',
        'popen\(',
        'pcntl_exec\(',
        '\$_(GET|POST|REQUEST|COOKIE|SERVER|FILES)\[',
        'file
