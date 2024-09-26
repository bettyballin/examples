
// Validate user input
$sampleSize = filter_var($_POST['sampleSize'], FILTER_VALIDATE_INT);
$numberOfSamples = filter_var($_POST['numberOfSamples'], FILTER_VALIDATE_INT);
$randAlgorithm = filter_var($_POST['randAlgorithm'], FILTER_VALIDATE_INT);

// Check if the input is valid
if ($sampleSize === false || $numberOfSamples === false || $randAlgorithm
