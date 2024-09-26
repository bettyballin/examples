&lt;?php
interface AjaxCallable {}

class MyClass implements AjaxCallable 
{
    public static function myMethod()
    {
        echo "Hello, World!";
    }
}

$class = $_POST['class'];
$method = $_POST['method'];

if ( class_exists( $class ) &amp;&amp; in_array( 'AjaxCallable', class_implements( $class ) ) ) {
    call_user_func( array($class, $method) );
}