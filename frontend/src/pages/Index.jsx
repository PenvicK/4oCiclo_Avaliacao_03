import { Component } from "react";
import React from "react";
import "../styles/index.css";
import api from "../api";
import { Link } from "react-router-dom";

class Index extends Component {
  state = {
    contacts: [],
  };

  async componentDidMount() {
    const responseContacts = await api.get("/contacts");
    this.setState({ contacts: responseContacts.data });
  }

  render() {
    const { contacts } = this.state;
    return (
      <div className="container-index">
        <Link to="/" id="btn-page-index">
          <button type="button" className="btn-back-index">
            Back
          </button>
        </Link>
        <div className="container-getAll">
          {console.log(contacts)}
          {contacts.map((contact) => (
            <div key={contact.id} className="box-getAll">
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
            </div>
          ))}
          
        </div>
      </div>
    );
  }
}
export default Index;
