
$lmao = $_POST['lmao'];

// Escape for HTML output
$escaped_lmao = htmlspecialchars($lmao, ENT_QUOTES, 'UTF-8');

echo <<<EOD
<input type="text" name="lmao" value="$escaped_lmao">
EOD;

