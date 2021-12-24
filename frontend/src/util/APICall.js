import axios from "axios";

const BACKEND_APP_URL="http://localhost:8080/api/url";

function addNewURL(url)
{
    return axios.post(BACKEND_APP_URL,url).then(response=>response.data);
}
function findURLById(id)
{
    return axios.get(BACKEND_APP_URL+"/"+id).then(response=>response.data);
}

export {addNewURL,findURLById};