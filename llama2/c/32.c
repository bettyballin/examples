#include <librtlsdr-spike.h>

int main() {
    // Initialize the SPK context
    spk_context_t ctx;
    spk_init(&ctx, NULL);

    // Create a new fuzzing session
    spk_session_t sess;
    spk_create_session(&sess, &ctx, "my_fuzzer", SPK_SESSION_TYPE_FUZZER);

    // Define the input buffer and its properties
    uint8_t in_buf[1024];
    spk_input_t in;
    in.data = in_buf;
    in.len = 1024;
    in.capacity = 1024;

    // Define the output buffer and its properties
    uint8_t out_buf[1024];
    spk_output_t out;
    out.data = out_buf;
    out.len = 1024;
    out.capacity = 1024;

    // Set up the fuzzing parameters
    spk_fuzzing_params_t params;

    // Initialize fuzzing parameters
    spk_init_fuzzing_params(&params);

    // Run the fuzzing session
    spk_run_session(&sess, &in, &out, &params);

    // Clean up
    spk_free_session(&sess);
    spk_free_context(&ctx);

    return 0;
}