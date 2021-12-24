import Navbar from "../component/Navbar";

function AddNewURL()
{
    const formSubmit=e=>
    {
        const url={url:e.target.elements.url.value}
        console.log(url);
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
        </div>
      );
}

export default AddNewURL;