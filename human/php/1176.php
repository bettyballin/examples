<?php
$counter = 1;
echo "Counter is $counter\n";

function foo() {
  global $counter;
  echo "foo() has counter = $counter\n";
}

function bar() {
  global $counter;
  echo "bar() has counter = $counter\n";
}

foo();
bar();
?>