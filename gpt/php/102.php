
   $excel = new PHPExcel();
   // ... add data to the document ...
   
   $writer = PHPExcel_IOFactory::createWriter($excel, 'Excel2007');
   $writer->setSecurity(new PHPExcel_DocumentSecurity());
   $writer->getSecurity()->setLockWindows(true);
   $writer->getSecurity()->setLockStructure(true);
   $writer->getSecurity()->setWorkbookPassword("YourPassword");
   
   $writer->save('securefile.xlsx');
   
