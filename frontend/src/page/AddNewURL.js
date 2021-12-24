import { useState } from "react";
import Navbar from "../component/Navbar";
import { addNewURL } from "../util/APICall";
import { Link } from "react-router-dom";

function AddNewURL()
{
    const [shortUrl,setShortUrl]=useState();
    const formSubmit=e=>
    {
        const url={url:e.target.elements.url.value}
        addNewURL(url).then(savedUrl=>
        {
            setShortUrl("url/"+savedUrl.id);
        });
        e.preventDefault();
    };
    return (
        <div className="App">
            <Navbar/>
            <form onSubmit={formSubmit}>
                <input type="text" className="form-control" placeholder="Enter Url" name="url"/>
                <input type="submit" className="btn btn-success" value="Add"/>
                <input type="reset" className="btn btn-warning" value="Clear"/>
            </form>
            {
                shortUrl&&
                <h3><Link to={shortUrl}>{window.location.host+"/"+shortUrl}</Link></h3>
            }
        </div>
      );
}

export default AddNewURL;