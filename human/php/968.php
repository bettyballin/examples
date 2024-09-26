<?php
if (defined('ENVIRONMENT'))
{
    switch (ENVIRONMENT)
    {
        case 'development':
            //redirect or show the error message
            echo "Error in development environment";
        break;

        case 'testing':
        case 'production':
            error_reporting(0);
        break;

        default:
            exit('The application environment is not set correctly.');
    }
} else {
    define('ENVIRONMENT', 'development'); // or 'testing', 'production'
    // Rest of your code here...
}