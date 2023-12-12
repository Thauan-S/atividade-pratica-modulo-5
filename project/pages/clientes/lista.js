import { useEffect, useState } from "react";
import axios from "axios";
import Table from "@/components/table";
const Clientes = () => {
  const [clientes, setClientes] = useState(null);
  useEffect(() => {
    axios
      .get("http://localhost:8080/clientes")
      .then((response) => {
        setClientes(response.data);
        console.log("Response", response.data);
      })
      .catch((error) => {
        console.error("Erro ao Listar os Clientes", error);
      });
  }, []);

  return (
    <div>
      <main>
        <Table clientes={clientes} />
      </main>
    </div>
  );
};

export default Clientes;
