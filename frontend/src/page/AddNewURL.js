import { useState } from "react";
import Navbar from "../component/Navbar";
import { addNewURL } from "../util/APICall";

function AddNewURL()
{
    const [shortUrl,setShortUrl]=useState();
    const formSubmit=e=>
    {
        const url={url:e.target.elements.url.value}
        addNewURL(url).then(savedUrl=>
        {
            setShortUrl(window.location.host+"/url/"+savedUrl.id);
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
                <h3><a href={shortUrl}>{shortUrl}</a></h3>
            }
        </div>
      );
}

export default AddNewURL;