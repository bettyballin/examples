
if (isset($_POST['CUSTFEEDBACK'])) {
    $feedback = strip_tags($_POST['CUSTFEEDBACK']);
    $addition = 'Feedback: ' . $feedback . "\n";
    $file_open = fopen("FDBKCOLLECTION.PHP", "a+"); 
    fwrite($file_open, $addition);
    fclose($file_open);
}

