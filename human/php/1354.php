<?php

class GenericHeader {
    public static function splitHeaderLine($headerLine) {
        return explode(':', $headerLine, 2);
    }
}

class Exception\InvalidArgumentException extends \Exception {}

interface MultipleHeaderInterface {
    public function toStringMultipleHeaders(array $headers);
}

class ContentSecurityPolicy {
    protected $fieldName;
    protected $fieldValue;

    public function __construct($fieldName, $fieldValue) {
        $this->fieldName = $fieldName;
        $this->fieldValue = $fieldValue;
    }

    public function getFieldName() {
        return $this->fieldName;
    }

    public function getFieldValue() {
        return $this->fieldValue;
    }
}

class MultiContentSecurityPolicy extends ContentSecurityPolicy implements MultipleHeaderInterface {

    public static function fromString($headerLine)
    {
        list($fieldName, $fieldValue) = GenericHeader::splitHeaderLine($headerLine);
        if (strpos($fieldValue, ';')) {
            $headers = [];
            foreach (explode(';', $fieldValue) as $multiValue) {
                $headers[] = new static($fieldName, $multiValue);
            }
            return $headers;
        } else {
            $header = new static($fieldName, $fieldValue);
            return $header;
        }
    }

    public function toStringMultipleHeaders(array $headers)
    {
        $name  = $this->getFieldName();
        $values = [$this->getFieldValue()];
        foreach ($headers as $header) {
            if (! $header instanceof static) {
                throw new Exception\InvalidArgumentException(
                    'This method toStringMultipleHeaders was expecting an array of headers of the same type'
                );
            }
            $values[] = $header->getFieldValue();
        }
        return $name . ': ' . implode(';', $values) . "\r\n";
    }

}

$headerLine = "Content-Security-Policy: default-src 'self'; script-src 'self' https://example.com";
$headers = MultiContentSecurityPolicy::fromString($headerLine);

if (is_array($headers)) {
    foreach ($headers as $header) {
        echo $header->toStringMultipleHeaders($headers);
    }
} else {
    echo $headers->toStringMultipleHeaders([$headers]);
}