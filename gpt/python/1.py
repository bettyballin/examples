
   from cryptography import x509
   from cryptography.hazmat.backends import default_backend

   with open('certificate.pem', 'rb') as f:
       cert_data = f.read()

   cert = x509.load_pem_x509_certificate(cert_data, default_backend())
   print(cert.subject)
   print(cert.issuer)
   print(cert.not_valid_before)
   print(cert.not_valid_after)
   
