import axios from "axios";

const instance = axios.create({
    baseURL: 'https://react-my-burger-c4484.firebaseio.com/'
});

export default instance;
