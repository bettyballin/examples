<?php
if(isset($_POST['var'])) {
    $var = htmlspecialchars($_POST['var']);
    echo "<div>$var</div>\n";
} else {
    echo "No 'var' value posted.";
}
?>