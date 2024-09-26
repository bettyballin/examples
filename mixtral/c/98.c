#include <ngx_config.h>
#include <ngx_core.h>
#include <ngx_http.h>

// Declare a custom structure to store our variable
typedef struct {
    ngx_str_t original_method;
} my_ctx_data_t;

ngx_int_t ngx_http_my_handler(ngx_http_request_t *r) {
    if (!r->error_page) {
        // Store the original method in your context
        ngx_str_t n_method;
        n_method.len = r->method_name.len;
        n_method.data = ngx_pstrdup(r->pool, &r->method_name);
        const char *n_method_str = (const char *) n_method.data;

        if (ngx_http_get_module_ctx(r, my_custom_module) == NULL) {
            // Allocate memory for your context data
            my_ctx_data_t *my_ctx = ngx_pcalloc(r->pool, sizeof(my_ctx_data_t));

            if (my_ctx != NULL) {
                // Store the original method
                my_ctx->original_method.len = r->method_name.len;
                my_ctx->original_method.data = ngx_pstrdup(r->pool, &r->method_name);

                // Set your context data
                if (ngx_http_set_ctx(r, my_custom_module, my_ctx) != NGX_OK) {
                    return NGX_ERROR;
                }
            }
        }
    } else {
        // Retrieve the original method from your context

        my_ctx_data_t *my_ctx = ngx_http_get_module_ctx(r, my_custom_module);
        if (my_ctx != NULL) {
            ngx_str_t n_method = my_ctx->original_method;
            const char *n_method_str = (const char *) n_method.data;

            // Use the original method
        }
    }
    return NGX_OK;
}