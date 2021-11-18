import React, { useState } from 'react';
import '../styles/create.css';
import api from "../api";
import {Link} from "react-router-dom";

function Create(){

    const [contactName, setName] = useState("");
    const [contactEmail, setEmail] = useState("");
    const [contactTelephone, setTelephone] = useState("");

    const handleSubmit = (e) =>{
        e.preventDefault();
        const postContacts = {
            name: contactName,
            email: contactEmail,
            telephone: contactTelephone
        }
        api.post('/contacts', postContacts).then((resp) => {
            console.log(resp);
        
        }   );
        setName("");
        setEmail("");
        setTelephone("");

    }
    return(
        <div className="form-create">
            <form onSubmit={handleSubmit}>
                <Link to="/" id="btn-page-create">
                    <button type="button" className="btn-back-create">Back</button>
                </Link>
                <ul className="ul-create">
                    <li>
                        <input onChange={value => setName(value.target.value)} value={contactName} className="input-create" type="text" placeholder="Name" id="name"></input>
                    </li>
                    <li>
                        <input onChange={value => setEmail(value.target.value)} value={contactEmail} className="input-create" type="text" placeholder="Email" id="email"></input>
                    </li>
                    <li>
                        <input onChange={value => setTelephone(value.target.value)} value={contactTelephone} className="input-create" type="text" placeholder="Telephone" id="telephone"></input>
                    </li>
                    <li>
                        <button id="btn-form-submit-create" type="submit" className="input-create">Submit</button>
                    </li>
                </ul>
            </form>
        </div>
    );
}
export default Create;