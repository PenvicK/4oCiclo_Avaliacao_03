import { Component } from "react";
import React, { useState, useEffect } from "react";
import "../styles/show.css";
import api from "../api";
import { Link } from "react-router-dom";

function Show() {
  const [contacts, setContact] = useState();
  const [search, setSearch] = useState();
  
  useEffect(() => {
    handleContact();
  }, []);

  async function handleContact() {
    const response = await api.get("/contacts");

    if (response.status !== 204) {
      setContact(response.data);
    }
  }
  async function showByEmail() {
    const response = await api.get(`/contacts/${search}`);

    if (response.status !== 204) {
      setContact(response.data);
    }
  }
 const handleSubmit = (e) =>{
    e.preventDefault();
   
}
  

  return (
    <>
      <Link to="/">
        <button type="button" className="btn-back">
          Back
        </button>
      </Link>
      <form onSubmit={handleSubmit}>
        <input
          onChange={(value) => setSearch(value.target.value)}
          value={search}
          type="text"
        />
         <button id="btn-form-submit" type="submit" className="input-create">Submit</button>
        {console.log(search)}
      </form>
      <p>
        {console.log(contacts)}
        {contacts?.map((contact) => (
          <span key={contact.id}>
            <p>
              <span>ID: </span>
              {contact.id}
            </p>
            <p>
              <span>Name: </span>
              {contact.name}
            </p>
            <p>
              <span>Email: </span>
              {contact.email}
            </p>
            <p>
              <span>Telephone: </span>
              {contact.telephone}
            </p>
          </span>
        ))}
      </p>
    </>
  );
}
export default Show;
