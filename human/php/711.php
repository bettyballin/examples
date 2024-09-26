<?php
$content = 'test content'; // replace with your content

if ($fl = fopen("counter.txt", "r+") && flock($fl, LOCK_EX)) {
    ftruncate($fl, 0);
    fseek($fl, 0);
    fwrite($fl, $content);
    fflush($fl);
    flock($fl, LOCK_UN);
    fclose($fl);
}
?>