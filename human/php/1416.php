$whiteList = ['/path1/', '/path2/'];

if (isset($_GET['path']) && in_array($_GET['path'], $whiteList)) {
    echo "It's OK";
} else {
    echo "Ohnoes :(";
}