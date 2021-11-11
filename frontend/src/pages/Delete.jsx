import React, { useState, useEffect } from "react";
import "../styles/delete.css";
import api from "../api";
import { Link } from "react-router-dom";

function Delete() {
  const [id, setId] = useState();

  useEffect(() => {
    handleContact();
  }, []);

  async function handleContact() {
    const response = await api.delete("/contacts/delete/"+id);
    console.log(id);
    if (response.status == 200) {
        alert("Contacto deleted");
    } else {
        alert("Error");
    }
  }
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(id);
    setId("");
  };

  return (
    <div className="container-delete">
      <div >
        <Link to="/" id="btn-page-delete">
          <button type="button" className="btn-back-delete">
            Back
          </button>
        </Link>
        <form onSubmit={handleContact} className="flex-delete">
          <input
            onChange={(value) => setId(value.target.value)}
            value={id}
            type="text"
            className="input-create"
            id="input-delete"
          />
          <button id="btn-form-submit-delete" type="submit" className="input-create">
            Submit
          </button>
        </form>
      </div>
    </div>
  );
}
export default Delete;
