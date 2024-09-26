<?php
$html = <<<EOF
<div>
  <p>This is some sample text.</p>
  <a href="https://example.com">Click here</a>
</div>
EOF;

$dom = new DOMDocument();
$dom->loadHTML($html);
print $dom->saveHTML();
?>