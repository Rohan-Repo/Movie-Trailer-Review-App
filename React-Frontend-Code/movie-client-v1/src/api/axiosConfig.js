import axios from 'axios';

export default  axios.create({
    // baseURL: 'https://1d50-184-144-115-207.ngrok.io',
    baseURL: 'http://localhost:8080',
    headers: {
        // "ngrok-skip-browser-warning": "true", 
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Headers": "*"
        // "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
        // "Access-Control-Allow-Methods":"GET,PUT,POST,DELETE,PATCH,OPTIONS"  }
    // We did the above setting to not get CORS Errors and overcome our local resources
    },
});