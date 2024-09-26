<?php
class A {
    const ORDER_BY_DATE = 'date';

    protected final function myMethodDefaultImplementation($param1, $param2) {
        /* subclasses can just call this method in their myMethod implementations */
        /* should do validation */
        if (!is_string($param1) || !is_int($param2)) {
            throw new InvalidArgumentException('Invalid argument types');
        }
        // implementation...
    }

    protected abstract function myMethod($param1, $param2);

    public function orderByDate() {
        return $this->orderBy(self::ORDER_BY_DATE);
    }

    private function orderBy($crit) {
        /* should do validation */
        if (!in_array($crit, [self::ORDER_BY_DATE])) {
            throw new InvalidArgumentException('Invalid order criterion');
        }
        // implementation...
    }
}