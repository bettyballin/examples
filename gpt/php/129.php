
$name = htmlspecialchars($_POST['name'], ENT_QUOTES, 'UTF-8');
echo "Thanks, {$name}!";

