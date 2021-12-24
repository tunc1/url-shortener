import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Navbar from "../component/Navbar";
import { findURLById } from "../util/APICall";

function ShowURL()
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
                <a target="_blank" href={url}>Go to the URL</a>
            }
        </div>
    )
}

export default ShowURL;