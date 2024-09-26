<?php

$counter = 0;

function foo() {
        global $counter;
        require_once('library.php');
        $counter++;
        echo "foo() has counter = $counter\n";
}

function bar() {
        global $counter;
        require_once('library.php');
        $counter++;
        echo "bar() has counter = $counter\n";
}

foo();
bar();

?>

<?php
// library.php
$counter = 0;
?>