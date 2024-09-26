<?php
$data = array(
    array("John", "dsfa9p8y098hasdf", "00000000"),
    array("Paul", "po43pokdfgpo3k4y", "00000000"),
    array("John", "dsfa9p8y098hasdf", "00000000")
);

foreach ($data as $row) {
    echo implode(" ", $row) . "\n";
}
?>