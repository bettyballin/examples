<?php

class SampleClass {
  //Returns the Parent Account Name of the specified Contact
  public function sampleFunction($contactid){

    $getParentCustomer = '
                        <Retrieve xmlns="http://schemas.microsoft.com/xrm/2011/Contracts/Services" xmlns:i="http://www.w3.org/2001/XMLSchema-instance">
                          <entityName>contact</entityName>
                          <id>'.$contactid.'</id>
                          <columnSet xmlns:a="http://schemas.microsoft.com/xrm/2011/Contracts">
                            <a:AllColumns>false</a:AllColumns>
                            <a:Columns xmlns:b="http://schemas.microsoft.com/2003/10/Serialization/Arrays">
                              <b:string>parentcustomeridname</b:string>
                            </a:Columns>
                          </columnSet>
                        </Retrieve>';

    $getParentCustomerResult = $this->sendQuery($getParentCustomer, 'Retrieve');

    $responsedom = new DomDocument();
    $responsedom->loadXML($getParentCustomerResult);
    $KeyValuePairs = $responsedom->getElementsByTagName("KeyValuePairOfstringanyType");

    foreach($KeyValuePairs as $results) {
      if ($results->childNodes->item(0)->nodeValue == "parentcustomeridname") {
        return $results->childNodes->item(1)->childNodes->item(0)->nodeValue;
      }
      else {
        return 'No Result';
      }
    }
  }

  public function sendQuery($query, $action) {
    // Your implementation for sending query and getting result
  }
}

// Create an instance of the class
$sampleClass = new SampleClass();

// Call the function with a contact ID
$contactId = 'your_contact_id';
echo $sampleClass->sampleFunction($contactId);

?>