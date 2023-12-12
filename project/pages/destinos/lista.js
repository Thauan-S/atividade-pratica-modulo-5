import HeadComponent from "@/components/head";
import Table from "@/components/table";
import React, { useEffect, useState } from "react";
import axios from "axios";
const ListaDestinos = () => {
  const [destinos, setDestinos] = useState(null);
  useEffect(() => {
    axios
      .get("http://localhost:8080/pacotes")
      .then((response) => {
        setDestinos(response.data);
      })
      .catch((error) => {
        console.error("erro ao buscar a lista de Contatos", error);
      });
  }, []);
  return (
    <>
      <HeadComponent title={"Lista | Destinos"} />
      <main>
        <Table destinos={destinos} />
      </main>
    </>
  );
};

export default ListaDestinos;
