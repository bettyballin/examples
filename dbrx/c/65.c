#include <openssl/cms.h>
#include <openssl/bio.h>
#include <openssl/err.h>

int main() {
    BIO *in = NULL;
    CMS_ContentInfo *cms = NULL;

    // Create a BIO
    in = BIO_new(BIO_s_mem());

    // Load data into the BIO
    // Replace "your_data" with the actual data
    char *your_data = "your_data";
    BIO_puts(in, your_data);

    // Use d2i_CMS_bio
    cms = d2i_CMS_bio(in, NULL);

    // Or use PEM_read_bio_CMS
    // CMS_ContentInfo *cont = NULL;
    // cont = PEM_read_bio_CMS(in, NULL, NULL, NULL);

    // Print the result
    if (cms != NULL) {
        printf("CMS successfully loaded\n");
    } else {
        printf("Failed to load CMS\n");
    }

    // Clean up
    CMS_ContentInfo_free(cms);
    BIO_free(in);
    return 0;
}