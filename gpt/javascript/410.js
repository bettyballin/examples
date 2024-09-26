
    export const getUser = async (id, authToken) => {
        return instance.get(`/users/${id}.json`, {
            params: {
                auth: authToken // Use the correct parameter name
            }
        });
    }
    
