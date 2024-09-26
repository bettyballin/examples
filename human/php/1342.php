class Gate {
    public function allows($ability, $arguments = [])
    {
        return $this->check($ability, $arguments);
    }

    protected function check($ability, $arguments)
    {
        // implement your logic here
        // for example:
        return true;
    }
}

$gate = new Gate();
echo $gate->allows('some_ability') ? 'true' : 'false';