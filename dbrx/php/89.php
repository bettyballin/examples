<?php

use PhpParser\Error;
use PhpParser\NodeDumper;
use PhpParser\NodeTraverser;
use PhpParser\ParserFactory;

$serializedData = '<?php echo "Hello World!"; ?>'; // replace with your serialized data

$parser = (new ParserFactory())->create(ParserFactory::PREFER_PHP7);
try {
    $ast = $parser->parse($serializedData);
} catch (Error $error) {
    echo "Parse error: {$error->getMessage()}\n";
    return;
}

// Traverse the AST and filter out unwanted nodes
$traverser = new NodeTraverser();
$filteredAst = $traverser->traverse($ast);

// Convert filtered AST back to serialized data or an array
$dumper = new NodeDumper();
echo "Filtered AST:\n" . $dumper->dump($filteredAst) . "\n";

?>