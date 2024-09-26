<?php
$app = new \Illuminate\Foundation\Application();
$env = $app->detectEnvironment(function()
{
    return getenv("ENV") ?: "local";
});
print($env);
?>