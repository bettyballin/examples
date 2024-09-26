/**
 * custom validator
 */
class myValidatorOldPassword extends sfValidatorBase{

    /**
     * Clean and validate user input
     *
     * @param mixed $value Value of form input
     * @return mixed Value 
     */
    protected function doClean($value)
    {
        // trim is not needed
        $clean = (string) $value;

        // password is ok?
        if (strlen($clean) > 0)
        {
            return hash('sha512', $clean);
        }

        // Throw error - if you want
        // throw new sfValidatorError($this, 'invalid', array('value' => $value)); 

        // or return empty value
        return $clean;
    }

}