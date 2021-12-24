import { Link } from "react-router-dom";

function Navbar()
{
    return(
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <Link className="navbar-brand" to="/">URL Shortener</Link>
        </nav>
    );
}

export default Navbar;