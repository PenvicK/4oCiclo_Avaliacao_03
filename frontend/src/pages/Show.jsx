import React, { useState, useEffect } from "react";
import "../styles/delete.css";
import "../styles/index.css";
import "../styles/show.css";
import api from "../api";
import { Link } from "react-router-dom";

function Show() {
  const [contacts, setContact] = useState();
  const [search, setSearch] = useState();

  useEffect(() => {
    showByEmail();
  }, []);

  async function handleSubmit(e) {
    e.preventDefault();
    await showByEmail(search);
  }

  async function showByEmail(search) {
    console.log(search);
    const response = await api.get("/contacts/email/" + search);

    if (response.status == 200) {
      setContact(response.data);
    } else {
      alert("Error 404");
    }
  }
  function ShowContact(props) {
    if (contacts == null) {
      return <div></div>;
    } else {
      return (
        <div id="box-show" className="box-getAll">
          <span>
            <p>
              <span>ID: </span>
              {contacts.id}
            </p>
          </span>
          <span>
            <p>
              <span>Name: </span>
              {contacts.name}
            </p>
          </span>
          <span>
            <p>
              <span>Email: </span>
              {contacts.email}
            </p>
          </span>
          <span>
            <p>
              <span>Telephone: </span>
              {contacts.telephone}
            </p>
          </span>
        </div>
      );
    }
  }
  return (
    <div className="container-delete">
      {/* {console.log("> " + contacts.name)} */}
      <Link to="/">
        <button type="button" className="btn-back-delete">
          Back
        </button>
      </Link>
      <form onSubmit={(e) => handleSubmit(e)}>
        <input
          onChange={(value) => setSearch(value.target.value)}
          value={search}
          type="email"
          className="input-create"
        />
        <button id="btn-form-submit-delete" type="submit" className="input-create">
          Submit
        </button>
      </form>
      <p>
        <ShowContact></ShowContact>
        {/* {contacts?.map((contact) => (
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
        ))} */}
      </p>
    </div>
  );
}
export default Show;
