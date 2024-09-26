
   s_binary("\\x75\\x19\\xBA\\xAB\\x03\\x00\\x00\\x00\\x00\\x00\\x00\\x00");
   s_block_start("ecx");
   s_dword(0x1A000000); // This will fuzz the DWORD value
   s_block_end("ecx");
   ...
   
