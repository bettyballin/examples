
$expectedCheckboxValues = ['value1', 'value2']; // The values you expect
$checkboxValue = Tools::getValue('checkbox');

if (!in_array($checkboxValue, $expectedCheckboxValues)) {
    // Handle the error, the value is not allowed
}

