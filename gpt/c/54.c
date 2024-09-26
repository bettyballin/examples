
// ... [previous code] ...

// Convert the HMAC result to hexadecimal and store it in resBuffer
char *header1 = "Sign: ";
char resBuffer[1024] = {0}; // Make sure to initialize the buffer
strcpy(resBuffer, header1);

// Each byte of the result needs to be converted to two hexadecimal characters
for(int i = 0; i < len; i++)
{
    // Use sprintf to append the hexadecimal representation to the buffer
    sprintf(resBuffer + strlen(resBuffer), "%02x", (unsigned int
