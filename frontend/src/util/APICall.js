import axios from "axios";

const BACKEND_APP_URL=process.env.REACT_APP_BACKEND_APP_URL;

function addNewURL(url)
{
    return axios.post(BACKEND_APP_URL,url).then(response=>response.data);
}
function findURLById(id)
{
    return axios.get(BACKEND_APP_URL+"/"+id).then(response=>response.data);
}

export {addNewURL,findURLById};