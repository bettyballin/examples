<?php
$code = htmlspecialchars($fetched_data['code'], ENT_QUOTES | ENT_SUBSTITUTE);
echo "<pre><code>$code</code></pre>";
?>