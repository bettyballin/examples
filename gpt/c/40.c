
    if ((st.st_mode & S_IWGRP) != 0 && st.st_gid != egid) {
        return 0;
    }
    
