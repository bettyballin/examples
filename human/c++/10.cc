cpp
#import <Foundation/Foundation.h>
#import <Security/Security.h>

NSData *encryptString(NSString *plainText, NSData *certificate) {
    SecCertificateRef cert = SecCertificateCreateWithData(kCFAllocatorDefault, (__bridge CFDataRef)certificate);
    SecPolicyRef policy = SecPolicyCreateBasicX509();
    SecTrustRef trust;
    OSStatus status = SecTrustCreateWithCertificates(cert, policy, &trust);

    SecTrustResultType trustResult;
    if (status == noErr) {
        status = SecTrustEvaluate(trust, &trustResult);
    }

    SecKeyRef publicKey = SecTrustCopyPublicKey(trust);

    const char *plain_text = [plainText UTF8String];
    size_t blockSize = SecKeyGetBlockSize(publicKey);
    NSMutableData *collectedCipherData = [NSMutableData data];

    BOOL success = YES;
    size_t cipherBufferSize = blockSize;
    uint8_t *cipherBuffer = malloc(blockSize);

    int i;
    for (i = 0; i < strlen(plain_text); i += blockSize-11) {
        int j;
        for (j = 0; j < blockSize-11 && plain_text[i+j] != '\0'; ++j) {
            cipherBuffer[j] = plain_text[i+j];
        }

        int result;
        if ((result = SecKeyEncrypt(publicKey, kSecPaddingPKCS1, cipherBuffer, j, cipherBuffer, &cipherBufferSize)) == errSecSuccess) {
            [collectedCipherData appendBytes:cipherBuffer length:cipherBufferSize];
        } else {
            success = NO;
            break;
        }
    }

    CFRelease(cert);
    CFRelease(policy);
    CFRelease(trust);
    CFRelease(publicKey);
    free(cipherBuffer);

    if (!success) {
        return nil;
    }

    return [NSData dataWithData:collectedCipherData];
}

int main() {
    NSString *plainText = @"Hello, World!";
    NSData *certificate = [NSData dataWithContentsOfFile:@"path_to_your_certificate"];

    NSData *encryptedData = encryptString(plainText, certificate);
    NSLog(@"%@", encryptedData);

    return 0;
}