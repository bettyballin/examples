<?php
$str = 'this is a &lt;b&gt;string&lt;/b&gt;';
echo preg_replace('/&lt;[^&gt;]*&gt;/', '', $str); // output: this is a string
?>