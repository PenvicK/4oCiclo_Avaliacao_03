import React from 'react';
import '../styles/home.css';
import {Link} from "react-router-dom";

function Home(){
    return(
        <>
            <section className="container-menu">
                <ul>
                    <li>
                        <Link to="/create">
                            <button id="btn-create" type="button" className="btn-menu">CREATE</button>
                        </Link>
                    </li>
                    <li>
                        <Link to="/index">
                            <button id="btn-index" type="button" className="btn-menu">INDEX</button>
                        </Link>
                    </li>
                    <li>
                        <Link to="/show">
                            <button id="btn-show" type="button" className="btn-menu">SHOW</button>
                        </Link>
                    </li>
                    <li>    
                        <Link to="/update">
                            <button id="btn-update" type="button" className="btn-menu">UPDATE</button>
                        </Link>
                    </li>
                    <li>
                        <Link to="/delete">
                            <button id="btn-delete" type="button" className="btn-menu">DELETE</button>
                        </Link>
                    </li>                    
                </ul>
            </section>
        </>
    );
}
export default Home;