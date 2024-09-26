#include <openssl/x509.h>
#include <openssl/x509_vfy.h>

// assuming certificateStore is a valid X509_STORE structure
// and verificationCallback is a valid callback function

X509_VERIFY_PARAM_set_flags(certificateStore->param, X509_V_FLAG_CB_ISSUER_CHECK);
X509_STORE_set_verify_cb_func(certificateStore, verificationCallback);