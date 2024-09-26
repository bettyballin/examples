from jose import jwk, jwt

es384_key = {
    "kty": "EC",
    "crv": "P-384",
    "kid": "44823f3d-0b01-4a6c-a80e-b9d3e8a7226f",
    "use": "sig",
    "alg": "ES384",
    "x": "dw_JGR8nB2I6XveNxUOl2qk699ZPLM2nYI5STSdiEl9avAkrm3CkfYMbrrjr8laB",
    "y": "Sm3mLE-n1zYNla_aiE3cb3nZsL51RbC7ysw3q8aJLxGm-hx79RPMYpITDjp7kgzy"
}

allowed_aud = "http://127.0.0.1:8000/cds-services"
token = "eyJhbGciOiJFUzM4NCIsInR5cCI6IkpXVCIsImtpZCI6IjQ0ODIzZjNkLTBiMDEtNGE2Yy1hODBlLWI5ZDNlOGE3MjI2ZiIsImprdSI6Imh0dHBzOi8vc2FuZGJveC5jZHMtaG9va3Mub3JnLy53ZWxsLWtub3duL2p3a3MuanNvbiJ9.eyJpc3MiOiJodHRwczovL3NhbmRib3guY2RzLWhvb2tzLm9yZyIsImF1ZCI6Imh0dHA6Ly8xMjcuMC4wLjE6ODAwMC9jZHMtc2VydmljZXMiLCJleHAiOjE1OTQyMzA5MDAsImlhdCI6MTU5NDIzMDYwMCwianRpIjoiZWZiMzc3M2QtM2EyOC00M2UyLTlmYmMtYjkzNmE5YWUzODhiIn0.Cbey3n5NkDRoCLHZ2WMFc1z_RY8Rlq5oGxdAYfbrBPMiJXLCwjbYoU0av2CQj-Olhbnpe7Vs8vzJ5oHP5gc2-0ooc5J49t4Uz9iYKpiM9KLUrqaJe0umc_klM2-ynHAI"

payload = jwt.decode(
                token,
                es384_key,
                audience = allowed_aud,
                options = {'verify_exp':False})

print (payload)