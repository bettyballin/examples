import base64

encoded_bytes = b'1:Nri028S0SySkDoN0JH1Lu6HQo/Jkhq7DCZHI1MUrHOuIgCONonN14GzmhwopYQOxnjOysclhYNOnsvCLjVDLggE='

decoded_string = base64.b64decode(encoded_bytes).decode('utf-8')

print(decoded_string)