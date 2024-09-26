import ctypes

backend._lib.EVP_get_digestbyname.restype = ctypes.c_void_p
evp_md = backend._lib.EVP_get_digestbyname(algorithm.name.encode("ascii"))
if evp_md == backend._ffi.NULL:
    raise ValueError("Unknown digest algorithm")
backend.openssl_assert(evp_md != backend._ffi.NULL)