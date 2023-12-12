import { useRouter } from "next/router";
import React, { useEffect, useState } from "react";
import axios from "axios";
const criarReserva = () => {
  const router = useRouter();
  const { codigo } = router.query;
  const [reserva, setReserva] = useState({ dataViagem: "" });
  const [cliente, setCliente] = useState(null);
  const [idPacote, setIdPacote] = useState(codigo);
  const [idCliente, setIdcliente] = useState("");

  const handleSelecaoChange = (e) => {
    setIdcliente(e.target.value);
  };
  const handleInputChange = (e) => {
    if (e.target.name == "idPacote") {
      setIdPacote(e.target.value);
    }
    setReserva({ ...reserva, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    axios
      .get("http://localhost:8080/clientes")
      .then((response) => {
        setCliente(response.data);
      })
      .catch((error) => {
        console.error("erro ao buscar o pacote" + error);
      });
  }, []);
  const handleAddReserva = () => {
    axios
      .post(`http://localhost:8080/reservas/${idCliente}/${idPacote}`, reserva)

      .then((response) => {
        router.push("/reserva/lista");
      })
      .catch((error) => {
        console.error("Erro ao cadastrar reserva", error);
      });
  };
  return (
    <main>
      <div className="container formulario">
        <div className="form-floating"></div>
        <div className="form-floating mt-4">
          <input
            readOnly
            className="form-control"
            name="idPacote"
            placeholder="Leave a comment here"
            id="floatingTextarea"
            value={idPacote}
          />
          <label htmlFor="floatingTextarea">Id pacote</label>
        </div>
        <div className="form-floating mt-4">
          <input
            type="datetime-local"
            className="form-control"
            name="dataViagem"
            placeholder="Leave a comment here"
            id="floatingTextarea"
            onChange={handleInputChange}
            value={reserva.dataViagem}
          />
          <label htmlFor="floatingTextarea">Data De viagem</label>
        </div>
        <div className="form-floating mt-4">
          <select
            onChange={handleSelecaoChange}
            className="form-select"
            aria-label="Default select example"
          >
            <option value={""}>Open this select menu</option>
            {cliente &&
              cliente.map((i) => (
                <option key={i.id} value={i.id}>
                  Nome: {i.nome}
                </option>
              ))}
          </select>
          <label htmlFor="floatingTextarea">Id do cliente</label>
        </div>
        <button
          onClick={handleAddReserva}
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#collapseExample"
          aria-expanded="false"
          aria-controls="collapseExample"
          className="btn btn-primary mt-2 mb-2"
        >
          Enviar
        </button>
        <div className="collapse mt-1" id="collapseExample">
          <div className="card alert alert-success text-center card-body">
            Dados enviados com sucesso
          </div>
        </div>
      </div>
    </main>
  );
};

export default criarReserva;
