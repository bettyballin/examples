cpp
#include <iostream>
#include <string>
#include <curl/curl.h>

int main() {
    CURL *curl;
    CURLcode res;

    curl_global_init(CURL_GLOBAL_DEFAULT);
    curl = curl_easy_init();
    if(curl) {
        std::string postFields = "a=1&b=2";
        curl_easy_setopt(curl, CURLOPT_URL, "http://foobar.com/set.php");
        curl_easy_setopt(curl, CURLOPT_POSTFIELDS, postFields.c_str());

        struct curl_slist *headers = NULL;
        headers = curl_slist_append(headers, "Host: foobar.com");
        headers = curl_slist_append(headers, "User-Agent: something");
        headers = curl_slist_append(headers, "Accept: */*");
        headers = curl_slist_append(headers, "Content-Type: application/x-www-form-urlencoded");
        char contentLength[30];
        sprintf(contentLength, "Content-Length: %zu", postFields.size());
        headers = curl_slist_append(headers, contentLength);
        curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);

        res = curl_easy_perform(curl);
        if(res != CURLE_OK)
            std::cerr << "cURL error: " << curl_easy_strerror(res) << std::endl;

        curl_easy_cleanup(curl);
        curl_slist_free_all(headers);
    }
    curl_global_cleanup();
    return 0;
}