import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Navbar from "../component/Navbar";
import { findURLById } from "../util/APICall";

function ShowURL({i18n})
{
    const {id}=useParams();
    const [url,setUrl]=useState();
    const fetchUrl=()=>
    {
        findURLById(id).then(a=>setUrl(a.url));
    };
    useEffect(fetchUrl,[]);
    return(
        <div>
            <Navbar/>
            {
                url&&
                <a target="_blank" href={url}>{i18n.goToTheUrl}</a>
            }
        </div>
    )
}

export default ShowURL;