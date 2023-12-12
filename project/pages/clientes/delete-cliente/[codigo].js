import React, { useState } from "react";
import axios from "axios";
import { useRouter } from "next/router";
const DeleteCliente = () => {
  const router = useRouter();
  const { codigo } = router.query;
  const [clienteId, setClienteId] = useState(codigo);

  const handleDeleteClient = () => {
    axios
      .delete("http://localhost:8080/clientes/" + clienteId)
      .then(() => {
        router.push("/cadastro/clientes");
      })
      .catch((error) => {
        console.error("não foi possível excluir o cliente", clienteId, error);
      });
  };
  return (
    <main>
      <h1>Cliente a ser excluido</h1>
      <table>
        <tr>
          <td>
            <label>Id do cliente a ser excluido:</label>
          </td>
          <td>
            <input
              type="text"
              value={clienteId}
              onChange={(e) => setClienteId(e.target.value)}
            />
          </td>
        </tr>
        <tr>
          <td>
            <button className="btn btn-primary" onClick={handleDeleteClient}>
              excluir
            </button>
          </td>
        </tr>
      </table>
    </main>
  );
};

export default DeleteCliente;
