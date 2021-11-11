import React, { useState } from 'react';
import '../styles/home.css';
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
        });

        // const handleChangeName = (e) =>{
        //     setName(e.target.value)
        //     e.preventDefault();
        // }
        // const handleChangeEmail = (e) =>{
        //     setEmail(e.target.value)
        //     e.preventDefault();
        // }
        // const handleChangeTelephone = (e) =>{
        //     setTelephone(e.target.value)
        //     e.preventDefault();
        // }

    }
    return(
        <>
            <form className="form-create" onSubmit={handleSubmit}>
                <Link to="/">
                    <button type="button" className="btn-back">Back</button>
                </Link>
                <ul>
                    <li>
                        <input onChange={value => setName(value.target.value)} value={contactName} className="input-create" type="text" placeholder="Name"></input>
                    </li>
                    <li>
                        <input onChange={value => setEmail(value.target.value)} value={contactEmail} className="input-create" type="text" placeholder="Email"></input>
                    </li>
                    <li>
                        <input onChange={value => setTelephone(value.target.value)} value={contactTelephone} className="input-create" type="text" placeholder="Telephone"></input>
                    </li>
                    <li>
                        <button id="btn-form-submit" type="submit" className="input-create">Submit</button>
                    </li>
                </ul>
            </form>
        </>
    );
}
export default Create;