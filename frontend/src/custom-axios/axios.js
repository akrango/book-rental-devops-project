// import axios from "axios";

// const instance = axios.create({
//     baseURL: 'http://localhost:8080/api' | 'http://localhost:80/api' ,
//     headers: {
//         'Access-Control-Allow-Origin' : '*',
//         // 'Authorization': localStorage.getItem("JWT")
//     }
// })

// export default instance;
import axios from "axios";

const primaryInstance = axios.create({
    baseURL: 'http://localhost:8080/api',
    headers: {
        'Access-Control-Allow-Origin': '*',
        // Add other headers if necessary
    }
});

const fallbackInstance = axios.create({
    baseURL: 'http://localhost:80/api',
    headers: {
        'Access-Control-Allow-Origin': '*',
        // Add other headers if necessary
    }
});

export { primaryInstance, fallbackInstance };
