<?php
if(isset($_SERVER['HTTP_REFERER']) && strpos($_SERVER['HTTP_REFERER'], 'http://www.domain.com/search') === 0) {
    // do stuff
    echo "Referrer is valid";
} else {
    echo "Referrer is not valid";
}
?>