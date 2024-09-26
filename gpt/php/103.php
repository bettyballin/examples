
function calculatePasswordEntropy($password) {
    $N = countPossibleSymbols($password);
    $L = strlen($password);
    $entropy = $L * (log($N, 2)); // log(N, 2) is the same as log2(N)
    return $entropy;
}

function countPossibleSymbols($password) {
    $ranges = [
        'lower' => 'abcdefghijklmnopqrstuvwxyz',
        'upper' => 'ABCDEFGHIJKLMNOPQRSTUVWXYZ',
        'digits' => '0123456789',
        'special' => ' !"#$%&\'()*+,-./:;<=>?@[\]^_`{|}~', // adjust the special characters as needed
    ];

    $uniqueChars = count_chars($password, 3);
   
