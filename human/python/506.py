from Crypto.Cipher import AES

k = '57067125438768260656188878670043'
key = bytes(k, 'ascii')
i = '5706712543876826'
iv = bytes(i, 'ascii') 
n = 4
cipher = 'afc6f435d3bb68234bba2d39840d4c61cd0d45810940cf796ebf4078e1c0b2368caf618dd6c915fa3f9e0245372cc0dd9992d71aa3ac9e811a579a1d39fa9e26b0d1728d290f4bfa54931917afb45c49a815937498923e241a3eded50dff67ff18d9c1259404f1bdbafef7df5aba0c0b2aacc18079b6bb64058a7976246c0231b2178312c9a008dfa3bd954eef12c73d0b3adac8aa2f4733fe09767dc08741997a6243642d7a5fc627eede9fbeea9f9d931f90daa1cc6a760e352a36d55f22ea1a8bb4bd993d96f4cd006ad9de128d7ea9cd74b875ac2c55e62905b67eb354b5bac48961940fbdc1c0dc58ebc3b7356cb95c11505c8d9bbecc8670d7327ed5fcffd3577ed7d87adf628c5b44cb92c1e33f66715d2d429d3a62dc88a80fc3a3b4a720e9680b4ff444d4e87057a7fbe66afba6bffd96b641bfb03c0802528e30768c5695db92d0dd4f4db3d5301c17ed37accbe3c89d2c70d4fbb3e40d30164b640154fa9ecd5565b11af24f40fe91fbca3966ce1632a3dbbd6c1af432b2100a9f7136834fc00609170b6cf66a3861bf9aa1902292152ba6efdefeacc4d4d37e20896a42243f3ec2f4ae463cfa455e92d4df33688cb127ade64dbad056b1614fe2f2a32b0b2536a23f4b019511df378778c374413629e7afe83a047fe6745de19397193e7082f8ab27b4b41695f43abd9c'

def unpad(s):
    return s[:-ord(s[len(s)-1:])]

def decrypt(cipherId):
    dec = AES.new(key, AES.MODE_CBC, iv)
    cipher = bytes.fromhex(cipherId)
    id = dec.decrypt(cipher)
    node_dec = unpad(id.decode('ISO-8859-1'))
    return node_dec

if __name__ == '__main__':
    x = decrypt(cipher)
    result = ""
    for i in range(n - 1):
        y = decrypt(x.encode('ISO-8859-1').hex())
        x = y
        result = x

    print(result)