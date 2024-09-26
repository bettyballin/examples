<?php
$text = "A combination of genetic and environmental factors play a role in the development of schizophrenia.";
print preg_match("/\b(genetic|environmental)\b/", $text);
?>