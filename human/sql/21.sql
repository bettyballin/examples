php
<?php
mysql_connect("localhost",'root','');
function escape($value) {
  $value = str_replace("'","''",$value);
  $value = str_replace("\\","\\\\",$value);
  return $value;
}

$chars=array("'","\\","\0","a");

for($w=0;$w<4;$w++){
    for($x=0;$x<4;$x++){
        for($y=0;$y<4;$y++){
            for($z=0;$z<4;$z++){
                $query = "SELECT '".escape($chars[$w].$chars[$x].$chars[$y].$chars[$z])."'";
                mysql_query($query) or die("!!!! $w $x $y $z ".mysql_error());
            }       
        }
    }
}
print "Escape function is safe :(";
?>