
require 'vendor/autoload.php';

use PhpParser\Error;
use PhpParser\ParserFactory;
use PhpParser\NodeTraverser;
use PhpParser\Node;
use PhpParser\NodeVisitorAbstract;

// Define the dangerous functions you want to look for
$dangerousFunctions = ['eval', 'exec', 'shell_exec', 'system', 'passthru', 'proc_open', 'popen'];

// Instantiate the parser
$parser = (new ParserFactory)->create(ParserFactory::PREFER_PHP7);

// Your PHP code
$code = file_get_contents('somefile.php'); // The PHP file you want to scan

try {
    // Parse the code into an AST
    $
