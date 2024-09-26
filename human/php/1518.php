<?php

function getUrlParam($slug) {
    if (isset($_GET[$slug])) {
        return $_GET[$slug];
    } else {
        return false;
    }
}

echo getUrlParam('parameter');

?>