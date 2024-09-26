<?php

// Define a Twig template for the custom control
$template = <<<EOF
<div>
    {% if hasPermission('edit') %}
        <input type="text" name="username">
    {% elseif hasPermission('readonly') %}
        {{ username }}
    {% endif %}
</div>
EOF;

require_once 'vendor/autoload.php';
$twig = new Twig\Environment(new Twig\Loader\ArrayLoader([
    'template' => $template,
]));

class PermissionExtension extends Twig\Extension\AbstractExtension
{
    public function getFunctions()
    {
        return [
            new Twig\TwigFunction('hasPermission', [$this, 'hasPermission']),
        ];
    }

    public function hasPermission($permission)
    {
        // Implement your permission logic here
        // For demonstration purposes, I'll just return true for 'edit' and false for 'readonly'
        if ($permission == 'edit') {
            return true;
        } elseif ($permission == 'readonly') {
            return false;
        }
    }
}

$twig->addExtension(new PermissionExtension());

$username = 'John Doe';

echo $twig->render('template', ['username' => $username]);

?>