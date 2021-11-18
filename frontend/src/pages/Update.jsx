import React, { useState, useEffect } from "react";
import api from "../api";
import { Link } from "react-router-dom";

function Update() {
    const [id, setId] = useState("");
    const [contactName, setName] = useState("");
    const [contactEmail, setEmail] = useState("");
    const [contactTelephone, setTelephone] = useState("");

    const handleSubmit = (e) =>{
        e.preventDefault();
        const editContacts = {
            name: contactName,
            email: contactEmail,
            telephone: contactTelephone
        }
        editContact(editContacts);
        setId("");
        setName("");
        setEmail("");
        setTelephone("");

    }
    async function editContact(editContacts) {
        console.log(id);
        const response = await api.put("/contacts/" + id, editContacts);
    
      }
  return (
    <div>
      <form onSubmit={handleSubmit}>
        <Link to="/" id="btn-page-create">
          <button type="button" className="btn-back-create">
            Back
          </button>
        </Link>
        <ul className="ul-create">
        <li>
            <input
              onChange={(value) => setId(value.target.value)}
              value={id}
              className="input-create"
              type="number"
              placeholder="Id"
              id="id"
            ></input>
          </li>
          <li>
            <input
              onChange={(value) => setName(value.target.value)}
              value={contactName}
              className="input-create"
              type="text"
              placeholder="Name"
              id="name"
            ></input>
          </li>
          <li>
            <input
              onChange={(value) => setEmail(value.target.value)}
              value={contactEmail}
              className="input-create"
              type="text"
              placeholder="Email"
              id="email"
            ></input>
          </li>
          <li>
            <input
              onChange={(value) => setTelephone(value.target.value)}
              value={contactTelephone}
              className="input-create"
              type="text"
              placeholder="Telephone"
              id="telephone"
            ></input>
          </li>
          <li>
            <button
              id="btn-form-submit-create"
              type="submit"
              className="input-create"
            >
              Edit
            </button>
          </li>
        </ul>
      </form>
    </div>
  );
}
export default Update;
