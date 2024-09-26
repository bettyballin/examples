$displayOptions = ['interest', 'otherOption']; // define allowed options

if (isset($_GET['display']) && in_array($_GET['display'], $displayOptions)) {
    $display = $_GET['display'];
} else {
    $display = 'interest';  //set to default by interest 
}