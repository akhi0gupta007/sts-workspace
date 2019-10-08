import axios from "axios"

class HelloWorldService {

    executeHelloWorldService() {
        return axios.get('http://localhost:8080/hello-world-bean/')
    }

    executeHelloWorldPathService(param) {
        return axios.get(`http://localhost:8080/hello-world/path-variable/${param}`)
    }
}

export default new HelloWorldService()