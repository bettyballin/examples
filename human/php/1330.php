<?php
while($row = mysql_fetch_row($result)) {
    echo "<tr>";
    echo "<td><img src='uploads/$row[6].jpg' height='150px' width='300px'></td>";
    echo "</tr>\n";
}
?>