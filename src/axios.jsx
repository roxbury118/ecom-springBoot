import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api",
});
delete API.defaults.headers.common["Authorization"];
export default API;
// Create a separate axios instance with default configuration

//import axios from 'axios';
//
//const instance = axios.create({
//    baseURL: 'http://localhost:8080/api',
//    headers: {
//        'Content-Type': 'application/json',
//    },
//    withCredentials: true
//});
//
//export default instance;