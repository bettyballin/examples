$array = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
];

$sum = $startY = $y = $x = 0;
while( $sum < 2*count($array)-1 )
{
    echo $array[$y][$x];

    if( $x == $startY )
    {
        $sum++;
        $startY = $y = min( $sum, count($array)-1 );
        $x = $sum - $y;
    }
    else
    {
        $y--;
        $x++;
    }
}