import React, { useEffect, useState } from "react";
import axios from "axios";
import Table from "@/components/table";
import HeadComponent from "@/components/head";

const Contato = () => {
  const [contatos, setContatos] = useState(null);
  useEffect(() => {
    axios
      .get("http://localhost:8080/contatos")
      .then((response) => {
        setContatos(response.data);
      })
      .then((error) => {
        console.error("erro ao buscar os contatos", error);
      });
  }, []);
  return (
    <div>
      <HeadComponent title={"Lista | Contatos"} />
      <main>
        <Table contatos={contatos} />
      </main>
    </div>
  );
};

export default Contato;
