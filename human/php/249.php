<?php
$time = microtime(true);
for ($i=1;$i<=10000;$i++)
    generateMath();

echo 'Generating '.$i.' math Took '.(microtime(true)-$time);

function generateMath()
{
    $operands = array(43,45,42);
    $val = chr(rand(48,57));
    $ope = chr($operands[rand(0,2)]);
    $txt = $val.$ope; //42* 43+ 45- 47/
    $val2 = chr(rand(48,57));
    $txt .= $val2;
    $ans = 0;
    if ($ope == '+')
        $ans = ord($val) + ord($val2);
    else if ($ope == '-')
        $ans = ord($val) - ord($val2);
    else if ($ope == '*')
        $ans = ord($val) * ord($val2);
    echo $txt.' -> '.$ans.'<br/>';
}
?>