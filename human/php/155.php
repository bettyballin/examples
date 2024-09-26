<?php
$time = 30; //in minutes, time until file deletion threshold
foreach (glob("app/temp/*.tmp") as $filename) {
    if (file_exists($filename)) {
        if(time() - filemtime($filename) > $time * 60) {
            unlink($filename);
        }
    }
}
?>