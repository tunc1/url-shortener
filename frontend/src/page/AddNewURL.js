import { useState} from "react";
import Navbar from "../component/Navbar";
import { addNewURL } from "../util/APICall";
import { Link } from "react-router-dom";

function AddNewURL({i18n})
{
    const [shortUrl,setShortUrl]=useState();
    const rootUrl=window.location.host+"/";
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
                <input type="text" className="form-control" placeholder={i18n.enterUrl} name="url"/>
                <input type="submit" className="btn btn-success" value={i18n.add}/>
                <input type="reset" className="btn btn-warning" value={i18n.clear}/>
            </form>
            {
                shortUrl&&
                <h3><Link to={shortUrl}>{rootUrl+shortUrl}</Link></h3>
            }
        </div>
      );
}

export default AddNewURL;