<?php
function redirect(string $path)
{
    header("Location: {$path}");
    exit;
}

redirect('/login');