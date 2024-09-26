
   const SSL_METHOD* method = TLS_client_method();
   SSL_CTX* ctx = SSL_CTX_new(method);
   if (!ctx) {
       // Handle error
   }
   
